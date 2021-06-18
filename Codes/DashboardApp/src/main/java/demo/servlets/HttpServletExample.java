package demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;

public class HttpServletExample extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException {
		System.out.println("Public Service ........");
		PrintWriter pw = res.getWriter();
		pw.write("<h1> HttpServletExample ::  service(ServletRequest req, ServletResponse res) </h1>");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
		System.out.println("Protecd Service ........");
		PrintWriter pw = res.getWriter();
		pw.write("<h1> HttpServletExample ::  service(HttpServletRequest req, HttpServletResponse res)  </h1>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
		System.out.println("doGet() ....");
		PrintWriter pw = res.getWriter();
		pw.write("<h1> HttpServletExample ::  doGet(HttpServletRequest req, HttpServletResponse res)  </h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() ....");
		PrintWriter pw = res.getWriter();
		pw.write("<h1> HttpServletExample ::  doPost(HttpServletRequest req, HttpServletResponse res)  </h1>");
	}


}
