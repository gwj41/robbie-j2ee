package com.exigen.robbie.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IWebserviceTest {
	@WebMethod(operationName = "sayHelloToRobbie")
	public String sayHello(@WebParam(name="username") String username);
	
//	public String sayHaha(String username);
}
