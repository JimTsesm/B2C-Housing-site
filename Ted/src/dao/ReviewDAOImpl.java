package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;

public class ReviewDAOImpl implements ReviewDAO {
	
	public List<Object[]> find_all_property_reviews(int idProperty)
	{
		String select = "SELECT * FROM reviews WHERE listing_id = ?1";
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createNativeQuery(select);
		query.setParameter(1, idProperty);
		
		List<Object[]> list= query.getResultList();
		return list;
	}

}
