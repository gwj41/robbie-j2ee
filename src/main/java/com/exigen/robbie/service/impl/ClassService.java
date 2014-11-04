package com.exigen.robbie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exigen.robbie.commons.BeseService;
import com.exigen.robbie.dao.IClassDao;
import com.exigen.robbie.domain.Class;
import com.exigen.robbie.service.IClassService;
import javax.annotation.Resource;

@Service
@Transactional
public class ClassService extends BeseService<Class, String> implements IClassService {

	@Autowired
	private IClassDao classDao;
	
	@Autowired
	public ClassService(IClassDao classDao) {
		super(classDao);
		this.classDao = classDao;
	}
	
	public Page<Class> getAll(Pageable pageable) {
		return classDao.findAll(pageable);
	}

	public void save(Class entity) {
		classDao.save(entity);
	}

	public void delete(Class entity) {
		classDao.delete(entity);
	}

	public void delete(String id) {
		classDao.delete(id);
	}

	public List<Class> getAll(String orderBy, boolean isAsc) {
		return getAll(orderBy, isAsc);
	}
}
