package com.springRest.bugHunterAppWebservice.model.service.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.bugHunterAppWebservice.dto.UserDTO;
import com.springRest.bugHunterAppWebservice.model.dao.resource.ResourceDAO;

@Service
public class ResourceService {

	@Autowired
	private ResourceDAO resourceDAO;

	public List<UserDTO> viewAllResources() {
		return resourceDAO.getAll();
	}

	public Boolean resourceAdd(UserDTO resourceDTO) {
		return resourceDAO.add(resourceDTO);
	}

	public UserDTO getResourceById(int id) {
		return resourceDAO.getById(id);
	}

	public void updateResource(UserDTO userDTO) {
		resourceDAO.updateById(userDTO);
	}

	
}
