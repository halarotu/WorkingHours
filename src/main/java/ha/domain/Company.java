package ha.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Company extends AbstractPersistable<Long> {
	
	private String name;
	
	@OneToMany
	private ArrayList<Employee> employees;
	
	@OneToMany
	private ArrayList<Project> projects;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Employee> getEmployees() {
		return this.employees;
	}
	
	public void setEmployees(ArrayList<Employee> list) {
		this.employees = list;
	}
	
	public ArrayList<Project> getProjects() {
		return this.projects;
	}
	
	public void setProjects(ArrayList<Project> list) {
		this.projects = list;
	}
	
}
