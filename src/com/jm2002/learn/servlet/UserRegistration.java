package com.jm2002.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet({ "/UserRegistration", "/registerMe" })
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String number = request.getParameter("num");
		String email  = request.getParameter("email");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String[] courses = request.getParameterValues("courses");
		String qualification = request.getParameter("qual");
		String comment = request.getParameter("comment");
		
		PrintWriter out  = response.getWriter();
		out.print("<h1>"+name+"</h1>");
		out.print("<b>Number: </b>"+number);
		out.print("<br>");
		out.print("Email: "+email);
		out.print("<br>");
		out.print("Pass: "+pass);
		out.print("<br>");
		out.print("Gender: "+gender);
		out.print("<br>");
		out.print("Qualification: "+qualification);
		out.print("<br>");
		out.print("Comment: "+comment);
				
		out.print("<br>");
		
		for (int i = 0; i < courses.length; i++) {
			out.print(courses[i]);
			out.print("<br>");
		}
		
		
		
		
		
				
	
	}

}
