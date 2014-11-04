package com.exigen.robbie.commons;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface EntityDao<T, PK extends Serializable> extends CrudRepository<T, Serializable> {

	public Page<T> findAll(Pageable pageable);
}