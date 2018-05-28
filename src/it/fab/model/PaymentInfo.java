package it.fab.model;

import java.io.Serializable;

public class PaymentInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum PaymentType  {VISA, MASTERCARD, PAYPAL} ;
	
	private Double price;
	private PaymentType paymentType;
	
	
	public PaymentInfo(Double price, PaymentType paymentType) {
		super();
		this.price = price;
		this.paymentType = paymentType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	

}
