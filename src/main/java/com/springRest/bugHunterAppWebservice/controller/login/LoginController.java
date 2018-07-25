package com.springRest.bugHunterAppWebservice.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.springRest.bugHunterAppWebservice.dto.UserDTO;
import com.springRest.bugHunterAppWebservice.model.service.LoginService;

@RestController
@EnableWebMvc
@RequestMapping("/user")
public class LoginController {
	@Value("${adminUsername}")
	private String adminUsername;
	@Value("${adminPassword}")
	private String adminPassword;
	@Value("${adminName}")
	private String adminName;
	
	@Autowired
	private LoginService loginService;
	

	
	@RequestMapping(value="/check.do",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public UserDTO checkLogin(@RequestParam String username,@RequestParam String password ) {
		
		if(adminUsername.equals(username) && adminPassword.equals(password))
		{
			
			UserDTO a=new UserDTO();
			a.setResourceId(1);
			a.setEmpName("DIVYESH MAHAJAN");
			a.setEmpDesignation("owner");
			a.setEmpEmail("owner");
			a.setEmpNumber("owner");
			a.setEmpPassword("owner");
			a.setManagerEmail("owner");
			a.setProjId(1);
			return a;
		}else
		{
			UserDTO userDTO=loginService.checkLoginDetails(username,password);
			return userDTO;
		}
	}
}
