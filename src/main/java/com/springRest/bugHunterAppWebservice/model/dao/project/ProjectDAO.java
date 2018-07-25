package com.springRest.bugHunterAppWebservice.model.dao.project;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.stereotype.Repository;

import com.springRest.bugHunterAppWebservice.dto.project.Project;


@Repository
public class ProjectDAO {

	@Autowired
	private SessionFactory factory;
	
	public List<Project> getAll() {
		String queryString="From Project";
		Session session=factory.openSession();
		List<Project> dtos;
		try {
		Query query=session.createQuery(queryString);
		dtos=query.list();
		}finally {
			if(session!=null)
			{
				try {
					session.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return dtos;
		
	}

	public List<Object[]> getNameAndId() {
		String queryString="select project.projectId,project.projName From Project project";
		Session session=factory.openSession();
		List<Object[]> dtos;
		try {
			Query query=session.createQuery(queryString);
			dtos=query.list();
			return dtos;
	//		System.out.println(dtos);
		}finally {
			if(session!=null)
			{
				try {
					session.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Project getById(int id) {
		
		return factory.openSession().get(Project.class, id);
	}

	public int add(Project projectDTO) {
		int x=0;
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
		x=(int) session.save(projectDTO);
		transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return x;
	}
	
	public void updateById(Project projectDTO)
	{
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			Project project=session.get(Project.class, projectDTO.getProjectId());
			session.saveOrUpdate(project);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			if(session!=null) {
				try {
					session.close();
				}catch (HibernateException e) {	
					e.printStackTrace();
				}
			}
		}
	}

}
