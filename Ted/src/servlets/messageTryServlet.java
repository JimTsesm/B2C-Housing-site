package servlets;

import model.User;
import model.Message;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDAO;
import dao.MessageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;

/**
 * Servlet implementation class messageTryServlet
 */
@WebServlet("/messageTryServlet")
public class messageTryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public messageTryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		UserDAO dao1 = new UserDAOImpl();
		MessageDAO dao2 = new MessageDAOImpl();
		
		User user1 = (User) session.getAttribute("logedInUser");
		User user2 = dao1.find(38769629);
		Date date = new Date();
		Message message = new Message("hi try to send a second message",date,user1,user2,"SUBJ2");
		user1.addSenderMessage(message);
		user2.addgetReceiverMessage(message);
		
		dao2.create(message);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
