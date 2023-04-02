package com.furkan.bussines.services;

import com.furkan.bussines.dto.EmployeeDto;
import com.furkan.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {

    // CRUD
    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    ResponseEntity<EmployeeDto> getEmployeeById(Long id) throws Throwable;

    ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) throws Throwable;

    ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id) throws Throwable;

    // model
    EmployeeDto EntityToDto(EmployeeEntity employeeEntity);
    EmployeeEntity DtoToEntity(EmployeeDto entityDto);
}
