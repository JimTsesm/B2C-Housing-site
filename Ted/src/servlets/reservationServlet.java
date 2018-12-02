package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Listing;
import dao.CalendarDAO;
import dao.ListingDAO;
import dao.ReservationDAO;
import dao.ReservationDAOImpl;
import model.Reservation;
import model.ReservationPK;
import model.User;
import dao.ListingDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import dao.CalendarDAO;
import dao.CalendarDAOImpl;
/**
 * Servlet implementation class reservationServlet
 */
@WebServlet("/reservationServlet")
public class reservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String idProp = (String)request.getParameter("id");
		int idProperty = Integer.parseInt(idProp);
		String idUs = (String)session.getAttribute("idUser");
		int idUser = Integer.parseInt(idUs);
		String checkInDate = (String)session.getAttribute("d1");
		String checkOutDate = (String)session.getAttribute("d2");
		Date formedCheckInDate = null;
		Date formedCheckOutDate = null;
		try {
		    String dateValue = "20 September, 2013";
		    SimpleDateFormat cd1 = new SimpleDateFormat("yyyy-MM-dd");
		    SimpleDateFormat cd2 = new SimpleDateFormat("yyyy-MM-dd");
		    formedCheckInDate = cd1.parse(checkInDate);
		    formedCheckOutDate = cd1.parse(checkOutDate);
		} catch (ParseException exp) {
		    exp.printStackTrace();}

			/*ListingDAO dao1 = new ListingDAOImpl();
			UserDAO dao2 = new UserDAOImpl();
			Listing listing = dao1.find(idProperty);
			User user = dao2.find(idUser);
		        
		    ReservationPK reservationId = new ReservationPK();
		    reservationId.setIdTenant(idUser);
		    reservationId.setIdProperty(idProperty);
		    reservationId.setCheckInDate(formedCheckInDate);
		    Reservation reservation =  new Reservation(reservationId,formedCheckOutDate);
		    
		    listing.addReservation(reservation);
		    user.addReservation(reservation);

		    ReservationDAO dao = new ReservationDAOImpl();
		    dao.create(reservation);*/
		    
		    CalendarDAO dao = new CalendarDAOImpl();
		    dao.update(idProperty, checkInDate, checkOutDate);
		    
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/reservationVerifyMessage.jsp");
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
