package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.IOUtils;

import dao.RequestDAO;
import dao.RequestDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Request;
import model.Role;
import model.User;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/signupActionServlet")
public class signupActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isMultipart = ServletFileUpload.isMultipartContent( request );
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/admin-tenantVerifyMessage.jsp");
		String userName = null;
		String password = null;
		String name = null;
		String surname = null;
		String email = null;
		String phone = null;
		String choice1 = null;
		String choice2 = null;
		byte[] photo = null;
		
		 if ( isMultipart )
	        {
	            // Create a new file upload handler
	            ServletFileUpload upload = new ServletFileUpload();
	            
	            try
	            {
	                // Parse the request
	                FileItemIterator iter = upload.getItemIterator( request );
	 
	                while ( iter.hasNext() )
	                {
	                    FileItemStream item = iter.next();
	                    String fieldName = item.getFieldName();
	                   String name2 = item.getName();
	                   

	                    if ( fieldName.equals( "photo" ) )
	                    {
	                        photo = IOUtils.toByteArray( item.openStream() );
	                    }
	                    else
	                    {
	                       InputStream stream = item.openStream();
	 	                   String value = Streams.asString(stream);
	 	                   if(fieldName.equals("username")) userName=value;
	 	                   else if(fieldName.equals("password"))	password=value;
	 	                   else if(fieldName.equals("name"))	name=value;
	 	                   else if(fieldName.equals("surname"))	surname=value;
	 	                   else if(fieldName.equals("email"))	email=value;
	 	                   else if(fieldName.equals("phone"))	phone=value;
	 	                   else if(fieldName.equals("box2"))	choice1=value;
	 	                   else if(fieldName.equals("box3"))	choice2=value;
	                    }
	                }
	            }
	            catch ( IOException ex )
	            {
	                throw ex;
	            }
	            catch ( Exception ex )
	            {
	                throw new ServletException( ex );
	            }
	        }
		

		UserDAO dao = new UserDAOImpl();
		User user = new User(userName,password,name,surname,email,phone,photo);

		if (dao.sameName_check(userName) == null) 
		{
			if(choice1 != null)
			{
				Role user_role2 = new Role("host");
				user.addRole(user_role2);
			}
			if(choice2 != null)
			{
				Role user_role3 = new Role("tenant");
				user.addRole(user_role3);
			}
			
			dao.create(user);

			if(choice1 != null)
			{
				Request req = new Request();
				req.setIdHost(user.getIdUser());
				RequestDAO dao2 = new RequestDAOImpl();
				user.setRequest(req);
				dao2.create(req);
				
				Request r = user.getRequest();
				System.out.println(r.getIdHost());
				
				RequestDispatcher disp2 = getServletContext().getRequestDispatcher("/hostVerifyMessage.jsp");
				disp2.forward(request, response);						
			}
		}
		else
		{
			RequestDispatcher disp3 = getServletContext().getRequestDispatcher("/signupError.jsp");
			disp3.forward(request, response);	
		}
		
				
		disp.forward(request, response);						
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
}
