package com.app.service;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorService {

	Vendor autheticateUser(String email , String pwd);
	List<Vendor> listVendors();
}
