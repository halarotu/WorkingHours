package ha.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Employee extends AbstractPersistable<Long> {
	
	private String name;
	
	private String password;
	
	private String authorityLevel;
	
	//private Company company;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAuthorityLevel() {
		return this.authorityLevel;
	}
	
	public void setAuthorityLevel(String level) {
		this.authorityLevel = level;
	}
	
	/*public Company getCompany() {
		return this.company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}*/
	
}
