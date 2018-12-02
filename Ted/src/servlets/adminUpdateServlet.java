package servlets;

import model.Request;
import model.User;
import dao.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminUpdateServlet
 */
@WebServlet("/adminUpdateServlet")
public class adminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqID = (String) request.getParameter("toto");
		int req_id = Integer.parseInt(reqID);
		
		//update Request
		RequestDAO dao = new RequestDAOImpl();
		Request req = dao.find(req_id);
		dao.updatePending(req);
		
		//load User List
		UserDAOImpl dao2 = new UserDAOImpl();
		List<User> user_list = dao2.list();
		request.setAttribute("result", user_list);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/adminTable.jsp");
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
