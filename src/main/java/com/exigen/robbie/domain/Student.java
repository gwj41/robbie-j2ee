package com.exigen.robbie.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.exigen.robbie.commons.orm.BaseEntity;

@Entity
@Table(name="T_STUDENT")
public class Student extends BaseEntity {

	private static final long serialVersionUID = 4507425547146156775L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id = "";
	
	private String name = "";
	
	private String gender = "";
	
	private String age = "";
	
	@Temporal(TemporalType.DATE)
	private Date birthday = new Date();
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinColumn(name="class_id",referencedColumnName="id")
	@NotFound(action=NotFoundAction.IGNORE)
	private Class clazz = new Class();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
