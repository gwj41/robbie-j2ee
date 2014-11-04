package com.exigen.robbie.service.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exigen.robbie.service.IWebserviceTest;

@Service
@WebService(endpointInterface = "com.exigen.robbie.service.IWebserviceTest",
	serviceName = "helloService",
	targetNamespace = "http://service.robbie.exigen.com/")
@Transactional
public class WebserviceTest implements IWebserviceTest {

	@Override
	public String sayHello(@WebParam(name="username"
			) String username) {
		return "hello, my baby " + username;
	}
	
	public static void main(String args[]) throws Exception {
        // START SNIPPET: client
        /*ClassPathXmlApplicationContext context 
            = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});

        IWebserviceTest client = (IWebserviceTest)context.getBean("client");

        String response = client.sayHello("Joe");
        System.out.println("Response: " + response);
        System.exit(0);*/
        // END SNIPPET: client
        
    	JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:8080/robbie-j2ee/services/helloService?wsdl");  

        Object[] objects = client.invoke("sayHello",new Object[]{"skydream"});
        System.out.println(objects[0].toString());
    }
}