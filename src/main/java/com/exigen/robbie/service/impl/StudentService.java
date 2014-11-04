package com.exigen.robbie.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exigen.robbie.commons.BeseService;
import com.exigen.robbie.dao.IStudentDao;
import com.exigen.robbie.domain.Student;
import com.exigen.robbie.service.IStudentService;

@Service
//@WebService(endpointInterface = "com.exigen.robbie.service.IStudentService", serviceName = "HelloStudentService")
@Transactional
public class StudentService extends BeseService<Student, String> implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	
	@Autowired
	public StudentService(IStudentDao studentDao) {
		super(studentDao);
		this.studentDao = studentDao;
	}
	
	public List<Student> findByClassId(String classId) {
		return studentDao.findByClazzId(classId);
	}

	public Page<Student> findAll(Pageable pageable) {
		return studentDao.findAll(pageable);
	}

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String sayHi(String text) {
		return "Hello, my darling " + text;
	}
}
