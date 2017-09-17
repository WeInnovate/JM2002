package com.jm2002.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaSevlet
 */
@WebServlet(
		urlPatterns = { "/javaRegistration" }, 
		initParams = { 
				@WebInitParam(name = "trainer", value = "Atul"), 
				@WebInitParam(name = "mob", value = "98765")
		})
public class JavaSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nm");
		ServletConfig cfg = getServletConfig();

		ServletContext ctx = cfg.getServletContext();
		String institute = ctx.getInitParameter("institute");
		String trnName = cfg.getInitParameter("trainer");
		String trnMob = cfg.getInitParameter("mob");
		
		PrintWriter pw = response.getWriter();
		pw.println(name);
		pw.print("<br>");
		pw.println("Trainer Name: "+trnName);
		pw.print("<br>");
		pw.println("Mobile Number: "+trnMob);
		pw.print("<br>");
		pw.println("Institute: "+institute);
		pw.print("<br>");
	}

}
