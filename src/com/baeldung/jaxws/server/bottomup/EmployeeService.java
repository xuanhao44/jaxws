package com.baeldung.jaxws.server.bottomup;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.lang.Exception;

import com.baeldung.jaxws.server.Employee;

@WebService
public interface EmployeeService {
	@WebMethod
	Employee getEmployee(int id) throws Exception;

	@WebMethod
	Employee updateEmployee(int id, String name) throws Exception;

	@WebMethod
	boolean deleteEmployee(int id) throws Exception;

	@WebMethod
	Employee addEmployee(int id, String name) throws Exception;

    // ...
}
