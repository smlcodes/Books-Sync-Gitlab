package demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletApp implements Servlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init method : ServletConfig ::" + config);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		pw.write("<h1> Service method Called ");
	}

	@Override
	public void destroy() {
		System.out.println("destroy method : called ::");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("destroy getServletInfo : called ::");
		return "getServletInfo";
	}

}
