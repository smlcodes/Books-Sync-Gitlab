package demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletExample extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		pw.write("<h1> GenericServletExample </h1>");
		pw.write("Servlet Info : "+getServletInfo());
		System.out.println("Servlet Info : "+getServletInfo());
	}

}
