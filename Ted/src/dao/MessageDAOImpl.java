package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Message;
import model.User;

public class MessageDAOImpl implements MessageDAO{
	
	@Override
	public void create(Message message)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		em.persist(message);
		EntityManagerHelper.commit();
	}
	
	@Override
	public Message find_by_id(int id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Message message = em.find(Message.class, id); 
        return message;
	}
	
	//find all messages where this user is receiver and message has not parent message
	@Override
	public List<Message> find(int receiver)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		//String select = "SELECT u FROM Message u WHERE (u.receiver.idUser =:user and u.message = null)";
		String select = "SELECT u FROM Message u WHERE ((u.receiver.idUser =:user and u.message = null)" +
		"or (u.sender.idUser=:user and u.message = null and u.idMessage in (select k.message.idMessage from Message k)))" +
		"and (u.idMessage not in (SELECT l.id.idMessage FROM Deletedmessage l WHERE l.id.idUser =:user))";
		
		Query query = em.createQuery(select);
		query.setParameter("user", receiver);
		List<Message> messages = query.getResultList();
		return messages;
	}
	
	//find all messages that are children of parent message (a conversation between 2 users)
	@Override
	public List<Object[]> recursive_find(int parent)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		String select = "select * from" +
		"(select * from message order by parent_message_id, idMessage) message_sorted," +
        "(select @pv := ?1) initialisation where   find_in_set(parent_message_id, @pv) > 0 and     @pv := concat(@pv, ',', idMessage);";
	
		Query query = em.createNativeQuery(select);
		query.setParameter(1, parent);
		List<Object[]> list= query.getResultList();
		return list;
	}



}
