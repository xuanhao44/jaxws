package com.baeldung.jaxws.server.repository;

import com.baeldung.jaxws.server.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	// the implementation of functions we want to provide for client
	private List<Employee> employeeList;

	public EmployeeRepositoryImpl() {
		employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "Jane"));
		employeeList.add(new Employee(2, "Jack"));
		employeeList.add(new Employee(3, "George"));
	}

	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	public Employee getEmployee(int id) throws Exception {
		for (Employee emp : employeeList) {
			if (emp.getId() == id) {
				return emp;
			}
		}
		throw new Exception();
	}

	public Employee updateEmployee(int id, String name) throws Exception {
		for (Employee employee1 : employeeList) {
			if (employee1.getId() == id) {
				employee1.setId(id);
				employee1.setFirstName(name);
				return employee1;
			}
		}
		throw new Exception();
	}

	public boolean deleteEmployee(int id) throws Exception {
		for (Employee emp : employeeList) {
			if (emp.getId() == id) {
				employeeList.remove(emp);
				return true;
			}
		}
		throw new Exception();
	}

	public Employee addEmployee(int id, String name) throws Exception {
		for (Employee emp : employeeList) {
			if (emp.getId() == id) {
				throw new Exception();
			}
		}
		Employee employee = new Employee(id, name);
		employeeList.add(employee);
		return employee;
	}

	public int count() {
		return employeeList.size();
	}
}
