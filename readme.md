# Web Service Tutorial

## Creating and Connecting to SOAP Web Service using JAX-WS

> 使用 JAX-WS 创建并连接到 SOAP Web 服务

[Java API for XML Web Services (JAX-WS)](http://jax-ws.java.net/) is a standardized API for creating and consuming SOAP (Simple Object Access Protocol) web services.

In this Tutorial, we'll create a SOAP web service and connect to it using JAX-WS.

在本教程中，我们将创建一个 SOAP web 服务，并使用 JAX-WS 连接到它。

JAX-WS is a framework that simplifies using SOAP.

JAX-WS 是一个简化 SOAP 使用的框架。

## Tools

> 工具

To follow this tutorial, you need to prepare the following tools:

要学习本教程，你需要准备以下工具:

1. A Java Development kit(JDK). Please download JDK (jdk 8 Standard Edition)
   from https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html.

   Java 开发工具包(JDK)。JDK(JDK 8 SE)请从 https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html 下载。

2. The **Inject** java package. The Package can be downloaded
   from https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html.

   Inject java 包。该包可以从 https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html 下载。

此 API 似乎在高版本的 JDK 中被移除了，所以使用如 JDK 17/18/19 的版本无法成功导入所要使用的包。

## Introduction

> 介绍

The web service built on JAX-WS can be divided into two parts: a server and a client. The client is quite easy, because we can use wsimport tool, a web service tool provided by java, to generate client code automatically. Let's focus on the server first.

构建在 JAX-WS 上的 web 服务可以分为两部分：服务器和客户机。客户端相当简单，因为我们可以使用 java 提供的 web 服务工具 wsimport tool 来自动生成客户端代码。让我们先关注一下服务器。

## Server

> 服务器

There are two ways of building SOAP web services. We can go with a top-down approach or a bottom-up approach.

有两种构建 SOAP web 服务的方法。我们可以采用自顶向下的方法或自底向上的方法。

In a top-down (contract-first) approach, a WSDL document is created, and the necessary Java classes are generated from the WSDL. In a bottom-up (contract-last) approach, the Java classes are written, and the WSDL is generated from the Java classes.

在自顶向下(契约优先)方法中，创建 WSDL 文档，并从 WSDL 生成必要的 Java 类。在自底向上(最后合同)方法中，编写 Java 类，并从 Java 类生成 WSDL。

Writing a WSDL file can be quite difficult depending on how complex your web service is. This makes the bottom-up approach an easier option. On the other hand, since your WSDL is generated from the Java classes, any change in code might cause a change in the WSDL. This is not the case for the top-down approach.

编写 WSDL 文件可能相当困难，这取决于您的 web 服务有多复杂。这使得自底向上方法成为一种更容易的选择。另一方面，由于您的 WSDL 是从 Java 类生成的，因此代码中的任何更改都可能导致 WSDL 的更改。这不是自顶向下方法的情况。 

In this tutorial, we'll take a look at both approaches.

在本教程中，我们将看看这两种方法。

## Prerequisite

> 先决条件

The service discussed in this tutorial provides employee information. We would like to let our client check the information about employees in our company. Hence, we first have to prepare some classes about our employee. Please copy the following code and build packages respectively.

本教程中讨论的服务提供员工信息。我们希望让我们的客户查看我们公司的员工信息。因此，我们首先要准备一些关于我们员工的类。请复制以下代码并分别构建包页面。

1.	[Employee.java](src/com/baeldung/jaxws/server/Employee.java)
2.	[EmployeeRepository.java](src/com/baeldung/jaxws/server/repository/EmployeeRepository.java)
3.	[EmployeeRepositoryImpl.java](src/com/baeldung/jaxws/server/repository/EmployeeRepositoryImpl.java)

## Top-down Approach

> 自顶向下方法

1.  In the top-down approach, we define our service in WSDL (Web Service Definition Language) file. The following shows the code in our WSDL file named *employeeservicetopdown.wsdl*. If You want to know more about the WSDL, please recall information you have learned in Module 3; You can also check this [blog](https://www.baeldung.com/jax-ws). Create the below WSDL file under your java project.

    在自顶向下的方法中，我们用 WSDL(Web 服务定义语言)文件定义我们的服务。下面显示了名为 *employeeservicetopdown.wsdl* 的 WSDL 文件中的代码。如果您想了解更多 WSDL 的信息，请回忆一下您在模块 3 中学到的信息；也可以查看这篇 [博客](https://www.baeldung.com/jax-ws)。在 java 项目下创建下面的 WSDL 文件。

[employeeservicetopdown.wsdl](employeeservicetopdown.wsdl)

2.  Generate server code using wsimport command

   > 使用 wsimport 命令生成服务器代码

   To generate web service source files from a WSDL document, we can use the *wsimport* tool which is part of JDK (at [$JAVA HOME](https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux)/bin). Open windows cmd and execute:

   要从 WSDL 文档生成 web 服务源文件，我们可以使用 wsimport 工具，它是 JDK 的一部分(位于[$JAVA_HOME](https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux)/bin)。打开 windows cmd 并执行：

   ```shell
   cd \path\to\javaproject
   wsimport -s src\ -p com.baeldung.jaxws.server.topdown employeeservicetopdown.wsdl
   ```

   Wsimport is the java tool provided by your jdk. You should find it in your **%JAVA_HOME%\bin** directory. In my case, I find it in `C:\Program Files\Java\jdk1.8.0_241\bin` directory.

   Wsimport 是 jdk 提供的 java 工具。您应该在您的 **%JAVA_HOME%\bin** 目录。在我的例子中，我在 `C:\Program
   Files\Java\jdk1.8.0_241\bin` 目录中找到它。

   The parameter -s src\ means we store generated source codes in topdown directory.

   参数 -s src\ 表示我们将生成的源代码存储在 topdown 目录中。

   The parameter **-p com.baeldung.jaxws.server.topdown** means the generated code are in the package topdown.

   参数 **-p com.baeldung.jaxws.server.topdown** 表示生成的代码在 topdown 包中。

   The wsimport tool has generated the web service endpoint interface *EmployeeServiceTopDown*. It declares the web service methods.
   
wsimport 工具已经生成了 web 服务端点接口 *EmployeeServiceTopDown*。它声明了 web 服务方法。
   
The generated files:
   
> 生成的文件：
   
   - *EmployeeServiceTopDown.java* - is the service endpoint interface (SEI) that contains method definitions
   
     > 包含方法定义的服务端点接口(SEI)
   
   - *ObjectFactory.java* - contains factory methods to create instances of schema derived classes programmatically
   
        > 包含工厂方法，以编程方式创建模式派生类的实例
   
   - *EmployeeServiceTopDown_Service.java* - is the service provider class that can be used by a JAX-WS client
   
        > 可以被 JAX-WS 客户机使用的服务提供程序类
   
If you get all the files above, then congratulations, let's go to next step. If you have problem at this stage, this link might help. https://www.baeldung.com/jax-ws. You can also ask questions in our WeChat group.
   
   如果你得到了上面所有的文件，那么恭喜你，让我们进入下一步。如果你在这个阶段有问题，这个链接可能会有帮助。https://www.baeldung.com/jax-ws。你也可以在我们的微信群里提问。

3. Implement our service

   > 实现我们的服务

   In step 2, we already got the service endpoint interface that contains method definitions. Next, we have to implement the methods in the interface.Create EmployeeServiceTopDownImpl.java in topdown package.

   在步骤 2 中，我们已经获得了包含方法定义的服务端点接口。接下来，我们必须实现接口中的方法。在 topdown 包中创建 EmployeeServiceTopDownImpl.java。

   [EmployeeServiceTopDownImpl.java](src/com/baeldung/jaxws/server/topdown/EmployeeServiceTopDownImpl.java)

4. Publish our service

   > 发布我们的服务

   Once we implement the service endpoint interface, the server is finished successfully. To publish the web services (top-down and bottom-up), we need to pass an address and an instance of the web service implementation to the *publish()* method of the *javax.xml.ws.Endpoint* class.

   一旦我们实现了服务端点接口，服务器就成功完成了。要发布 web 服务(自上而下和自下而上)，我们需要将 web 服务实现的地址和实例传递给 *javax.xml.ws.Endpoint* 类的 *publish()* 方法。

   [EmployeeServicePublisher.java](src/com/baeldung/jaxws/server/EmployeeServicePublisher.java)

   We can now run *EmployeeServicePublisher* to start the web service. To make use of CDI features, the web services can be deployed as WAR file to application servers like WildFly or GlassFish.
   
现在我们可以运行 *EmployeeServicePublisher* 来启动 web 服务。为了利用 CDI 特性，web 服务可以作为 WAR 文件部署到应用服务器上，如 WildFly 或 GlassFish。

**Tips：**

1. 在项目文件目录下，调用 wsimport，不会设置 JAVA_HOME 的话可以直接调用 wsimport.exe，比如我就是直接用 `C:\Users\Shiro\.jdks\corretto-1.8.0_362\bin\wsimport.exe` 代替 wsimport。

2. wsdl 文件就放在项目文件目录一级就好：[employeeservicetopdown.wsdl](employeeservicetopdown.wsdl)。

3. -s、-p 参数理解后再调用。

   - 为了将生成的 java 文件放到 topdown 文件夹中，使用命令：

     ```shell
      C:\Users\Shiro\.jdks\corretto-1.8.0_362\bin\wsimport.exe -s src\ employeeservicetopdown.wsdl
     ```

     （发现该命令还是会生成单独的 class 编译文件，不在 out 中，可以手动删除）

   - 为了将生成的 java 文件放到 **out 文件夹**中，使用命令：（感觉没有必要，也许之后可以一起生成）

     ```shell
     C:\Users\Shiro\.jdks\corretto-1.8.0_362\bin\wsimport.exe -p out.com.baeldung.jaxws.server.topdown employeeservicetopdown.wsdl
     ```

4. 成功运行 *EmployeeServicePublisher* 即完成自顶向下的部分，不必检查服务。
## Bottom-up Approach

> 自底向上的方法

In a bottom-up approach, we have to create both the endpoint interface and the implementation classes. The WSDL is generated from the classes when the web service is published.

在自下而上的方法中，我们必须同时创建端点接口和实现类。当发布 web 服务时，WSDL 是由类生成的。

Let's create a web service that will perform simple CRUD(Create, Read, Update, Delete) operations on Employee data.

让我们创建一个 web 服务，它将对员工数据执行简单的 CRUD(创建、读取、更新、删除)操作。

1.  EmployeeService.java

   Get the service endpoint interface, corresponds to *EmployeeServiceTopDown.java* in top-down approach.

   获取服务端点接口，以自顶向下的方式对应 *EmployeeServiceTopDown.java*。

   [EmployeeService.java](src/com/baeldung/jaxws/server/bottomup/EmployeeService.java)

2.  EmployeeServiceImpl.java

    In step 1, we have created the structure of the web service. we have to create the implementation of the web service. The following is web service implementation it, corresponds to the 3rd step in top-down approach.
    
    在步骤 1 中，我们已经创建了 web 服务的结构。我们需要实现 web 服务。下面是 web 服务实现，对应于自顶向下方法的第三步。
    
    [EmployeeServiceImpl.java](src/com/baeldung/jaxws/server/bottomup/EmployeeServiceImpl.java)
    
3.  Publish the service

   > 发布服务

   Publish the bottom-up approach service just like the 4th step in top-down approach.

   发布自底向上方法服务，就像自上而下方法的第 4 步一样。

   [EmployeeServicePublisher.java](src/com/baeldung/jaxws/server/EmployeeServicePublisher.java)

## check the Published Web Service

> 检查已发布的 Web 服务

To check if the web service has been published successfully, you can open your browser and enter the following link to check the bottom-up service.

检查 web 服务是否发布成功，您可以打开浏览器，输入以下链接，查看自下而上的服务。

```html
http://localhost:8080/employeeservice?wsdl
```

You can get a result from the request like this: (none pic)

你可以从请求中得到这样的结果:

If you got the result, congratulations. We can now focus on the client part of web service.

如果你得到了结果，恭喜你。我们现在可以专注于 web 服务的客户端部分。

## Client

> 客户端

The client can use the methods defined in the service endpoint interface. We can get the code we need in the client by wsimport.

客户端可以使用服务端点接口中定义的方法。我们可以通过 wsimport 获得我们需要的客户端代码。

```shell
wsimport -keep -s src\ -p com.baeldung.jaxws.client
http://localhost:8080/employeeservice?wsdl
```

We use the wsdl file from the web service to generate our client code. **-keep** means to keep the source code. Other parameters were explained in the top-down approach section. We should add a client to try to connect the web service.

我们使用来自 web 服务的 wsdl 文件来生成我们的客户机代码。**-keep** 表示保留源代码。其他参数在自顶向下方法一节解释。我们应该添加一个客户端来尝试连接
web 服务。

[EmployeeServiceClient.java](src/com/baeldung/jaxws/client/EmployeeServiceClient.java)

The program should output "yourname" in the console.

程序应该在控制台中输出 “你的名字”。

## Tutorial Assessment

> 教程评估

1. In the top-down service, can the client use **getEmployee**, **updateEmployee** methods? Please explain.

   在 top-down 服务中，客户端可以使用 **getEmployee**, **updateEmployee** 方法吗？请解释一下。

2. If we want the client connected to the bottom-up web service to use **countEmployees** method, what modification should we do in the **EmployeeService.java** and **EmployeeServiceImpl.java**?

   如果我们希望连接到自底向上的 web 服务的客户端使用 **countEmployees** 方法， 我们应该在 **EmployeeService.java** 和 **EmployeeServiceImpl.java** 中做什么修改？

3. What is GlassFish?

   GlassFish 是什么？

## FAQ

>常见问题解答

1. The compiler shows that the **Inject** class not found.

   编译器显示没有找到注入类。

   You should add an extra package to your project. The Package can be download in https://repo1.maven.org/maven2/javax/inject/javax.inject/1/javax.inject-1.jar.

   你应该添加一个额外的包到你的项目中。该软件包可以在 https://repo1.maven.org/maven2/javax/inject/javax.inject/1/javax.inject-1.jar 下载。

2. If you have problems in this tutorial, please feel free to contact me in our WeChat group.

   如果你在本教程中有问题，请随时在我们微信群中联系我。

## References

> 参考文献

[1] https://www.baeldung.com/jax-ws

The tutorial is based on the above project.

本教程基于上述项目。
