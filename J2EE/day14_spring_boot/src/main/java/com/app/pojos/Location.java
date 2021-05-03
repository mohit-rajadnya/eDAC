package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name = "locations_tbl")
public class Location extends BaseEntity {
	@Column(length=30)
	private String city;
	@Column(length=30)
	private String state;
	@Column(length=30)
	private String country;
	//unidirectional one to one asso with Vendor
	@OneToOne
	@JoinColumn(name="vendor_id")
	@MapsId//cols : vendor_id(Shared pk n fk referencing pk of vendors table) :@MapsId
	//without @MapsId : there would be separate PK for the locations table(i.e 5 cols : id,state,city,country,vendor)
	//How to tell hibernate to create a shared pk shared with vendors table
	private Vendor vendor;
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Location() {
		
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Location(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Location [city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	
	

}
