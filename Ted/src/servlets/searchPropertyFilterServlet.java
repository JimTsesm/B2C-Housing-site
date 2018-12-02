package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import model.User;

/**
 * Servlet implementation class searchPropertyFilterServlet
 */
@WebServlet("/searchPropertyFilterServlet")
public class searchPropertyFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchPropertyFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListingDAO dao = new ListingDAOImpl();
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("logedInUser");
		String apartment_type = request.getParameter("menu");
		String min_price = request.getParameter("min");
		String max_price = request.getParameter("max");
		String box1 = request.getParameter("box1");
		String box2 = request.getParameter("box2");
		String box3 = request.getParameter("box3");
		String box4 = request.getParameter("box4");
		String box5 = request.getParameter("box5");
		String box6 = request.getParameter("box6");
		String box7 = request.getParameter("box7");
		String state = (String)session.getAttribute("state");
		String town = (String)session.getAttribute("town");
		String neigh = (String)session.getAttribute("neigh");
		String p = (String)session.getAttribute("p");
		String d1 = (String)session.getAttribute("d1");
		String d2 = (String)session.getAttribute("d2");
		
		int min_price_formed = 0;
		int max_price_formed = 100000000;
		if(!min_price.equals("")) min_price_formed = Integer.parseInt(min_price);
		if(!max_price.equals("")) max_price_formed = Integer.parseInt(max_price);
		
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
		
		List<Object[]> list = dao.find(state,town,neigh,sqlcheckinDate,sqlcheckoutDate,persons,apartment_type,min_price_formed,max_price_formed,box1,box2,box6,box7,box3,box4,box5);
		if(list.isEmpty())
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/apartment_rental_no_result.jsp");
			disp.forward(request, response);
		}
		else
		{
			session.setAttribute("list", list);
			if(user != null)
			{
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/apartment_rental_tenant.jsp");
				disp.forward(request, response);
			}
			//user is unonymous
			{
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/apartment_rental_unonymous.jsp");
				disp.forward(request, response);
			}
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
