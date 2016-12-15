package ha.domain;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Company extends AbstractPersistable<Long> {
	
	private String name;
	
	@OneToMany
	private List<Employee> employees;
	
	@OneToMany
	private List<Project> projects;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employee> getEmployees() {
		return this.employees;
	}
	
	public void setEmployees(List<Employee> list) {
		this.employees = list;
	}
	
	public List<Project> getProjects() {
		return this.projects;
	}
	
	public void setProjects(List<Project> list) {
		this.projects = list;
	}
	
}
