package dao;

import model.Listing;

import java.sql.Date;
import java.util.List;

import model.User;

public interface ListingDAO {
	
	public Listing find(int id);
	
	public List<Listing> list();

    public void create(Listing user);
    
	public List<Object[]> find(String country, String town, String neighbourhood, Date checkin, Date checkout, int persons);

	public List<Object[]> find(String country, String town, String neighbourhood, Date checkin, Date checkout, int persons, String type, int min, int max, String wifi, String air, String heating, String kitchen, String tv, String parking, String elevator);
	
	public List<Listing> findHostProp(int id);
	
	public void update(int PropId,float la,float lo,String Transit, String Neighbourhood,String Street,int minnights,String Description,String RoomType,float bathsnum,int bedroomsnum,int bedsnum);

	public void add_photo(String photo,int prop_id,String phot1,String phot2, String phot3, String phot4);
}
