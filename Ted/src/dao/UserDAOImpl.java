package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.*;


import jpautils.EntityManagerHelper;
import model.User;

public class UserDAOImpl implements UserDAO 
{

	@Override
	public User find(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		User user = em.find(User.class, id); 
        return user;
	}
	
	public User sameName_check(String un) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		String select = "SELECT u FROM User u WHERE u.username=:userName";
		Query query = em.createQuery(select);
		query.setParameter("userName", un);
		
		try {

			User ua = (User) query.getSingleResult();
			return ua;
		}
		catch(NoResultException e){
		    return null;
		}
		
	}
	
	//find a User using username and password(preventing sql injection attacks)
	public User find(String un, String pass) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		String select = "SELECT u FROM User u WHERE u.username=:userName and u.password=:passWord";
		Query query = em.createQuery(select);
		query.setParameter("userName", un);
		query.setParameter("passWord", pass);
		
		try {  //if part

			User ua = (User) query.getSingleResult();
			return ua;
		}
		catch(NoResultException e){ //else part
		    return null;
		}
	}	

	@Override
	public List<User> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createNamedQuery("User.findAll");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();  
        return users;
	}

	@Override
	public void create(User user) 
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		em.persist(user);
		EntityManagerHelper.commit();
	}
	
	public void set_all(int id, String name, String password, String surname, String mail, String phone, byte[] photo) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		User user = (User)find(id);
		user.setName(name);
		user.setSurname(surname);
		user.setPassword(password);
		user.setPhone(phone);
		user.setMail(mail);
		user.setPhoto(photo);
		EntityManagerHelper.commit();
		
		}
}
