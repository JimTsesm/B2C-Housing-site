package servlets;

import model.User;
import model.Role;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class adminEditServlet
 */
@WebServlet("/adminEditServlet")
public class adminEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		request.setAttribute("id",id);
		String username = request.getParameter("username");
		request.setAttribute("username",username);
		String password = request.getParameter("password");
		request.setAttribute("password",password);
		String name = request.getParameter("name");
		request.setAttribute("name",name);
		String surname = request.getParameter("surname");
		request.setAttribute("surname",surname);
		String mail = request.getParameter("mail");
		request.setAttribute("mail",mail);
		String phone = request.getParameter("phone");
		request.setAttribute("phone",phone);
		String photo = request.getParameter("photo");
		request.setAttribute("photo",photo);
		String role = request.getParameter("role");
		request.setAttribute("role",role);
		String req = request.getParameter("request");
		request.setAttribute("request",req);
		String reqID = request.getParameter("requestID");
		request.setAttribute("requestID",reqID);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/adminTableEdit.jsp");
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
