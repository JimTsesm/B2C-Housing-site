package servlets;

import model.User;
import model.Listing;
import model.Role;
import dao.UserDAOImpl;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import dao.RequestDAO;
import dao.RequestDAOImpl;
import dao.UserDAO;
import lsh.LSHSuperBitExample;
import lsh.LSHMinHashExample;

import java.io.IOException;
import java.util.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOImpl;

/**
 * Servlet implementation class loginActionServlet
 */
@WebServlet("/loginActionServlet")
public class loginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO dao = new UserDAOImpl();
		User user = new User();
		user = dao.find(userName,password);
		
		//user does not exist
		if(user == null)
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/loginError.jsp");
			disp.forward(request, response);
		}
		else
		{
			RequestDispatcher disp1 = getServletContext().getRequestDispatcher("/logedIn.jsp");
			RequestDispatcher disp2 = getServletContext().getRequestDispatcher("/admin.jsp");
			RequestDispatcher disp3 = getServletContext().getRequestDispatcher("/logedIn-tenant.jsp");
			RequestDispatcher disp4 = getServletContext().getRequestDispatcher("/logedIn-host_tenant.jsp");
			RequestDispatcher disp5 = getServletContext().getRequestDispatcher("/logedIn-tenant_no_reccomend.jsp");
			RequestDispatcher disp6 = getServletContext().getRequestDispatcher("/logedIn-host_tenant_no_reccomend.jsp");
			
			//create HttpSession for this user
			HttpSession session = request.getSession(true);
			session.setAttribute("logedInUser", user);
			session.setAttribute("name", user.getName());
			session.setAttribute("surname", user.getSurname());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("idUser", Integer.toString(user.getIdUser()));
			session.setAttribute("password", user.getPassword());
			session.setAttribute("mail", user.getMail());
			session.setAttribute("phone", user.getPhone());
			session.setAttribute("photo", user.getPhoto());
			
			//get if host request is pending or not
			RequestDAO dao2 = new RequestDAOImpl();
			int Pend;
			if ((Pend = dao2.Request_check(user.getIdUser())) != -1) {
			session.setAttribute("Pending", Integer.toString(Pend));
			}
			
			Set<Role> roles = new HashSet<Role>();
			roles = user.getRoles();
			String role1 = null;
			String role2 = null;
			int count = 0;
			Iterator<Role> it = roles.iterator();
			while ( it.hasNext()) {
				if(count == 0)	role1 = it.next().getRole();
				else role2 = it.next().getRole();
				count++;
		    }
			
			session.setAttribute("role1", role1);
			session.setAttribute("role2", role2);

			//this user is admin.Go to Admin's page
			if(role1.equals("admin")) 	disp2.forward(request, response);
			//go to host page
			else if( (role1.equals("host")) && (role2 == null) ) disp1.forward(request, response);
			//go to tenant page or host_tenant page
			else 
			{
				//reccomend property according to user's reviews
				if(user.getHasReview() == 1)
				{
					//find reccomended properties of this user
					int []reccomendation = LSHSuperBitExample.reccomendation(user.getIdUser());
					int []user_vector = LSHMinHashExample.findUserVector(user.getIdUser());
					int []property_index = LSHMinHashExample.getPropertyIds();
					System.out.println(reccomendation[0]);
					System.out.println(reccomendation[1]);
					System.out.println(reccomendation[2]);
					ListingDAO dao5 = new ListingDAOImpl();
					Listing listing1 = dao5.find(reccomendation[0]);
					Listing listing2 = dao5.find(reccomendation[1]);
					Listing listing3 = dao5.find(reccomendation[2]);
					session.setAttribute("listing1", listing1);
					session.setAttribute("listing2", listing2);
					session.setAttribute("listing3", listing3);
					session.setAttribute("user_vector", user_vector);
					session.setAttribute("property_index", property_index);
				}
				//reccomend property accodring to clicks
				else if(user.getHasReview() == 0)
				{
					int []reccomendation = LSHMinHashExample.reccomendation(user.getIdUser());
					int []user_vector = LSHMinHashExample.findUserVector(user.getIdUser());
					int []property_index = LSHMinHashExample.getPropertyIds();
					ListingDAO dao5 = new ListingDAOImpl();
					Listing listing1 = dao5.find(reccomendation[0]);
					Listing listing2 = dao5.find(reccomendation[1]);
					Listing listing3 = dao5.find(reccomendation[2]);
					session.setAttribute("listing1", listing1);
					session.setAttribute("listing2", listing2);
					session.setAttribute("listing3", listing3);
					session.setAttribute("user_vector", user_vector);
					session.setAttribute("property_index", property_index);
				}
					if(user.getHasReview() != -1)
					{
						//go to tenant page
						if( (role1.equals("tenant")) && (role2 == null) ) disp3.forward(request, response);
						//go to tanant+host page
						else disp4.forward(request, response);
					}
					else
					{
						//go to tenant page
						if( (role1.equals("tenant")) && (role2 == null) ) disp5.forward(request, response);
						//go to tanant+host page
						else disp6.forward(request, response);
					}
				
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
