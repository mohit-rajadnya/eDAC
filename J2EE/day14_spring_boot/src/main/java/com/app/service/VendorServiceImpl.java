package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@Service//to tell sc, class is a spring bean containing BL
@Transactional//tell SC to automate tx management(will be done by spring supplied hibernate supplied tx manager :o.s.orm.hibernate5.HibernateTransactionManager
public class VendorServiceImpl implements IVendorService {

	//dependency : DAO layer interface
	@Autowired
	private IVendorDao vendorDao;
	@Override
	public Vendor autheticateUser(String email, String pwd) {
		
		return vendorDao.autheticateUser(email, pwd);
	}
	@Override
	public List<Vendor> listVendors() {
		return vendorDao.listVendors();
	}

}
