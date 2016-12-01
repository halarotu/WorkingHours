package ha.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Employee extends AbstractPersistable<Long> {
	
	private String name;
	
	private int companyLevel;
	
	private Company company;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCompanyLevel() {
		return this.companyLevel;
	}
	
	public void setCompanyLevel(int level) {
		this.companyLevel = level;
	}
	
	public Company getCompany() {
		return this.company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
