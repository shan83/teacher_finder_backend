package com.shan83.classfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {

    private String name;
    private BigDecimal fees;
    private String contactNumber;
    private String whatsAppNumber;
    private List<String> districts;
    private List<String> subjects;
    private List<String> mediums;


}
