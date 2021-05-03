package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	
	Vendor autheticateUser(String email , String pwd);
	List<Vendor> listVendors();
	String deleteVendorDetails(Vendor persistentVendor);
	Vendor getVendorDetails(int vendorId);
	//add method to register vendor
	String registerVendor(Vendor transientVendor);

}
