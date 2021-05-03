package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class ShipmentDetails implements Serializable {

	private String city , zipcode , phNo;
	private LocalDate shipmentDate;
	public ShipmentDetails(String city, String zipcode, String phNo, LocalDate shipmentDate) {
		super();
		this.city = city;
		this.zipcode = zipcode;
		this.phNo = phNo;
		this.shipmentDate = shipmentDate;
	}
	@Override
	public String toString() {
		return "ShipmentDetails [city=" + city + ", zipcode=" + zipcode + ", phNo=" + phNo + ", shipmentDate="
				+ shipmentDate + "]";
	}
	
	
	
}
