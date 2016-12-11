package ha.service;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import ha.domain.Employee;
import ha.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepository emplRepo;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Employee e = emplRepo.findByName(name);
        if (e == null) {
            throw new UsernameNotFoundException("No such user: " + name);
        }
        
        ArrayList<SimpleGrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority(e.getAuthorityLevel()));
        
       
        return new org.springframework.security.core.userdetails.User(
        e.getName(),
        e.getPassword(),
        true,
        true,
        true,
        true,
        auths);
		
		
	
	}
	

}
