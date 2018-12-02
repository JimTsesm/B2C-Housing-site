package dao;

import java.util.List;

public interface ReviewDAO {
	
	public List<Object[]> find_all_property_reviews(int idProperty);

}
