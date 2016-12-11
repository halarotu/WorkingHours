package ha.controller;

import ha.domain.Employee;
import ha.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository emplRepo;
	
	@RequestMapping(method = RequestMethod.GET)
    public String getEmployees(Model model) {
        
		model.addAttribute("employees", this.emplRepo.findAll());
		
		return "employees";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String addNewEmployee(@RequestParam String name, @RequestParam String level) {
        Employee e = new Employee();
        e.setName(name);
        e.setAuthorityLevel(level);
        
        this.emplRepo.save(e);
		
		return "redirect:/employees";
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getEmployee(Model model, @PathVariable Long id) {
        model.addAttribute("employee", emplRepo.findOne(id));
		
		return "employee";
    }
	
}