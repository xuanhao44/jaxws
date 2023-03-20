package com.baeldung.jaxws.server.repository;

import com.baeldung.jaxws.server.Employee;

import java.util.List;

public interface EmployeeRepository {
	// interface of the function we provide
	List<Employee> getAllEmployees() throws Exception;

	Employee getEmployee(int id) throws Exception;

	Employee updateEmployee(int id, String name) throws Exception;

	boolean deleteEmployee(int id) throws Exception;

	Employee addEmployee(int id, String name) throws Exception;

	int count();
}
