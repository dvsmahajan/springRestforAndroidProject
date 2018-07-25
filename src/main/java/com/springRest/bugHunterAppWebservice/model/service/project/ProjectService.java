package com.springRest.bugHunterAppWebservice.model.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.bugHunterAppWebservice.dto.project.Project;
import com.springRest.bugHunterAppWebservice.model.dao.project.ProjectDAO;

@Service
public class ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	public List<Project> viewAllProject() {
		return projectDAO.getAll();
	}

	public List<Object[]> getProjNameAndId() {
		// TODO Auto-generated method stub
		return projectDAO.getNameAndId();
	}

	public Project getProjById(int id) {
		// TODO Auto-generated method stub
		return projectDAO.getById(id);
	}

	public int addProject(Project projectDTO) {
		// TODO Auto-generated method stub
		return projectDAO.add(projectDTO);
	}

	public void updateProjectById(Project projectDTO) {
		projectDAO.updateById(projectDTO);
	}
}
