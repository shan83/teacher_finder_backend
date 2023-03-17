package com.shan83.classfinder.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Message {

    private String value;

    public Message(String value) {
        this.value = value;
    }
    
    

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
