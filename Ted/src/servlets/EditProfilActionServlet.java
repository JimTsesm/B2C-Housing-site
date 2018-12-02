package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.binary.Base64;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

/**
 * Servlet implementation class EditProfilActionServlet
 */
@WebServlet("/EditProfilActionServlet")
public class EditProfilActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfilActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		//String userName = (String)request.getParameter("FD_profile_username");
		//String password = (String)request.getParameter("FD_profile_password");
		//String name = (String)request.getParameter("FD_profile_first_name");
		//String surname = (String)request.getParameter("FD_profile_last_name");
		//String mail = (String)request.getParameter("FD_profile_email");
		//String phone = (String)request.getParameter("FD_profile_phone");
		String str_id = (String)session.getAttribute("idUser");
		
		String userName = null;
		String password = null;
		String name = null;
		String surname = null;
		String mail = null;
		String phone = null;
		//String str_id = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent( request );
		
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
	                    	int av = item.openStream().available();
	                    	if(av != 0)
	                    	{
	                    		System.out.println("ok");
	                    		photo = IOUtils.toByteArray( item.openStream() );	
	                    	}
	                    	else 
	                    	{
	                    		photo = (byte[]) session.getAttribute("photo");
	                    	}
		
	                    }
	                    else
	                    {
	                       InputStream stream = item.openStream();
	 	                   String value = Streams.asString(stream);
	 	                   if(fieldName.equals("FD_profile_username")) userName=value;
	 	                   else if(fieldName.equals("FD_profile_password"))	password=value;
	 	                   else if(fieldName.equals("FD_profile_first_name"))	name=value;
	 	                   else if(fieldName.equals("FD_profile_last_name"))	surname=value;
	 	                   else if(fieldName.equals("FD_profile_email"))	mail=value;
	 	                   else if(fieldName.equals("FD_profile_phone"))	phone=value;
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

		int id = Integer.parseInt(str_id);
		System.out.println(photo);

		
		UserDAO dao = new UserDAOImpl();
		User user = new User(userName,password,name,surname,mail,phone,photo);

		session.setAttribute("name", name);
		session.setAttribute("surname", surname);
		session.setAttribute("username", userName);
		session.setAttribute("id_User", str_id);
		session.setAttribute("password", password);
		session.setAttribute("mail", mail);
		session.setAttribute("phone", phone);
		session.setAttribute("photo", photo);
		
		String role1 = (String)session.getAttribute("role1");
		String role2 = (String)session.getAttribute("role2");
		
		dao.set_all(id,name,password,surname,mail,phone,photo);
		
		RequestDispatcher disp1 = getServletContext().getRequestDispatcher("/logedIn.jsp");
		RequestDispatcher disp2 = getServletContext().getRequestDispatcher("/logedIn-host_tenant.jsp");
		RequestDispatcher disp3 = getServletContext().getRequestDispatcher("/logedIn-tenant.jsp");
		
		if((role1.equals("host")) && (role2 == null)) 	disp1.forward(request, response);
		else if((role1.equals("tenant")) && (role2 == null)) disp3.forward(request, response);
		else	disp2.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
