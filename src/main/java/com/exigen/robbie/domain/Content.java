package com.exigen.robbie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.exigen.robbie.commons.orm.BaseEntity;

@Entity
@Table(name="T_CONTENT")
public class Content extends BaseEntity {

	private static final long serialVersionUID = 2048695378610946701L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id = "";
	
	private String name = "";
	
	private String content = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
