package com.example.demo;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
public class RequestModel {
    private Integer code;
    private String message;
    private List data;
}
