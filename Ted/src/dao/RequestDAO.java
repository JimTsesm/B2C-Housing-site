package dao;

import model.Request;

public interface RequestDAO {
	
	public void create(Request req);
	
	public Request find(int id);
	
	public void updatePending(Request r);
	
	public int Request_check(int ID);

}
