package it.fab.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.fab.ejb.PlaceOrder;

public class HandlePageIndex extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private PlaceOrder placeOrderBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set the response message's MIME type
		response.setContentType("text/html;charset=UTF-8");
		// Allocate a output writer to write the response message into the
		// network socket
		PrintWriter out = response.getWriter();
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html><head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title>Hello, World</title></head>");
			out.println("<body>");
			out.println("<h1>Hello, world!</h1>"); // says Hello

			out.println("<p>Page Index  is : <strong>" + placeOrderBean.showPageIndex() + "</strong></p>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close(); // Always close the output writer
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("Operation");
		String result = "";
		PrintWriter out = resp.getWriter();
		
		switch(operation){
		
		case "add":
			placeOrderBean.increasePage();
			result = "operation add compleated";
			break;
		case "remove":
			placeOrderBean.decreasePage();
			result = "operation remove compleated";
			break;
		default:
			result = "WARNing. no operation" +operation +  "found.";
		}
		   
			try {
			         out.println("<!DOCTYPE html>");
			         out.println("<html><head>");
			         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			         out.println("<title>Hello, World</title></head>");
			         out.println("<body>");
			         out.println("<h1>Hello, world!</h1>");  // says Hello
			         out.println("<p>"+result+ "</p>");
			         out.println("</body>");
			         out.println("</html>");
			      } finally {
			         out.close();  // Always close the output writer
			      }
			
		
	}

}
