package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PropertyEditServlet
 */
@WebServlet("/PropertyEditServlet")
public class PropertyEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String)request.getParameter("PropId");
		String BedsNum = (String)request.getParameter("BedsNum");
		String BathsNum = (String)request.getParameter("BathsNum");
		String BedRoomsNum = (String)request.getParameter("BedRoomsNum");
		String SquareSpace = (String)request.getParameter("SquareSpace");
		String RoomType = (String)request.getParameter("RoomType");
		String Description = (String)request.getParameter("Description");
		String MinNights = (String)request.getParameter("MinNights");
		String Lat = (String)request.getParameter("Lat");
		String Lon = (String)request.getParameter("Lon");
		String Street = (String)request.getParameter("Street");
		String Neighbourhood = (String)request.getParameter("Neighbourhood");
		String Transit = (String)request.getParameter("Transit");
		
		request.setAttribute("PropId",id );
		request.setAttribute("BedsNum",BedsNum );
		request.setAttribute("BathsNum",BathsNum );
		request.setAttribute("BedRoomsNum",BedRoomsNum );
		request.setAttribute("SquareSpace",SquareSpace );
		request.setAttribute("RoomType",RoomType );
		request.setAttribute("Description",Description );
		request.setAttribute("MinNights",MinNights );
		request.setAttribute("Lat",Lat );
		request.setAttribute("Lon",Lon );
		request.setAttribute("Street",Street );
		request.setAttribute("Neighbourhood",Neighbourhood );
		request.setAttribute("Transit",Transit );
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/PropertyEdit.jsp");
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
