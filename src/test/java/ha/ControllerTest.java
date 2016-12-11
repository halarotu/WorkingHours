package ha;

import ha.domain.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
	
	@Autowired
    private WebApplicationContext context;
	
    private MockMvc mockMvc;
	
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
	@Test
	public void employeesControllerTest() throws Exception {
		
		// basic get employees page ok? 
		mockMvc.perform(get("/employees"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("employees"))
                .andExpect(view().name("employees"))
                .andReturn();
		
		// adding new employee ok?
        String name = "Teuvo Tyolainen";
        String companyLevel = "USER";
        mockMvc.perform(post("/employees").param("name", name).param("level", companyLevel))
                .andExpect(status().is3xxRedirection())
                .andReturn();
        
        // new employee added?
        MvcResult result = mockMvc.perform(get("/employees"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        List<Employee> employees = new ArrayList<>((Collection<Employee>) result.getModelAndView().getModel().get("employees"));
        assertTrue("New employee was added.", employees.size() == 2);
	}
	
	@Test
	public void singleEmployeeTest() throws Exception {
		String name = "Teuvo Tyolainen";
        String companyLevel = "1";
        mockMvc.perform(post("/employees").param("name", name).param("level", companyLevel))
                .andExpect(status().is3xxRedirection())
                .andReturn();
        MvcResult result = mockMvc.perform(get("/employees"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        List<Employee> employees = new ArrayList<>((Collection<Employee>) result.getModelAndView().getModel().get("employees"));
        Long id = employees.get(0).getId();
        assertNotNull("Employee id is not null", id);
        
        // path /employees/{id} exists?
        mockMvc.perform(get("/employees/" + id))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        
        
	}

}
