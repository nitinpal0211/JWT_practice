package com.jlw.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.jlw.Repository.EmployeeRepo;
import com.jlw.model.Employee;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println(username);
		System.out.println(password);
		
		Optional<Employee> opt = empRepo.findByEmail(username);
		
		if(!opt.isPresent()) {
			throw new BadCredentialsException("no employee register with this details");
		}else {
			Employee emp = opt.get();
			if(passwordEncoder.matches(password, emp.getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
				return new UsernamePasswordAuthenticationToken(username,password, authorities);
			}else {
				throw new BadCredentialsException("Invalid password");
			}
		}
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

	}

}
