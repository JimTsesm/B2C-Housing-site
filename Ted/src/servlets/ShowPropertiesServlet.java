package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListingDAO;
import dao.ListingDAOImpl;
import model.Listing;
import model.User;

/**
 * Servlet implementation class ShowPropertiesServlet
 */
@WebServlet("/ShowPropertiesServlet")
public class ShowPropertiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPropertiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		
		User user = (User)session.getAttribute("logedInUser");
		
		int hostID = user.getIdUser();
		
		ListingDAO dao = new ListingDAOImpl();
		
		List<Listing> list = dao.findHostProp(hostID);
		
		if(list.isEmpty())
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showHostProperties-no-results.jsp");
			disp.forward(request, response);
		}
		else
		{
			session.setAttribute("list2", list);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/HostPropertyPresentation.jsp");
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
