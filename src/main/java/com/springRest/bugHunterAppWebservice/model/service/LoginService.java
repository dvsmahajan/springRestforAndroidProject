package com.springRest.bugHunterAppWebservice.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.bugHunterAppWebservice.dto.UserDTO;
import com.springRest.bugHunterAppWebservice.model.dao.LoginDAO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;
	
	public UserDTO checkLoginDetails(String username, String password) {
		// TODO Auto-generated method stub
		 return loginDAO.checkAuth(username,password);
	}

}
