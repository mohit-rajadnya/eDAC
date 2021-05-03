package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class VendorService {
	@Column(name="service_name",length = 20)
	private String name;
	@Column(name="contract_period",length = 20)
	private int contractPeriod;
	private double charges;
	public VendorService() {
		super();
	}
	@Override
	public String toString() {
		return "VendorService [name=" + name + ", contractPeriod=" + contractPeriod + ", charges=" + charges + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	public VendorService(String name, int contractPeriod, double charges) {
		super();
		this.name = name;
		this.contractPeriod = contractPeriod;
		this.charges = charges;
	}

}
