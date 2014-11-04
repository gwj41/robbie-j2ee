package com.exigen.robbie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exigen.robbie.commons.BeseService;
import com.exigen.robbie.dao.IContentDao;
import com.exigen.robbie.domain.Content;
import com.exigen.robbie.service.IContentService;
import javax.annotation.Resource;

@Service
@Transactional
public class ContentService extends BeseService<Content, String> implements IContentService{

	@Autowired
	private IContentDao contentDao;
	
	@Autowired
	public ContentService(IContentDao contentDao) {
		super(contentDao);
		this.contentDao = contentDao;
	}
	
	public void save(Content entity) {
		contentDao.save(entity);
	}

	public void delete(Content entity) {
		contentDao.delete(entity);
	}

	public void delete(String id) {
		contentDao.delete(id);
	}

	public Content findOne(String id) {
		return contentDao.findOne(id);
	}

	public List<Content> findAll() {
		return (List<Content>) contentDao.findAll();
	}

	public List<Content> getAll(String orderBy, boolean isAsc) {
		return getAll(orderBy, isAsc);
	}
}
