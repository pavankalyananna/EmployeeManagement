package com.employee.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.ems.dto.EmployeeDto;
import com.employee.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto savedEmployee=service.createEmployee(employeeDto);
		if(savedEmployee!=null)
		System.out.print(savedEmployee.getEmail());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")  Long id)
	{
		
		EmployeeDto employeeDto=service.getEmployeeId(id);
		return ResponseEntity.ok(employeeDto);
	}

	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employee=service.getAllEmployee();
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employee,@PathVariable("id") Long id)
	{
		EmployeeDto employee1=service.updateEmployee(employee, id);
		return ResponseEntity.ok(employee1);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id)
	{
		service.deleteEmployee(id);
		return ResponseEntity.ok("deleted");
	}
}
