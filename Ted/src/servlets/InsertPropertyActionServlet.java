package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.PrintWriter;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CalendarDAO;
import dao.CalendarDAOImpl;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import model.Listing;
import model.User;

/**
 * Servlet implementation class InsertPropertyActionServlet
 */
@WebServlet("/InsertPropertyActionServlet")
@MultipartConfig(fileSizeThreshold = 1024*1024*2, maxFileSize = 1024*1024*10,maxRequestSize = 1024*1024*50)

public class InsertPropertyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "UploadedImages";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPropertyActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html:charset-UTF-8");
		PrintWriter out = response.getWriter();
		String savePath = 	"C:/Users/turbox/workspace/Ted/WebContent/images"  
				+ File.separator + SAVE_DIR;
		String savePath2 = 	"images"  
				+ "/" + SAVE_DIR;
		/*String savePath = "C:/Users/Apostolos/Dropbox/TED/dimitris/Ted/WebContent" 
				+ File.separator + SAVE_DIR;
		*/
		File fileSaveDir = new File(savePath);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		HttpSession session = request.getSession(false);
		
		String Lat = (String)request.getParameter("Lat");
		String Lon = (String)request.getParameter("Lon");
		
		float la = Float.parseFloat(Lat);
		float lo = Float.parseFloat(Lon);
		
		String Street = (String)request.getParameter("Street");
		String Transit = (String)request.getParameter("Transit");
		String MaxPeople = (String)request.getParameter("MaxPeople");
		int maxpeople = Integer.parseInt(MaxPeople);
		String MinNights = (String)request.getParameter("MinNights");
		int minnights = Integer.parseInt(MinNights);
		String Type = (String)request.getParameter("Type");
		String ExtraCostPerPerson = (String)request.getParameter("ExtraCostPerPerson");
		String extrapeople = ExtraCostPerPerson + "$";
		String Description = (String)request.getParameter("Description");
		String BedsNum = (String)request.getParameter("BedsNum");
		int bedsnum = Integer.parseInt(BedsNum);
		String BedRoomsNum = (String)request.getParameter("BedRoomsNum");
		int bedroomsnum = Integer.parseInt(BedRoomsNum);
		String BathsNum = (String)request.getParameter("BathsNum");
		float bathsnum = Float.parseFloat(BathsNum);
		String City = (String)request.getParameter("City");
		String Country = (String)request.getParameter("Country");
		String Neighborhood = (String)request.getParameter("Neighborhood");
		String Price = (String)request.getParameter("Price");
		String price  = "$" + Price +".00";
		String Amenities = "{";
		String TV = (String)request.getParameter("box1");
		String Wifi = (String)request.getParameter("box2");
		String Kitchen = (String)request.getParameter("box3");
		String AirCond = (String)request.getParameter("box4");
		String Smoking = (String)request.getParameter("box5");
		String Pets = (String)request.getParameter("box6");
		if (TV!=null) Amenities +=  "TV,";
		if (Wifi!=null) Amenities +=  "Wireless Internet,";
		if (Kitchen!=null) Amenities +=  "Kitchen,";
		if (AirCond!=null) Amenities +=  "Air Condition,";
		if (Smoking!=null) Amenities +=  "Smoking,";
		if (Pets!=null) Amenities +=  "Pets Allowed,";
		Amenities += "}";
		
		Part part = request.getPart("file");
		Part part1 = request.getPart("file1");
		Part part2 = request.getPart("file2");
		Part part3 = request.getPart("file3");
		Part part4 = request.getPart("file4");
		
		//read Rent Dates and save them to list_from_date and to list_to_date
		List<String> list_from_date = new ArrayList<String>();
		List<String> list_to_date = new ArrayList<String>();
		String name1 = "from1";
		String name2 = "to1";
		String d1 = (String)request.getParameter("from1");
		String d2 = (String)request.getParameter("to1");
		int counter = 1;
		
		while(d1 != null)
		{
			list_from_date.add(d1);
			list_to_date.add(d2);		
			counter++;
			//update names of getParameter for the next iteration
			name1 = "from" + counter;
			name2 = "to" + counter;
			d1 = (String)request.getParameter(name1);
			d2 = (String)request.getParameter(name2);
		}
		
		
		String idstr = (String)session.getAttribute("idUser");
		String role1 = (String)session.getAttribute("role1");
		String role2 = (String)session.getAttribute("role2");

		int idUser = Integer.parseInt(idstr);
		
		User user1 = (User)session.getAttribute("logedInUser");
		
		Listing listing  = new Listing(user1,price,Country,Neighborhood,City,la,lo,Street,Transit,maxpeople,minnights,Type,ExtraCostPerPerson,Amenities,Description,bedsnum,bathsnum,bedroomsnum);
		user1.addListing(listing);
		ListingDAO dao = new ListingDAOImpl();
		CalendarDAO dao2 = new CalendarDAOImpl();
		//insert new Listing to db
		dao.create(listing);
		//add photo to the listing (use propertyId to the name of the photo)
		int prop_id = listing.getId();
		String id_pr = Integer.toString(prop_id);
		String photo = savePath + File.separator + "property" + id_pr + ".jpg";
		String photo1 = savePath + File.separator + "LivingRoom" + id_pr+ ".jpg";
		String photo2 = savePath + File.separator + "DiningRoom" + id_pr+ ".jpg";
		String photo3 = savePath + File.separator + "BedRoom" + id_pr+ ".jpg";
		String photo4 = savePath + File.separator + "OtherRoom" + id_pr+ ".jpg";
		
		String phot = savePath2 + "/" + "property" + id_pr + ".jpg";
		String phot1 = savePath2 + "/" + "LivingRoom" + id_pr + ".jpg";
		String phot2 = savePath2 + "/" + "DiningRoom" + id_pr + ".jpg";
		String phot3 = savePath2 + "/" + "BedRoom" + id_pr + ".jpg";
		String phot4 = savePath2 + "/" + "OtherRoom" + id_pr + ".jpg";
		
		part.write(photo);
		part1.write(photo1);
		part2.write(photo2);
		part3.write(photo3);
		part4.write(photo4);
		dao.add_photo(phot, prop_id, phot1, phot2, phot3, phot4);
		//insert new Calendar for this Listing to db
		for (int i = 0; i < list_from_date.size(); i++) {
			dao2.create(listing, list_from_date.get(i), list_to_date.get(i), null);//set here null to price!!!!!
		}
		
		RequestDispatcher disp1 = getServletContext().getRequestDispatcher("/logedIn.jsp");
		RequestDispatcher disp2 = getServletContext().getRequestDispatcher("/logedIn-host_tenant.jsp");
		
		if((role1.equals("host")) && (role2 == null)) 	disp1.forward(request, response);
		else	disp2.forward(request, response);

	}

}
