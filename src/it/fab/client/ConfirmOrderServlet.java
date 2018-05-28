package it.fab.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.fab.ejb.PlaceOrder;

public class ConfirmOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@EJB
	private   PlaceOrder placeOrderBean;
	
	 @Override
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
		 
		 // Set the response message's MIME type
	      response.setContentType("text/html;charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      // Write the response message, in an HTML page
		 try{
		 placeOrderBean.confirmOrder();
		 }
		 catch(Exception e){
			 out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Hello, World</title></head>");
	         out.println("<body>");
	         out.println("<h1>ERRORE DI SISTEMA</h1>");  // says Hello
	         out.println("</body>");
	         out.println("</html>");
		 } 
		 try{
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Hello, World</title></head>");
	         out.println("<body>");
	         out.println("<h1>Hello, world!</h1>");  // says Hello
	         // Echo client's request information
	         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
	         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
	         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
	         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
	         out.println("<p>Session ID: <strong>" + request.getSession().getId() + "</strong></p>");
	         out.println("<p>ChartNumerb: <strong>" + placeOrderBean + "</strong></p>");
	         out.println("</body>");
	         out.println("</html>");
		 }
	      finally {
	         out.close();  // Always close the output writer
	      }

	
}
}