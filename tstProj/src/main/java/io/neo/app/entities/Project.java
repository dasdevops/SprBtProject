package io.neo.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "project")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private Integer projectId;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id"), 
    inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"))
    private Set<Employee> employees = new HashSet<>();

	

	public Project() {
		super();
	}

	public Project(Integer projectId, String title) {
		super();
		this.projectId = projectId;
		this.title = title;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	
	
	
	
	

}
