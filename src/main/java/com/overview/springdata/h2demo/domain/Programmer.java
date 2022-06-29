package com.overview.springdata.h2demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "programmer")
public class Programmer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Long sal;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		name = "programmers_projects",
		joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
	)
	private Set<Project> projects = new HashSet<>();

	public void addProject(Project project) {
		if(project != null) {
			if(projects == null) {
				projects = new HashSet<>();
			}
			projects.add(project);
		}
	}
	
	public Programmer() {
		super();
	}

	public Programmer(String name, Long sal) {
		super();
		this.name = name;
		this.sal = sal;
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

	public Long getSal() {
		return sal;
	}

	public void setSal(Long sal) {
		this.sal = sal;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Programmer [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}
}
