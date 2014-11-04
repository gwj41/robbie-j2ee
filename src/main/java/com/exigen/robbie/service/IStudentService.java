package com.exigen.robbie.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.exigen.robbie.commons.IBaseService;
import com.exigen.robbie.domain.Student;

@WebService
public interface IStudentService extends IBaseService<Student, String> {

	public List<Student> findByClassId(String classId);
	
	public String sayHi(String text);
}
