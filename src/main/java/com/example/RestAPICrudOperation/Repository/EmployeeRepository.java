package com.example.RestAPICrudOperation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestAPICrudOperation.Entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public  List<Employee> findByEmpAgeLessThan(int empAge);

	public Employee findByEmpEmailAndPassword(String empEmail, String password);

}
