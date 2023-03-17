package com.shan83.classfinder.controller;

import com.shan83.classfinder.dto.TeacherRequest;
import com.shan83.classfinder.dto.TeacherResponse;
import com.shan83.classfinder.model.Teacher;
import com.shan83.classfinder.service.TeacherService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000/")
public class TeacherController {

    private TeacherService teacherService;

    // Save operation
    @PostMapping("/teachers")
    public Teacher saveDepartment(
             @RequestBody TeacherRequest teacher)
    {
        return teacherService.saveTeacher(teacher);
    }

    // Read operation
    @GetMapping("/teachers/search")
    public List<TeacherResponse> fetchTeacherList(@RequestParam(required = false, value = "searchString") String searchString)
    {
        log.info("searchString : " + searchString);
        return teacherService.findByTeacherLocationsIsLike(searchString);
    }

    @GetMapping("/teachers/search/{city}")
    public List<TeacherResponse> fetchTeacherListByCity(@PathVariable String city)
    {
        log.info("searchString : " + city);
        return teacherService.findByTeacherByCity(city);
    }

    @GetMapping("/teachers")
    public List<TeacherResponse> fetchTeacherList()
    {
        return teacherService.fetchTeacherList();
    }


    // Update operation
    @PutMapping("/teachers/{id}")
    public Teacher
    updateDepartment(@RequestBody Teacher teacher,
                     @PathVariable("id") Long teacherId)
    {
        return teacherService.updateTeacher(
                teacher, teacherId);
    }

    // Delete operation
    @DeleteMapping("/teachers/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        teacherService.deleteTeacherById(
                departmentId);
        return "Deleted Successfully";
    }
}
