package com.overview.springdata.h2demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
	private Set<Programmer> programmers = new HashSet<>();

	public Project() {
		super();
	}

	public Project(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Programmer> getProgrammers() {
		return programmers;
	}

	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
}
