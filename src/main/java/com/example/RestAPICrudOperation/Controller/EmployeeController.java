package com.example.RestAPICrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.RestAPICrudOperation.Entities.Employee;
import com.example.RestAPICrudOperation.Service.EmployeeServiceI;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
    
	@PostMapping(value = "/saveEmployee",consumes = {"application/xml", "application/json"}, produces = {"application/xml", "application/json"})
	public ResponseEntity<Employee> saveEmployee(@RequestBody  Employee emp)
	{
		Employee employee = employeeServiceI.saveEmployee(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllEmployee", produces = {"application/xml", "application/json"})
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> allEmployee = employeeServiceI.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
	}

	@PostMapping(value = "/saveMultipleEmployee", consumes = {"application/xml", "application/json"}, produces = {"application/xml", "application/json"})
	public ResponseEntity<List<Employee>> saveMultipleEmployee(@RequestBody List<Employee> list)
	{
		System.out.println(list);
		List<Employee> saveMultipleEmployee = employeeServiceI.saveMultipleEmployee(list);
		return new ResponseEntity<List<Employee>>(saveMultipleEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getEmployeeByIdPathParam/{empid}" , produces = {"application/json"})
	public ResponseEntity<Employee> getEmployeeByIdPathParam(@PathVariable int empid)
	{
		Employee employeeByIdPathParam = employeeServiceI.getEmployeeByIdPathParam(empid);
		return new ResponseEntity<Employee>(employeeByIdPathParam, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmployeeByIdQueryParam", produces = {"application/json"})
	public ResponseEntity<Employee> getEmployeeByIdQueryParam(@RequestParam int empid)
	{
		Employee employeeByIdQueryParam = employeeServiceI.getEmployeeByIdQueryParam(empid);
		return new ResponseEntity<Employee>(employeeByIdQueryParam, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getEmployeeByRequestBody" , produces = {"application/json"},consumes = {"application/json"})
	public ResponseEntity<Employee> getEmployeeByRequestBody(@RequestBody Employee emp)
	{
		System.out.println(emp);
		 Employee requestBody = employeeServiceI.getEmployeeRequestBody(emp);
		return new ResponseEntity<Employee>(requestBody, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmpAgeLessThan/{empAge}", produces = "application/json")
	public ResponseEntity<List<Employee>> getEmpAgeLessThan(@PathVariable int empAge)
	{
		List<Employee> list=employeeServiceI.getAgeLessThan(empAge);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateEmployee", consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		Employee employee = employeeServiceI.updateEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/loginCheck/{empEmail}/{password}")
	public ResponseEntity<String> loginCheck(@PathVariable String empEmail, @PathVariable String password)
	{
		boolean loginCheck = employeeServiceI.LoginCheck(empEmail, password);
		
		if(loginCheck)
		{
			String msg="Login Successful";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		else
		{
			String msg1="Login Unsuccessful";
			return new ResponseEntity<String>(msg1, HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/deleteEmployeeById/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int empId)
	{
		boolean deleteEmpById = employeeServiceI.deleteEmpById(empId);
		
		if(deleteEmpById)
		{
			return new ResponseEntity<String>("Id deleted", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Id not deleted", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll()
	{
		boolean deleteAllEmployee = employeeServiceI.deleteAllEmployee();
		
		if(deleteAllEmployee)
		{
			return new ResponseEntity<String>("All Employee Deleted", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Employee Not Deleted", HttpStatus.OK);
		}
	}
	
	
	
	@PutMapping(value = "/updateMultipleEmployee", consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<List<Employee>> updateMultipleEmployee(@RequestBody List<Employee> list)
	{
		System.out.println(list);
		List<Employee> updateMultipleEmployee = employeeServiceI.updateMultipleEmployee(list);
		return new ResponseEntity<List<Employee>>(updateMultipleEmployee, HttpStatus.CREATED);
	}
	
	
}
