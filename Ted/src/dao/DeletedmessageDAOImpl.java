package dao;

import javax.persistence.EntityManager;

import jpautils.EntityManagerHelper;
import model.Deletedmessage;

public class DeletedmessageDAOImpl implements DeletedmessageDAO{
	
	@Override
	 public void create(Deletedmessage message){
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		em.persist(message);
		EntityManagerHelper.commit();
	 }

}
