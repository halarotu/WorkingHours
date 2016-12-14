package ha.controller;

import ha.domain.Employee;
//import ha.repository.EmployeeRepository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("*")
public class DefaultController {
	
	//@Autowired
	//private EmployeeRepository emplRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index() {
        
		return "index";
    }
	
	/*@PostConstruct
    public void init() {
        if (emplRepo.findByName("SuperADMIN") != null) {
            return;
        }
           
        Employee superAdmin = new Employee();
        superAdmin.setName("SuperADMIN");
        superAdmin.setAuthorityLevel("SuperADMIN");
        superAdmin.setPassword(passwordEncoder.encode("SuperADMIN"));
        
        emplRepo.save(superAdmin);
    }*/
	
}
