package com.springRest.bugHunterAppWebservice.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springRest.bugHunterAppWebservice.dto.UserDTO;

@Repository
public class LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDTO checkAuth(String username, String password) {
		Session session=sessionFactory.openSession();
		Query query = session.getNamedQuery("checkLogin");
		UserDTO dto = null;
		try {
			query.setParameter("email", username);
			query.setParameter("password", password);
			dto = (UserDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
}
