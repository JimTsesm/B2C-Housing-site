package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeletedmessageDAO;
import dao.DeletedmessageDAOImpl;
import dao.MessageDAO;
import dao.MessageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Deletedmessage;
import model.Message;
import model.User;

/**
 * Servlet implementation class mailDeleteServlet
 */
@WebServlet("/mailDeleteServlet")
public class mailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailDeleteServlet() {
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
		
		UserDAO dao1 = new UserDAOImpl();
		MessageDAO dao2 = new MessageDAOImpl();
		DeletedmessageDAO dao3 = new DeletedmessageDAOImpl();
		
		User user = (User) session.getAttribute("logedInUser");
		Message message = dao2.find_by_id(idMessage);
		Deletedmessage deleted_message = new Deletedmessage();
		deleted_message.setDeletedmessage(message);
		deleted_message.setUser(user);
		user.addDeletedmessage(deleted_message);
		message.addDeletedmessage(deleted_message);
		dao3.create(deleted_message);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/mailServlet");
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
