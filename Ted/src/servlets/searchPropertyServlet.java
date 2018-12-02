package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Listing;
import model.User;
import dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class searchPropertyServlet
 */
@WebServlet("/searchPropertyServlet")
public class searchPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchPropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListingDAO dao = new ListingDAOImpl();
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("logedInUser");
		String state = request.getParameter("box1");
		String town = request.getParameter("box2");
		String neigh = request.getParameter("box3");
		String p = request.getParameter("box6");
		String d1 = request.getParameter("box4");
		String d2 = request.getParameter("box5");
		session.setAttribute("state", state);
		session.setAttribute("town", town);
		session.setAttribute("neigh", neigh);
		session.setAttribute("p", p);
		session.setAttribute("d1", d1);
		session.setAttribute("d2", d2);
		
		int persons = Integer.parseInt(p);
		SimpleDateFormat checkin = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat checkout = new SimpleDateFormat("yyyy-MM-dd");
		Date checkinDate=null;
		Date checkoutDate=null;
		//use checkoutDate - 1 in select query because the day of checkout should not be considered as a rental day
		Date newcheckoutDate=null;
		java.sql.Date sqlcheckinDate = null;
		java.sql.Date sqlcheckoutDate = null;
		try {
			checkinDate = checkin.parse(d1);
			sqlcheckinDate = new java.sql.Date(checkinDate.getTime());
			checkoutDate=checkout.parse(d2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(checkoutDate);
			cal.add(Calendar.DATE, -1);
			newcheckoutDate = cal.getTime();
			sqlcheckoutDate = new java.sql.Date(newcheckoutDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Object[]> list = dao.find(state,town,neigh,sqlcheckinDate,sqlcheckoutDate,persons);
		if(list.isEmpty())
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/apartment_rental_no_result.jsp");
			disp.forward(request, response);
		}
		else
		{
			session.setAttribute("list", list);
			//there is loged in user
			if(user != null)
			{
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/apartment_rental_tenant.jsp");
				disp.forward(request, response);
			}
			//user is unonymous
			else
			{
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/apartment_rental_unonymous.jsp");
				disp.forward(request, response);
			}
		}
	}

}
