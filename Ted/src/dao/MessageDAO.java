package dao;

import java.util.List;

import model.Message;
import model.User;

public interface MessageDAO {
	
	public void create(Message message);
	
	public Message find_by_id(int id);
	
	public List<Message> find(int receiver);
	
	public List<Object[]> recursive_find(int receiver);

}
