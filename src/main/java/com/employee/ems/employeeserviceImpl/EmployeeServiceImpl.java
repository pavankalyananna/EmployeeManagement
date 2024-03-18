package com.employee.ems.employeeserviceImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.ems.dto.EmployeeDto;
import com.employee.ems.entity.Employee;
import com.employee.ems.exception.ResourceNotFoundException;
import com.employee.ems.mapper.EmployeeMapper;
import com.employee.ems.repository.EmployeeRepository;
import com.employee.ems.service.EmployeeService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository  repository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		
		Employee savedEmployee=repository.save(employee);
		
		
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeId(Long id) {
		
		Employee employee=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee not exist"+id));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> list=repository.findAll();
		
		return list.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto,Long id) {
		
		Employee e=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("no id found"+id));
		e.setFirstName(employeeDto.getFirstName());
		e.setLastName(employeeDto.getLastName());
		e.setEmail(employeeDto.getEmail());
		Employee employee=repository.save(e);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public void deleteEmployee(Long id) {
		
		Employee e=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id not found"+id));
		repository.deleteById(id);
		
	}
	

}
