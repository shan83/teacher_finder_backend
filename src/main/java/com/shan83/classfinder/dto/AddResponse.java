package com.shan83.classfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddResponse {

    private String text;
    private String teacherName;
    private String place;
    private BigDecimal fees;

}
