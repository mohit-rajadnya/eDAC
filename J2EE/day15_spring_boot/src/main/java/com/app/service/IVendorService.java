package com.app.service;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorService {

	Vendor autheticateUser(String email , String pwd);
	List<Vendor> listVendors();
	//add a method to delete vendor details
	String deleteVendorDetails(int vendorId);
	String registerVendor(Vendor transientVendor);
	
}