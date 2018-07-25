package com.springRest.bugHunterAppWebservice.controller.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.springRest.bugHunterAppWebservice.dto.project.Project;
import com.springRest.bugHunterAppWebservice.model.service.project.ProjectService;

@RequestMapping("/project")
@RestController
@EnableWebMvc
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, true));
	}
	
	
	@RequestMapping(value="/getAllProj.do",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Project> viewAllProject()
	{
		return projectService.viewAllProject();
	}
	
	@RequestMapping(value="/getAllProjNameAndId.do",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Object[]> getProjNameAndId()
	{
		return projectService.getProjNameAndId();
	}
	
	@RequestMapping(value="/getProjById.do",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Project getProjById(@PathVariable("projectId")int id)
	{
		return projectService.getProjById(id);
	}
	
	
	
	
	@RequestMapping(value="/projectAdd.do",method=RequestMethod.POST,consumes= {MediaType.APPLICATION_JSON_VALUE})
	public Boolean addProjectControl(@RequestBody Project projectDTO)
	{
		System.out.println(projectDTO);
		int addedRow=projectService.addProject(projectDTO);
		return true;
	}
	
	@RequestMapping(value="/updateProject.do",method=RequestMethod.PUT,consumes= {MediaType.APPLICATION_JSON_VALUE})
	public void updateProjectById(@RequestBody Project projectDTO)
	{
		projectService.updateProjectById(projectDTO);
	}
	
}
