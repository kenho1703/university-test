package com.university.app.university.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "university")
@Data
public class University implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private Long orgNo;

	private String name;

	@OneToMany(mappedBy = "university")
	Set<Student> students = new HashSet<>();
}