package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {
    @Autowired
    EmployeeRepositoryImpl employeeRepository;
    @GetMapping("/testRequest")
    public RequestModel TestReport(){
        return new RequestModel(200,"ok",employeeRepository.findEmployeesByName("Максим"));
    }
}
