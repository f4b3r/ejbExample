package it.fab.ejb;

import javax.ejb.Local;

import it.fab.model.PaymentInfo;
import it.fab.model.ShippingInfo;

@Local
public interface PlaceOrder {
	
	Long showPageIndex();
	void increasePage();
	void decreasePage();
	void addItem(Long itemId);
	void setShippingInfo(ShippingInfo shippingInfo);
	void setPaymentInfo(PaymentInfo paymnetInfo);
	Long confirmOrder() throws Exception;
	
}
