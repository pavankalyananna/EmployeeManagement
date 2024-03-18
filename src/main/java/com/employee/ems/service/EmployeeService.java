package com.employee.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.ems.dto.EmployeeDto;
@Service
public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeId(Long  id);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updateEmployee(EmployeeDto employeeDto,Long id);

	
	void deleteEmployee(Long id);
}
