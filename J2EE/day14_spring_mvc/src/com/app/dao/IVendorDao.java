package com.app.dao;

import com.app.pojos.Vendor;

public interface IVendorDao {
	
	Vendor autheticateUser(String email , String pwd);

}
