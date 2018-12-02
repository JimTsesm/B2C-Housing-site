package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class mailServlet
 */
@WebServlet("/mailServlet")
public class mailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		MessageDAO dao = new MessageDAOImpl();
		
		User user1 = (User) session.getAttribute("logedInUser");
		List<Message> messages = dao.find(user1.getIdUser());
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/mail.jsp");
		//request.setAttribute("messages", messages);
		//request.setAttribute("messages2", messages);
		
		List<List<Object[]>> listOflist = new ArrayList<List<Object[]>>();
		List<Object[]> l = null;
		
		for (int i = 0; i < messages.size(); i++)
		{
			//create a list that has all the conversation betwen 2 users
			l = dao.recursive_find(messages.get(i).getIdMessage());
			Object[] obj = new Object[7];
			obj[0] = messages.get(i).getIdMessage();
			obj[1] = messages.get(i).getSubject();
			obj[2] = messages.get(i).getContent();
			obj[3] = messages.get(i).getDate();
			obj[4] = messages.get(i).getSender();
			obj[5] = messages.get(i).getReceiver();
			obj[6] = messages.get(i).getMessage();
			l.add(0,obj);
			
			//add that list to a listOflist
			listOflist.add(l);
		}
		
		request.setAttribute("messages", listOflist);
		request.setAttribute("messages2", messages);

		
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
