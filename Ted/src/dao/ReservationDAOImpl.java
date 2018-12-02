package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import jpautils.EntityManagerHelper;

import model.Reservation;

public class ReservationDAOImpl implements ReservationDAO {
	
	public void create(Reservation reservation)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		em.persist(reservation);
		EntityManagerHelper.commit();
	}

}
