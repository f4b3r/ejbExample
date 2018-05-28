package it.fab.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import it.fab.init.CamelContextFactory;
import it.fab.model.Order;
import it.fab.model.PaymentInfo;
import it.fab.model.PaymentInfo.PaymentType;
import it.fab.model.ShippingInfo;

@Stateful
public class PlaceOrderBean implements PlaceOrder{

	private ShippingInfo shippingInfo;
	private PaymentInfo paymentInfo;
	private List<Long> items;
	private long userId;
	private Long pageIndex;
	
	 public PlaceOrderBean() {
		 items = new ArrayList<>();
		 pageIndex = 0L;
	}
	@Override
	public void addItem(Long itemId) {
		items.add(itemId);
		
	}

	@Override
	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
		
	}

	@Override
	public void setPaymentInfo(PaymentInfo paymnetInfo) {
		this.paymentInfo = paymnetInfo;
		
	}

	@Override
	public Long confirmOrder() throws Exception {
		Order order = new Order(paymentInfo, shippingInfo, userId, items);
		//save order to DB
		PaymentInfo payInfo = new PaymentInfo(20.0, PaymentType.MASTERCARD);
		order.setPaymentInfo(payInfo);
		order = saveOrder(order);
		System.out.println("Confirm Order with following items: \n" );
		System.out.println("item Size: " + items.size() );
		for (Long long1 : items) {
			
			System.out.println(long1 + "\n" );
		}
		return order.getOrderID();
	}
	private Order saveOrder(Order order) throws Exception {
		CamelContext  camelcontext = CamelContextFactory.getInstance();
		 ProducerTemplate template = camelcontext.createProducerTemplate();
		 try{
		 camelcontext.start();
		 
		 template.sendBody("activemq:billing.queue", order.getPaymentInfo());
		 }catch(Exception e){
			 throw new Exception(e);
		 } finally{
			 try {
				camelcontext.stop();
			} catch (Exception e) {
			System.out.println(e);
			}
		 }
		return order;
		
	}
	@Override
	public Long showPageIndex() {
		return pageIndex;
	}
	@Override
	public void increasePage() {
		pageIndex ++;
		
	}
	@Override
	public void decreasePage() {
		pageIndex--;
	}

}
