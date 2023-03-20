
package com.baeldung.jaxws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EmployeeService", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeService {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.baeldung.jaxws.client.Employee
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEmployee", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/", className = "com.baeldung.jaxws.client.GetEmployee")
    @ResponseWrapper(localName = "getEmployeeResponse", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/", className = "com.baeldung.jaxws.client.GetEmployeeResponse")
    @Action(input = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/getEmployeeRequest", output = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/getEmployeeResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/getEmployee/Fault/Exception")
    })
    public Employee getEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.baeldung.jaxws.client.Employee
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addEmployee", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/", className = "com.baeldung.jaxws.client.AddEmployee")
    @ResponseWrapper(localName = "addEmployeeResponse", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/", className = "com.baeldung.jaxws.client.AddEmployeeResponse")
    @Action(input = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/addEmployeeRequest", output = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/addEmployeeResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/addEmployee/Fault/Exception")
    })
    public Employee addEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteEmployee", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/", className = "com.baeldung.jaxws.client.DeleteEmployee")
    @ResponseWrapper(localName = "deleteEmployeeResponse", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/", className = "com.baeldung.jaxws.client.DeleteEmployeeResponse")
    @Action(input = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/deleteEmployeeRequest", output = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/deleteEmployeeResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/deleteEmployee/Fault/Exception")
    })
    public boolean deleteEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.baeldung.jaxws.client.Employee
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateEmployee", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/", className = "com.baeldung.jaxws.client.UpdateEmployee")
    @ResponseWrapper(localName = "updateEmployeeResponse", targetNamespace = "http://bottomup.server.jaxws.baeldung.com/", className = "com.baeldung.jaxws.client.UpdateEmployeeResponse")
    @Action(input = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/updateEmployeeRequest", output = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/updateEmployeeResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://bottomup.server.jaxws.baeldung.com/EmployeeService/updateEmployee/Fault/Exception")
    })
    public Employee updateEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws Exception_Exception
    ;

}
