package com.jm2002.learn.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowRegistrationPage
 */
@WebServlet("/ShowRegistrationPage")
public class ShowRegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRegistrationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd1 = request.getRequestDispatcher("header.html");
		RequestDispatcher rd2 = request.getRequestDispatcher("register.html");
		RequestDispatcher rd3 = request.getRequestDispatcher("footer.html");
		
		rd1.include(request, response);
		rd2.include(request, response);
		rd3.include(request, response);
				
	}

}
