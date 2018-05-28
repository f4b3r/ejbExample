package it.fab.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.fab.ejb.PlaceOrder;
import it.fab.model.PaymentInfo;
import it.fab.model.PaymentInfo.PaymentType;
import it.fab.model.ShippingInfo;


public class AddItemServlet  extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private   PlaceOrder placeOrderBean;
	private Long orderNumber;
	
	private  void addItem(Long itemID){
		System.out.println("addItem EJB... id = " + itemID);
//		placeOrderBean.setPaymentInfo(new PaymentInfo(20.5,PaymentType.PAYPAL));
//		placeOrderBean.setShippingInfo(new ShippingInfo("Strawberry Street", "Paul John", 32310321));
		placeOrderBean.addItem(itemID);
//		placeOrderBean.addItem(204L);
//		orderNumber = placeOrderBean.confirmOrder();
		
//		System.out.println("OrderProcess complete... orderID = " + orderNumber);
	}
	
	 @Override
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
		 if(request.getQueryString().contains("itemID")){
		 Long itemId = Long.parseLong(request.getParameter("itemID"));
		 addItem(itemId);
		 // Set the response message's MIME type
	      response.setContentType("text/html;charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      // Write the response message, in an HTML page
	      try {
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
	         out.println("<p>AddedItem : <strong>" + request.getParameter("itemID") + "</strong></p>");
	         out.println("<p>ShoppingCart ID : <strong>" + placeOrderBean + "</strong></p>");
	         out.println("</body>");
	         out.println("</html>");
	      } finally {
	         out.close();  // Always close the output writer
	      }
		 }
		 else{
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

}
