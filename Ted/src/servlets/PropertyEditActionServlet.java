package servlets;

import java.io.IOException;

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

import dao.ListingDAO;
import dao.ListingDAOImpl;
import model.User;

/**
 * Servlet implementation class PropertyEditActionServlet
 */
@WebServlet("/PropertyEditActionServlet")
@MultipartConfig(fileSizeThreshold = 1024*1024*2, maxFileSize = 1024*1024*10,maxRequestSize = 1024*1024*50)
public class PropertyEditActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "UploadedImages";

	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyEditActionServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html:charset-UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String savePath = "C:/Users/turbox/workspace/Ted/WebContent/images"
				+ File.separator + SAVE_DIR;
		String savePath2 = 	"images"  
				+ "/" + SAVE_DIR;
		/*String savePath = "C:/Users/Apostolos/Dropbox/TED/dimitris/Ted/WebContent" 
				+ File.separator + SAVE_DIR;
		*/
		File fileSaveDir = new File(savePath);
		
		HttpSession session = request.getSession(false);
		String role1 = (String)session.getAttribute("role1");
		String role2 = (String)session.getAttribute("role2");
		
		String BedsNum = (String)request.getParameter("BedsNum");
		int bedsnum = Integer.parseInt(BedsNum);
	    String BathsNum = (String)request.getParameter("BathsNum");
	    float bathsnum = Float.parseFloat(BathsNum);
	    String BedRoomsNum = (String)request.getParameter("BedRoomsNum");
	    int bedroomsnum = Integer.parseInt(BedRoomsNum);
	    String RoomType = (String)request.getParameter("RoomType");
	    String Description = (String)request.getParameter("Description");
		String MinNights = (String)request.getParameter("MinNights");
		int minnights = Integer.parseInt(MinNights);
		String Street = (String)request.getParameter("Street");
		String Neighbourhood = (String)request.getParameter("Neighbourhood");
		String Transit = (String)request.getParameter("Transit");
		String PropId = (String)request.getParameter("PropId");
		int propid = Integer.parseInt(PropId);
		String Lat = (String)request.getParameter("Lat");
		String Lon = (String)request.getParameter("Lon");
		float la = Float.parseFloat(Lat);
		float lo = Float.parseFloat(Lon);
		
		Part part = request.getPart("file");
		
		ListingDAO dao = new ListingDAOImpl();
		dao.update(propid,la,lo,Transit,Neighbourhood,Street,minnights,Description,RoomType,bathsnum,bedroomsnum,bedsnum);
		
		if(part!=null){
			User user1 = (User)session.getAttribute("logedInUser");
			String id_pr = Integer.toString(propid);
			String photo = savePath + File.separator + "property" + id_pr + ".jpg";
			
			File file = new File(photo);
			file.delete();
			
			part.write(photo);
			String photo2 = savePath2 + "/" + "property" + id_pr + ".jpg";
			dao.add_photo(photo2, propid, null, null, null, null);
		}
		
		RequestDispatcher disp1 = getServletContext().getRequestDispatcher("/logedIn.jsp");
		RequestDispatcher disp2 = getServletContext().getRequestDispatcher("/logedIn-host_tenant.jsp");
		
		if((role1.equals("host")) && (role2 == null)) 	disp1.forward(request, response);
		else	disp2.forward(request, response);	
		
		
	}

}
