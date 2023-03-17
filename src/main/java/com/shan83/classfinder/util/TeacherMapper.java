package com.shan83.classfinder.util;

import com.shan83.classfinder.dto.TeacherResponse;
import com.shan83.classfinder.model.District;
import com.shan83.classfinder.model.Medium;
import com.shan83.classfinder.model.Subject;
import com.shan83.classfinder.model.Teacher;

import java.util.stream.Collectors;

public class TeacherMapper {

    public static TeacherResponse mapToTeacherResponse(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setFees(teacher.getFees());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setContactNumber(teacher.getContactNumber());
        teacherResponse.setWhatsAppNumber(teacher.getWhatsAppNumber() != null ? teacher.getWhatsAppNumber() : teacher.getContactNumber());
        teacherResponse.setMediums(
                teacher.getMediums().stream().map(Medium::getName)
                        .collect(Collectors.toList())
        );
        teacherResponse.setSubjects(
                teacher.getSubjects().stream().map(Subject::getName)
                        .collect(Collectors.toList())
        );
        teacherResponse.setDistricts(
                teacher.getDistricts().stream().map(District::getNameEn)
                        .collect(Collectors.toList())
        );
        return teacherResponse;
    }
}
