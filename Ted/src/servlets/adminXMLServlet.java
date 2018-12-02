package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import dao.ReviewDAO;
import dao.ReviewDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.ListListing;
import model.ListUser;
import model.Listing;
import model.ListingReview;
import model.User;
import model.XMLUser;
import model.XMLListing;
import model.XMLReview;

/**
 * Servlet implementation class adminXMLServlet
 */
@WebServlet("/adminXMLServlet")
public class adminXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminXMLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO dao = new UserDAOImpl();
		ListingDAO dao2 = new ListingDAOImpl();
		ReviewDAO dao3 = new ReviewDAOImpl();
		List<User> listings = dao.list();
		ListUser l = new ListUser();
		l.setList(new ArrayList<XMLUser>());
		int i,j,ll;
		for(i=0;i<listings.size();i++)
		{
			XMLUser u = new XMLUser(listings.get(i).getIdUser(),listings.get(i).getUsername(),listings.get(i).getPassword(),listings.get(i).getName(),listings.get(i).getSurname(),listings.get(i).getMail(),listings.get(i).getPhone());
			List<Listing> listing_list = dao2.findHostProp(u.getIdUser());
			ListListing l2 = new ListListing();
			l2.setList(new ArrayList<XMLListing>());
			for(j=0;j<listing_list.size();j++)
			{
				XMLListing new_listing = new XMLListing(listing_list.get(j).getId(),listing_list.get(j).getCountry(),listing_list.get(j).getNeighbourhood(),listing_list.get(j).getCity(),listing_list.get(j).getLatitude(),listing_list.get(j).getLongitude(),listing_list.get(j).getStreet(),listing_list.get(j).getTransit(),listing_list.get(j).getGuestsIncluded(),listing_list.get(j).getMinimumNights(),listing_list.get(j).getRoomType(),listing_list.get(j).getExtraPeople(),listing_list.get(j).getDescription(),listing_list.get(j).getBeds(),listing_list.get(j).getBathrooms(),listing_list.get(j).getBedrooms());
				List<Object[]> review_list = dao3.find_all_property_reviews(new_listing.getId());
				ListingReview l3 = new ListingReview();
				l3.setList(new ArrayList<XMLReview>());
				for(ll=0;ll<review_list.size();ll++)
				{
					XMLReview new_review = new XMLReview((int)review_list.get(ll)[1],(String)review_list.get(ll)[2],(String)review_list.get(ll)[4],(String)review_list.get(ll)[5]);
					l3.getList().add(new_review);
				}
				new_listing.setListing(l3);
				l2.getList().add(new_listing);
			}
			u.setListing(l2);
			l.getList().add(u);
		}			
		try {
			
			//Marshalling
			File file = new File("C:/Users/turbox/Desktop/di/тед/Ergasies/admin.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ListUser.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
			true);
			
			jaxbMarshaller.marshal(l, file);
			//jaxbMarshaller.marshal(l, System.out);
			
			
			}
			catch(Exception ex)
			{
			System.out.println(ex);
			}
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/xmlVerify.jsp");
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
