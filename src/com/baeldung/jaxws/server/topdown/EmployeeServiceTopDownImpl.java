package com.baeldung.jaxws.server.topdown;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.baeldung.jaxws.server.Employee;
import com.baeldung.jaxws.server.repository.EmployeeRepository;
import com.baeldung.jaxws.server.repository.EmployeeRepositoryImpl;

@WebService(
		name = "EmployeeServiceTopDown",
		endpointInterface = "com.baeldung.jaxws.com.baeldung.jaxws.server.topdown.EmployeeServiceTopDown",
		targetNamespace = "http://topdown.server.jaxws.baeldung.com/"
)

public class EmployeeServiceTopDownImpl implements EmployeeServiceTopDown {
	@Inject
	private final EmployeeRepository employeeRepositoryImpl = new EmployeeRepositoryImpl();

	@WebMethod
	public Employee getEmployee(int id) throws Exception {
		return employeeRepositoryImpl.getEmployee(id);
	}

	@WebMethod
	public Employee updateEmployee(int id, String name) throws Exception {
		return employeeRepositoryImpl.updateEmployee(id, name);
	}

	@WebMethod
	public boolean deleteEmployee(int id) throws Exception {
		return employeeRepositoryImpl.deleteEmployee(id);
	}

	@WebMethod
	public Employee addEmployee(int id, String name) throws Exception {
		return employeeRepositoryImpl.addEmployee(id, name);
	}

	@WebMethod
	public int countEmployees() {
		return employeeRepositoryImpl.count();
	}
}
