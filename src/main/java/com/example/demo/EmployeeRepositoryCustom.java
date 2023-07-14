package com.example.demo;

import java.util.List;

public interface EmployeeRepositoryCustom {
    List<Employee> findEmployeesByName(String name);

}
