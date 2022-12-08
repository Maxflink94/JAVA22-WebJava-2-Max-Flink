package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bean;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("view/LoggedIn.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userData = request.getParameter("username");
		String passwordData = request.getParameter("password");
		
		String userOne = "Admin";
		String passwordOne = "admin";
		
		String userTwo = "Max";
		String passwordTwo = "flink";
		
		if (userData.equals(userOne) && passwordData.equals(passwordOne) || userData.equals(userTwo) && passwordData.equals(passwordTwo)) {
			
			Bean user = new Bean ();
			user.setUsername(userData);
			user.setPassword(passwordData);
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("isLoggedIn", user);
			RequestDispatcher rd = request.getRequestDispatcher("view/LoggedIn.jsp");
			rd.forward(request, response);
			
		} else {
			request.setAttribute("message", "Invalid username or password");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			HttpSession httpSession = request.getSession();
			httpSession.removeAttribute("isLoggedIn");
			response.sendRedirect("index.jsp");
			
		}
}
}
