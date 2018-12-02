package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
import model.Message;
import model.User;

/**
 * Servlet implementation class mailReplyServlet
 */
@WebServlet("/mailReplyServlet")
public class mailReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String idMes = (String)request.getParameter("idMessage");
		int idMessage = Integer.parseInt(idMes);
		String to = (String)request.getParameter("to");System.out.print(to);
		int to_id = Integer.parseInt(to);
		String subject = (String)request.getParameter("subject");
		String text = (String)request.getParameter("text");
		
	
		User user1 = (User) session.getAttribute("logedInUser");
		UserDAO dao = new UserDAOImpl();
		User user2 = dao.find(to_id);
		if(user1.getIdUser() == user2.getIdUser())
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/mailServlet");
			disp.forward(request, response);
		}
		else
		{
			MessageDAO dao2 = new MessageDAOImpl();
			Message message_parent = dao2.find_by_id(idMessage);
			Date date = new Date();
			Message message = new Message(text,date,user1,user2,subject,message_parent);
			user1.addSenderMessage(message);
			user2.addgetReceiverMessage(message);
			message_parent.addMessage(message);
			dao2.create(message);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/mailServlet");
			disp.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
