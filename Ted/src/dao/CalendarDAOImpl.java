package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.EntityManager;

import jpautils.EntityManagerHelper;
import model.Calendar;
import model.CalendarPK;
import model.Listing;
import model.User;

public class CalendarDAOImpl implements CalendarDAO {
	
	@Override
	public void create(Listing listing, String from, String to, String price){
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		CalendarDAO dao = new CalendarDAOImpl();
		
		LocalDate start = LocalDate.parse(from),
		          end   = LocalDate.parse(to);
		LocalDate next = start.minusDays(1);
		Date d1, formedDate=null;
		while ((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
		    d1 = Date.from(next.atStartOfDay(ZoneId.systemDefault()).toInstant());
		    try {
			    SimpleDateFormat cd1 = new SimpleDateFormat("yyyy-MM-dd");
			    String dd = cd1.format(d1);
			    formedDate = cd1.parse(dd);
			} catch (ParseException exp) {
			    exp.printStackTrace();}

		    CalendarPK calendar_id = new CalendarPK();
			calendar_id.setIdProperty(listing.getId());
			Calendar calendar = new Calendar();
		    calendar_id.setDate(formedDate);
		    calendar.setId(calendar_id);
		    calendar.setAvailable("t");
		    calendar.setPrice(price);
		    listing.addCalendar(calendar);
		    
			EntityManagerHelper.beginTransaction();
			em.persist(calendar);
			EntityManagerHelper.commit();
		}
	}

	
	@Override
	public Calendar find(CalendarPK id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Calendar calendar = em.find(Calendar.class, id); 
        return calendar;
	}
	
	public void update(int id, String checkin, String checkout)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		CalendarPK calendar_id = new CalendarPK();
		calendar_id.setIdProperty(id);
		Calendar calendar = null;
		CalendarDAO dao = new CalendarDAOImpl();
		
		LocalDate start = LocalDate.parse(checkin),
		          end   = LocalDate.parse(checkout);
		LocalDate next = start.minusDays(1);
		Date d1, formedDate=null;
		while ((next = next.plusDays(1)).isBefore(end)) {
		    d1 = Date.from(next.atStartOfDay(ZoneId.systemDefault()).toInstant());
		    try {
			    SimpleDateFormat cd1 = new SimpleDateFormat("yyyy-MM-dd");
			    String dd = cd1.format(d1);
			    formedDate = cd1.parse(dd);
			} catch (ParseException exp) {
			    exp.printStackTrace();}
		    
		    calendar_id.setDate(formedDate);
		    
		    calendar = dao.find(calendar_id);
			EntityManagerHelper.beginTransaction();
		    calendar.setAvailable("f");
			EntityManagerHelper.commit();
		}
		
	}


}
