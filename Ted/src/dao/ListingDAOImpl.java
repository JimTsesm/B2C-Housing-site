package dao;

import model.Listing;
import model.Reservation;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.User;

public class ListingDAOImpl implements ListingDAO {
	
	@Override
	public Listing find(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Listing p = em.find(Listing.class, id); 
        return p;
	}
	
	@Override
	public List<Listing> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createNamedQuery("Listing.findAll");
		@SuppressWarnings("unchecked")
		List<Listing> r = query.getResultList();  
        return r;
	}
	
	@Override
	public List<Object[]> find(String country, String town, String neighbourhood, Date checkin, Date checkout, int persons) {
		EntityManager em = EntityManagerHelper.getEntityManager();

		//using Reservation Table
		//String select = "SELECT * FROM listings where listings.id not in (select id from reservation where ?1 between check_in_date and date_sub(check_out_date,interval 1 day)) and listings.id not in(select id from reservation where ?2 between date_add(check_in_date,interval 1 day) and check_out_date) and listings.id not in(select id from reservation where check_in_date between ?3 and date_sub(?4,interval 1 day)) and (listings.state=?5 or listings.city=?6 or listings.neighbourhood=?7) and (listings.guests_included >= ?8) order by CONVERT(SUBSTRING(price,2),UNSIGNED INTEGER)";

		//using Calendar Table
		String select = "SELECT * FROM listings where listings.id in (SELECT idProperty FROM calendar where (date between ?1 and ?2) and (available=\"t\") group by idProperty  having count(*)=datediff(?4,?3)+1) and (listings.state=?5 or listings.city=?6 or listings.neighbourhood=?7) and (listings.guests_included >= ?8) order by CONVERT(SUBSTRING(price,2),UNSIGNED INTEGER)";
		
		Query query = em.createNativeQuery(select);
		query.setParameter(1, checkin);
		query.setParameter(2, checkout);
		query.setParameter(3, checkin);
		query.setParameter(4, checkout);
		query.setParameter(5, country);
		query.setParameter(6, town);
		query.setParameter(7, neighbourhood);
		query.setParameter(8, persons);

		List<Object[]> list= query.getResultList();
		return list;
	
	}
	
	public List<Object[]> find(String country, String town, String neighbourhood, Date checkin, Date checkout, int persons, String type, int min, int max, String wifi, String air, String heating, String kitchen, String tv, String parking, String elevator)
	{
		//using Reservation Table
		//String select = "SELECT * FROM listings where listings.id not in (select id from reservation where ?1 between check_in_date and date_sub(check_out_date,interval 1 day)) and listings.id not in(select id from reservation where ?2 between date_add(check_in_date,interval 1 day) and check_out_date) and listings.id not in(select id from reservation where check_in_date between ?3 and date_sub(?4,interval 1 day)) and (listings.state=?5 or listings.city=?6 or listings.neighbourhood=?7) and (listings.guests_included >= ?8)";
		
		//using Calendar Table
		String select = "SELECT * FROM listings where listings.id in (SELECT idProperty FROM calendar where (date between ?1 and ?2) and (available=\"t\") group by idProperty  having count(*)=datediff(?4,?3)+1) and (listings.state=?5 or listings.city=?6 or listings.neighbourhood=?7) and (listings.guests_included >= ?8)";
		
		if(type.equals("Shared Room")) select = select + "and (room_type=\"Shared room\")";
		else if(type.equals("Private Room")) select = select + "and (room_type=\"Private room\")";
		else if(type.equals("House")) select = select + "and (room_type=\"Entire Home/apt\")";
		
		select += "and (CONVERT(SUBSTRING(price,2),UNSIGNED INTEGER) >= ?9)";
		select += "and (CONVERT(SUBSTRING(price,2),UNSIGNED INTEGER) <= ?10)";
		
		if(wifi != null) select += "and amenities like '%Wireless Internet%'";
		if(air != null) select += "and amenities like '%Air Conditioning%'";
		if(heating != null) select += "and amenities like '%Heating%'";
		if(kitchen != null) select += "and amenities like '%Kitchen%'";
		if(tv != null) select += "and amenities like '%TV%'";
		if(parking != null) select += "and amenities like '%Free Parking on Premises%'";
		if(elevator != null) select += "and amenities like '%Elevator in Building%'";
		
		select += "order by CONVERT(SUBSTRING(price,2),UNSIGNED INTEGER)";
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createNativeQuery(select);
		query.setParameter(1, checkin);
		query.setParameter(2, checkout);
		query.setParameter(3, checkin);
		query.setParameter(4, checkout);
		query.setParameter(5, country);
		query.setParameter(6, town);
		query.setParameter(7, neighbourhood);
		query.setParameter(8, persons);
		query.setParameter(9, min);
		query.setParameter(10, max);

		List<Object[]> list= query.getResultList();
		return list;
			
	}
	
	public void create(Listing listing){
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		em.persist(listing);
		EntityManagerHelper.commit();
		
	}
	
	public void update(int PropId,float la,float lo,String Transit, String Neighbourhood,String Street,int minnights,String Description,String RoomType,float bathsnum,int bedroomsnum,int bedsnum) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		Listing listing = (Listing)find(PropId);
		listing.setLatitude(la);
		listing.setLongitude(lo);
		listing.setTransit(Transit);
		listing.setNeighbourhood(Neighbourhood);
		listing.setStreet(Street);
		listing.setMinimumNights(minnights);
		listing.setRoomType(RoomType);
		listing.setBedrooms(bedroomsnum);
		listing.setBathrooms(bathsnum);
		listing.setBeds(bedsnum);
		listing.setDescription(Description);
		EntityManagerHelper.commit();
	}

	
	public List<Listing> findHostProp(int id){
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		String select = "SELECT l FROM Listing l WHERE (l.hostIds.idUser =:ID)";
		Query query = em.createQuery(select);
		query.setParameter("ID", id);
		
		List<Listing> list= query.getResultList();
		return list;	
	}
	
	public void add_photo(String photo, int prop_id, String phot1,String phot2, String phot3, String phot4){
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		Listing listing = (Listing)find(prop_id);
		listing.setPictureUrl(photo);
		listing.setThumbnailUrl(photo);
		listing.setMediumUrl(photo);
		listing.setXlPictureUrl(photo);
		if (phot1!=null)
		{
		listing.setphoto1(phot1);
		listing.setphoto2(phot2);
		listing.setphoto3(phot3);
		listing.setphoto4(phot4);
		}
		EntityManagerHelper.commit();
		
	}
}
