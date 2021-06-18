package demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		String user = req.getParameter("username");
		String pwd = req.getParameter("password");

		pw.write("<h1>Welcome," + user + " </h1>");
		System.out.println("<h1>Welcome," + user + " </h1>");

		req.getRequestDispatcher("/home.jsp").include(req, res);

	}

}
