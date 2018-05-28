package it.fab.model;

import java.util.List;

public class Order {

	private PaymentInfo paymentInfo;
	private ShippingInfo shippingInfo;
	private long userId;
	private List<Long> items;
	private Long orderID;
	
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public Order(PaymentInfo paymentInfo, ShippingInfo shippingInfo, long userId, List<Long> items) {
		super();
		this.paymentInfo = paymentInfo;
		this.shippingInfo = shippingInfo;
		this.userId = userId;
		this.items = items;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<Long> getItems() {
		return items;
	}

	public void setItems(List<Long> items) {
		this.items = items;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

}
