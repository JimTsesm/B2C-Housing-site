package dao;

import javax.persistence.EntityManager;

import jpautils.EntityManagerHelper;
import model.Request;
import model.User;
import javax.persistence.*;

public class RequestDAOImpl implements RequestDAO {
	
	public void create(Request req){
	EntityManager em = EntityManagerHelper.getEntityManager();
	EntityManagerHelper.beginTransaction();
	em.persist(req);
	EntityManagerHelper.commit();
	}
	
	@Override
	public Request find(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Request request = em.find(Request.class, id); 
        return request;
	}
	
	public void updatePending(Request r) {
	EntityManager em = EntityManagerHelper.getEntityManager();
	EntityManagerHelper.beginTransaction();
	r.setPending(0);
	EntityManagerHelper.commit();
	}
	
	public int Request_check(int ID) {
	EntityManager em = EntityManagerHelper.getEntityManager();
	String select = "SELECT u FROM Request u WHERE u.idUser =:Id";
	Query query = em.createQuery(select);
	query.setParameter("Id", ID);
		
	try {
		Request r = (Request) query.getSingleResult();
		return r.getPending();
	}
	catch(NoResultException e){
	    return -1;
	}	
	}
}
