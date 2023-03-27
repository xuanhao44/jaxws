# answer

1. In the top-down service, can the client use **getEmployee**, **updateEmployee** methods? Please explain.

No, in the top-down approach described in this web page context, the client can only use the `countEmployees` method. This is because only this method is defined in the WSDL file provided in the tutorial. The WSDL file defines the contract between the service and its clients and specifies what operations are available to be called by clients. In this case, only `countEmployees` operation is defined in the WSDL file.

2. If we want the client connected to the bottom-up web service to use **countEmployees** method, what modification should we do in the **EmployeeService.java** and **EmployeeServiceImpl.java**?

Add a new method named `countEmployees` to the EmployeeService.java. Then publish the service again.

3. What is GlassFish?

GlassFish is an open-source application server for the Java EE platform. It is sponsored by the Eclipse Foundation and provides a Jakarta EE compatible implementation. Oracle GlassFish Server is based on GlassFish Server Open Source Edition.

（using New bing）
