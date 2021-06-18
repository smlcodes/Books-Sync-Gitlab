<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%
    	out.print(" <h1> Welcome to jsp </h1>");    
    %>

    Date:<%=java.util.Calendar.getInstance().getTime()%>
    <%!int data = 50;%>
	<%="Value of the variable is:" + data%>
    
    
    
    <% 
out.print("1.welcome to jsp"); 

String name=request.getParameter("a");  
out.print("<br> 2.Request :"+name);  

//response.sendRedirect("http://www.google.com");  
out.print("3.Responce :  ");

String cfg=config.getInitParameter("config");  
out.print("<br> 4.Config ="+cfg);  

String cxt=application.getInitParameter("context");  
out.print("<br> 5.Application ="+cfg);

session.setAttribute("user","Satya");  
out.print("<br> 6.Session ="+session.getAttribute("user"));
%>
    