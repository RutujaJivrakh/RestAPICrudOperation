package com.example.RestAPICrudOperation.Service;

import java.util.List;

import com.example.RestAPICrudOperation.Entities.Employee;


public interface EmployeeServiceI {

	public Employee saveEmployee(Employee emp);
	
	public List<Employee> saveMultipleEmployee(List<Employee> list);
	
	public Employee getEmployeeByIdPathParam(int empID);
	
	public Employee getEmployeeByIdQueryParam(int empID);

	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeRequestBody(Employee emp);
	
	public List<Employee>getAgeLessThan(int empAge);
	
	public Employee updateEmployee(Employee emp);
	
	public List<Employee> updateMultipleEmployee(List<Employee> list);

	public boolean LoginCheck(String email,String password);
	
	public boolean deleteEmpById(int id);
	
	public boolean deleteAllEmployee();
	
}
