package dao;

import java.util.List;

import model.User;

public interface UserDAO 
{
	public User find(int id);
	
	public User find(String un,String pass);
	
	public User sameName_check(String un);

    public List<User> list();

    public void create(User user);
    
	public void set_all(int id, String name, String password, String surname, String mail, String phone, byte[] photo);

}
