package com.shan83.classfinder.service;

import com.shan83.classfinder.dto.TeacherRequest;
import com.shan83.classfinder.dto.TeacherResponse;
import com.shan83.classfinder.model.*;
import com.shan83.classfinder.repository.*;
import com.shan83.classfinder.util.TeacherMapper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class TeacherService {

    private TeacherRepository teacherRepository;
    private DistrictRepository districtRepository;
    private SubjectRepository subjectRepository;
    private MediumRepository mediumRepository;
    private CityRepository cityRepository;

    // Save operation
    public Teacher saveTeacher(TeacherRequest teacher)
    {
        Teacher teacherNew = new Teacher();
        List<Subject> subjects = new ArrayList<>();
        List<District> districts = new ArrayList<>();
        List<Medium> mediumList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(teacher.getDistricts())) {
            teacher.getDistricts().forEach(d -> {
                District district = districtRepository.findByNameEn(d);
                districts.add(district);
            });
            teacherNew.setDistricts(districts);
        }
        if (!CollectionUtils.isEmpty(teacher.getSubjects())) {
            teacher.getSubjects().forEach(s -> {
                Subject subject = subjectRepository.findByName(s);
                subjects.add(subject);
            });
            teacherNew.setSubjects(subjects);
        }
        if (!CollectionUtils.isEmpty(teacher.getMediums())) {
            teacher.getMediums().forEach(s -> {
                Medium medium = mediumRepository.findByName(s);
                mediumList.add(medium);
            });
            teacherNew.setMediums(mediumList);
        }
        teacherNew.setName(teacher.getName());
        teacherNew.setContactNumber(teacher.getContactNumber());
        teacherNew.setWhatsAppNumber(teacher.getWhatsAppNumber());
        teacherNew.setFees(teacher.getFees());
        return teacherRepository.save(teacherNew);
    }

    // Read operation
    @Cacheable(value = "teachers")
    public List<TeacherResponse> fetchTeacherList()
    {
        return teacherRepository.findAll().stream().map(TeacherMapper::mapToTeacherResponse).toList();
    }

    // Read operation
    public List<TeacherResponse> findByTeacherLocationsIsLike(String searchString)
    {
        return teacherRepository.fetchBySearchString(searchString).stream().map(TeacherMapper::mapToTeacherResponse).toList();
    }

    @Cacheable(value = "teachers", key = "#city")
    public List<TeacherResponse> findByTeacherByCity(String city)
    {
        City city1 = cityRepository.findByNameEn(city);
        String district = city;
        if (city1 != null) {
            district = city1.getDistrict().getNameEn();
        }
        return teacherRepository.fetchByCity(district).stream().map(TeacherMapper::mapToTeacherResponse).toList();
    }

    // Update operation

    @CachePut(cacheNames = "teachers", key = "#teacher.pkId")
    public Teacher
    updateTeacher(Teacher teacher,
                     Long teacherId)
    {
        Teacher depDB
                = teacherRepository.findById(teacherId)
                .get();

        if (Objects.nonNull(teacher.getName())
                && !"".equalsIgnoreCase(
                teacher.getName())) {
            depDB.setName(
                    teacher.getName());
        }
        return teacherRepository.save(depDB);
    }

    // Delete operation
    @CacheEvict(cacheNames="teachers", key="#teacherId")
    public void deleteTeacherById(Long teacherId)
    {
        teacherRepository.deleteById(teacherId);
    }

}
