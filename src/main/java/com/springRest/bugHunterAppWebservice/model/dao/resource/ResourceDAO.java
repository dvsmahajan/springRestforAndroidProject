package com.springRest.bugHunterAppWebservice.model.dao.resource;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springRest.bugHunterAppWebservice.dto.UserDTO;
import com.springRest.bugHunterAppWebservice.dto.project.Project;

@Repository
public class ResourceDAO {

	@Autowired
	private SessionFactory factory;
	
	
	public ResourceDAO() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass().getSimpleName()+" Created");
	}
	
	
	public List<UserDTO> getAll() {
		System.out.println("Get All Function Created.........");
		String queryString="Select user From UserDTO user";
		Session session=factory.openSession();
		Query query=session.createQuery(queryString);
		List<UserDTO> dtos=query.list();
		
		return dtos;
	}


	public Boolean add(UserDTO resourceDTO) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.save(resourceDTO);
			transaction.commit();
			return true;
		}catch (HibernateException e) {
			transaction.rollback();
			return false;
		}finally {
			if(session!=null) {
				try {
					session.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
	}


	public UserDTO getById(int id) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			UserDTO dto=session.get(UserDTO.class, id);
			transaction.commit();
			return dto;
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}finally {
			if(session!=null) {
				try {
					session.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void updateById(UserDTO userDTO) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			UserDTO dto=session.get(UserDTO.class, userDTO.getResourceId());
			session.saveOrUpdate(dto);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
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
