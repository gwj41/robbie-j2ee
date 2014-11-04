package com.exigen.robbie.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class BeseService<T, PK extends Serializable> implements IBaseService<T, PK> {

	private EntityDao<T, PK> hibernateDao;
	
	public BeseService(){
	}
	
	public BeseService(EntityDao dao){
		hibernateDao = dao;
	}
	
	public List<T> findAll() {
		return (List<T>) hibernateDao.findAll();
	}
	
	public Page<T> findAll(Pageable pageable) {
		return hibernateDao.findAll(pageable);
	}

	public List<T> getAll(String orderBy, boolean isAsc) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findBy(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findUniqueBy(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public int batchExecute(String hql, Object... values) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Query createQuery(String queryString, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> find(Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}

	public T findUnique(Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria createCriteria(Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public Query distinct(Query query) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria distinct(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIdName() {
		return null;
	}

	public boolean isPropertyUnique(String propertyName, Object newValue,
			Object oldValue) {
		// TODO Auto-generated method stub
		return false;
	}

	public void save(T entity) {
		hibernateDao.save(entity);
	}

	public void delete(T entity) {
		hibernateDao.delete(entity);
	}

	public void delete(PK id) {
		// TODO Auto-generated method stub
		
	}

	public T get(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findByIds(List<PK> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X> List<X> find(String hql, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X> List<X> find(String hql, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X> X findUnique(String hql, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X> X findUnique(String hql, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return null;
	}

	public int batchExecute(String hql, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Query createQuery(String queryString, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return null;
	}

	public void initEntity(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void initEntity(List<T> entityList) {
		// TODO Auto-generated method stub
		
	}

	public Page<T> getAll(Page<T> page) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<T> findPage(Page<T> page, String hql, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<T> findPage(Page<T> page, String hql, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<T> findPage(Page<T> page, Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}

}
