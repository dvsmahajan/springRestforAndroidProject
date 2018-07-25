package com.springRest.bugHunterAppWebservice.controller.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.springRest.bugHunterAppWebservice.dto.UserDTO;
import com.springRest.bugHunterAppWebservice.dto.project.Project;
import com.springRest.bugHunterAppWebservice.model.service.resource.ResourceService;

@RestController
@EnableWebMvc
@RequestMapping("/resource")
public class ResourceController 
{

	@Autowired
	private ResourceService resourceService;
	
	
	@RequestMapping(value="/getAllRes.do",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<UserDTO> viewAllResurce()
	{
		return resourceService.viewAllResources();
	}
	
	
	@RequestMapping(value="/resourceAdd.do",method=RequestMethod.POST,consumes= {MediaType.APPLICATION_JSON_VALUE})
	public Boolean addResourceContr(@RequestBody UserDTO resourceDTO)
	{
		System.out.println(resourceDTO);
		return resourceService.resourceAdd(resourceDTO);
	}
	
	@RequestMapping(value="/getResourceById",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public UserDTO getResourceById(@PathVariable int id)
	{
		return resourceService.getResourceById(id);
	}
	
	@RequestMapping(value="/updateResource.do",method=RequestMethod.PUT,consumes= {MediaType.APPLICATION_JSON_VALUE})
	public void updateResourceById(@RequestBody UserDTO userDTO)
	{
		resourceService.updateResource(userDTO);
	}
	
}
