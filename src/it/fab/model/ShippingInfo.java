package it.fab.model;

public class ShippingInfo {
	
	private String address;
	private String name;
	private int phone_number;
	
	
	public String getAddress() {
		return address;
	}
	
	
	public ShippingInfo(String address, String name, int phone_number) {
		super();
		this.address = address;
		this.name = name;
		this.phone_number = phone_number;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	
	
	

}
