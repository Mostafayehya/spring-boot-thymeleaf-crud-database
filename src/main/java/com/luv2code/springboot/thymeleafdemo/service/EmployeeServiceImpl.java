package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {

		this.employeRepository = theEmployeeRepository;
		// TODO Auto-generated constructor stub
	}

	@Override

	public List<Employee> findAll() {

		return employeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> result = employeRepository.findById(id);
		
		Employee theEmployee=null;
		
		if(result.isPresent()) {
			
			theEmployee = result.get();
		} else {
			
			throw new RuntimeException("Can't find the employee id - "+ id);
		}
		return theEmployee;

	}

	@Override

	public void saveEmployee(Employee employee) {

		employeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(int id) {

		employeRepository.deleteById(id);
	}

}
