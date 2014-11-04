package com.exigen.robbie.dao;

import java.util.List;

import com.exigen.robbie.commons.EntityDao;
import com.exigen.robbie.domain.Student;

public interface IStudentDao extends EntityDao<Student, String> {

	public List<Student> findByClazzId(String classId);
}
