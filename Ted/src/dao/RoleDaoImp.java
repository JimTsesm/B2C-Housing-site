package dao;

import javax.persistence.EntityManager;

import jpautils.EntityManagerHelper;
import model.Role;

public class RoleDaoImp implements RoleDao {

	@Override
	public void create(Role role) 
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		em.persist(role);
		EntityManagerHelper.commit();
	}

}
