package dao;

import java.util.Date;

import model.Calendar;
import model.CalendarPK;
import model.Listing;

public interface CalendarDAO {
	
	public void create(Listing listing, String from, String to, String price);
	
	public Calendar find(CalendarPK id);
	
	public void update(int id, String checkin, String checkout);

}
