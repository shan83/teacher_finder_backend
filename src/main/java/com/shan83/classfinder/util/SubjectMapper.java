package com.shan83.classfinder.util;

import com.shan83.classfinder.dto.SubjectResponse;
import com.shan83.classfinder.model.Subject;

public class SubjectMapper {

    public static SubjectResponse mapSubjectsToResponse(Subject subject) {
        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.setId(subject.getId());
        subjectResponse.setName(subject.getName());
        return subjectResponse;
    }
}
