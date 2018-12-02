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
 * Servlet implementation class mailSendServlet
 */
@WebServlet("/mailSendServlet")
public class mailSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String to = (String)request.getParameter("to");
		String subject = (String)request.getParameter("subject");
		String text = (String)request.getParameter("text");
		
		//check if to user exists
		UserDAO dao = new UserDAOImpl();
		User user1 = (User) session.getAttribute("logedInUser");
		User user2 = dao.sameName_check(to);
		//error
		if(user2 == null)
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/mailServlet");
			disp.forward(request, response);
		}
		else
		{
			MessageDAO dao2 = new MessageDAOImpl();
			Date date = new Date();
			Message message = new Message(text,date,user1,user2,subject);
			user1.addSenderMessage(message);
			user2.addgetReceiverMessage(message);
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
