package com.hutech.payrollapp.api.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.exceptionhandler.IncorrectEmailException;
import com.hutech.payrollapp.api.jwtUtill.JwtUtil;
import com.hutech.payrollapp.api.model.AdminLogin;
import com.hutech.payrollapp.api.model.AdminRequest;
import com.hutech.payrollapp.api.model.AdminResponse;
import com.hutech.payrollapp.api.repository.AdminRepository;
import com.hutech.payrollapp.api.serviceImpl.AdminLoginService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminLoginController {

	@GetMapping("/adminlogin")
	public String login() {
		return "adminLogin";
	}

	@GetMapping("/success")
	public String home() {
		return "index";
	}

	private static final @NotEmpty @Size(min = 8, message = "password should have at least 8 character") String String = null;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminLoginService loginService;

	@PostMapping("/logintoken")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AdminRequest adminrequest)
			throws IncorrectEmailException {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(adminrequest.getUserName(), adminrequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect Username or Password", e);
		}
		final UserDetails userDetails = loginService.loadUserByUsername(adminrequest.getUserName());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AdminResponse(token, adminrequest.getUserName(), adminrequest.getIsAdmin(),
				adminrequest.getIsManager()));
	}

	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody AdminLogin adminLogin) {
		adminRepository.save(adminLogin);
		return "Admin Added";
	}
}
