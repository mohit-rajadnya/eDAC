package com.app.service;

import com.app.pojos.Vendor;

public interface IVendorService {

	Vendor autheticateUser(String email , String pwd);
}
