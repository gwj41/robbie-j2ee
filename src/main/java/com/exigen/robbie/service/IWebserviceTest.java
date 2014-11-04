package com.exigen.robbie.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IWebserviceTest {
	public String sayHello(@WebParam(name="username") String username);
	
//	public String sayHaha(String username);
}
