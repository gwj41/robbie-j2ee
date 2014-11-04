package com.exigen.robbie.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import com.exigen.robbie.commons.orm.BaseEntity;

@Entity
@Table(name="T_CLASS")
@JsonAutoDetect
@JsonIgnoreProperties(value={"hibernateLazyInitializer","students"})
public class Class extends BaseEntity {

	private static final long serialVersionUID = 1596800512586623789L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id = "";
	
	private String name = "";
	
	private String teacher = "";
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="clazz",fetch = FetchType.LAZY, targetEntity = Student.class)
	private Set<Student> students = new HashSet<Student>();

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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
