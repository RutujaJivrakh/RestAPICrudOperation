package com.example.RestAPICrudOperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestAPICrudOperation.Entities.Employee;
import com.example.RestAPICrudOperation.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee emp) {
        Employee save = employeeRepository.save(emp);
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
        List<Employee> finadAll=employeeRepository.findAll();
		return finadAll;
	}

	@Override
	public List<Employee> saveMultipleEmployee(List<Employee> list) {
        List<Employee> saveAll = employeeRepository.saveAll(list);
		return saveAll;
	}

	@Override
	public Employee getEmployeeByIdPathParam(int empID) {
          Employee finadById = employeeRepository.findById(empID).get();
		return finadById;
	}

	@Override
	public Employee getEmployeeByIdQueryParam(int empID) {
        Employee findById = employeeRepository.findById(empID).get();
		return findById;
	}

	@Override
	public Employee getEmployeeRequestBody(Employee emp) {
        int empid=emp.getEmpId();
        Employee employee = employeeRepository.findById(empid).get();
		return employee;
	}

	@Override
	public List<Employee> getAgeLessThan(int empAge) {
        List<Employee> list=employeeRepository.findByEmpAgeLessThan(empAge);
		return list;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
        Employee save=employeeRepository.save(emp);
		return save;
	}

	@Override
	public boolean LoginCheck(String email, String password) {
        Employee emp = employeeRepository.findByEmpEmailAndPassword(email,password);
        if(emp!=null)
        {
        	return true;
        }
        else
		   return false;
	}

	@Override
	public boolean deleteEmpById(int id) {
        boolean existsById=employeeRepository.existsById(id);
		if(existsById)
		{
			employeeRepository.deleteById(id);
			return true;
		}
		else
		{
          return false;
		}
	}

	@Override
	public boolean deleteAllEmployee() {
        List<Employee> finadAll=employeeRepository.findAll();
        if(finadAll!=null)
        {
        	employeeRepository.deleteAll();
        	return true;
        }
        else
        {
		  return false;
        }
		
	}

	@Override
	public List<Employee> updateMultipleEmployee(List<Employee> list) {
		 List<Employee> saveAll = employeeRepository.saveAll(list);
			return saveAll;		
	}

	

	

	
}
