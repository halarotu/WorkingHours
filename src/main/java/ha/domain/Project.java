package ha.domain;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Project extends AbstractPersistable<Long> {
	
	private String name;
	
	@ManyToOne
	private Company owner;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Company getOwner() {
		return this.owner;
	}
	
	public void setOwner(Company company) {
		this.owner = company;
	}
	
}
