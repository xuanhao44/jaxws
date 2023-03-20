package com.baeldung.jaxws.server;

import com.baeldung.jaxws.server.bottomup.EmployeeServiceImpl;
// import com.baeldung.jaxws.server.topdown.EmployeeServiceTopDownImpl;
import javax.xml.ws.Endpoint;

public class EmployeeServicePublisher {
    public static void main(String[] args) {
        // Endpoint.publish("http://localhost:8080/employeeservicetopdown", new EmployeeServiceTopDownImpl()); // publish topdown service
        Endpoint.publish("http://localhost:8080/employeeservice", new EmployeeServiceImpl()); // publish bottomup service
    }
}