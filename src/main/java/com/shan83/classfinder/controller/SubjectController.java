package com.shan83.classfinder.controller;

import com.shan83.classfinder.dto.SubjectResponse;
import com.shan83.classfinder.model.Location;
import com.shan83.classfinder.model.Subject;
import com.shan83.classfinder.service.LocationService;
import com.shan83.classfinder.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class SubjectController {

    private SubjectService subjectService;

    // Save operation
    @PostMapping("/subjects")
    public Subject saveDepartment(
            @RequestBody Subject subject)
    {
        return subjectService.saveSubject(subject);
    }

    // Read operation
    @GetMapping("/subjects")
    public List<SubjectResponse> fetchSubjectList()
    {
        return subjectService.fetchSubjectList();
    }


    // Update operation
    @PutMapping("/subjects/{id}")
    public Subject
    updateLocation(@RequestBody Subject subject,
                   @PathVariable("id") Long subjectId)
    {
        return subjectService.updateSubject(
                subject, subjectId);
    }

    // Delete operation
    @DeleteMapping("/subjects/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long subjectId)
    {
        subjectService.deleteSubjectById(
                subjectId);
        return "Deleted Successfully";
    }
}
