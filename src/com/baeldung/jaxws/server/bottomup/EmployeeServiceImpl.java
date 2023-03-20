package com.baeldung.jaxws.server.bottomup;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.lang.Exception;
import com.baeldung.jaxws.server.repository.EmployeeRepository;
import com.baeldung.jaxws.server.repository.EmployeeRepositoryImpl;
import com.baeldung.jaxws.server.Employee;

@WebService(endpointInterface = "com.baeldung.jaxws.server.bottomup.EmployeeService")

public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeRepository employeeRepositoryImpl = new EmployeeRepositoryImpl();

    @WebMethod
    public Employee getEmployee(int id) throws Exception{
        return employeeRepositoryImpl.getEmployee(id);
    }

    @WebMethod
    public Employee updateEmployee(int id, String name) throws Exception{
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

