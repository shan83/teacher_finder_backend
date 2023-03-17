package com.shan83.classfinder.util;

import com.shan83.classfinder.dto.AddResponse;
import com.shan83.classfinder.dto.SubjectResponse;
import com.shan83.classfinder.model.Add;
import com.shan83.classfinder.model.District;
import com.shan83.classfinder.model.Subject;

import java.util.stream.Collectors;

public class AddMapper {

    public static AddResponse mapAddsToResponse(Add add) {
        AddResponse addResponse = new AddResponse();
        addResponse.setText(add.getText());
        addResponse.setTeacherName(add.getTeacher().getName());
        addResponse.setFees(add.getTeacher().getFees());
        addResponse.setPlace(String.join(",", add.getTeacher().getDistricts().stream()
                .map(District::getNameEn)
                .collect(Collectors.toList())));
        return addResponse;
    }
}
