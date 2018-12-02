package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMessage;

	@Lob
	private String content;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String subject;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="sender")
	private User sender;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="receiver")
	private User receiver;

	//bi-directional many-to-one association to Message
	@ManyToOne
	@JoinColumn(name="parent_message_id")
	private Message message;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="message")
	private Set<Message> messages;
	
	//bi-directional many-to-one association to Deletedmessage
	@OneToMany(mappedBy="message")
	private Set<Deletedmessage> deleted_message;

	public Message() {
	}
	
	public Message(String content, Date date, User user1, User user2, String subject) {
		this.content = content;
		this.date = date;
		this.sender = user1;
		this.receiver = user2;
		this.subject = subject;
	}
	
	public Message(String content, Date date, User user1, User user2, String subject, Message message) {
		this.content = content;
		this.date = date;
		this.sender = user1;
		this.receiver = user2;
		this.subject = subject;
		this.message = message;
	}

	public int getIdMessage() {
		return this.idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getReceiver() {
		return this.receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setMessage(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setMessage(null);

		return message;
	}
	
	public Set<Deletedmessage> getDeletedmessage() {
		return this.deleted_message;
	}
	
	public void setDeletedmessage(Set<Deletedmessage> messages) {
		this.deleted_message = messages;
	}

	public Deletedmessage addDeletedmessage(Deletedmessage message) {
		getDeletedmessage().add(message);
		message.setDeletedmessage(this);

		return message;
	}

	public Deletedmessage removeDeletedmessage(Deletedmessage message) {
		getDeletedmessage().remove(message);
		message.setDeletedmessage(null);

		return message;
	}
	
}