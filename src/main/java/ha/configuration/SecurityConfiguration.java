package ha.configuration;

import ha.service.EmployeeDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private EmployeeDetailsService emplDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    	
        http.authorizeRequests()
        .antMatchers("/index").hasAnyAuthority("USER", "CompanyADMIN", "SuperADMIN")
        .antMatchers("/employees").hasAnyAuthority("CompanyADMIN", "SuperADMIN")
        .antMatchers(HttpMethod.POST, "/employees").hasAnyAuthority("CompanyADMIN", "SuperADMIN")
        .anyRequest().authenticated();
        
        http.formLogin()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(emplDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
