package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Service//to tell sc, class is a spring bean containing BL
@Transactional//tell SC to automate tx management(will be done by spring supplied hibernate supplied tx manager :o.s.orm.hibernate5.HibernateTransactionManager
public class VendorServiceImpl implements IVendorService {

	//dependency : DAO layer interface
	@Autowired
	private IVendorDao vendorService;
	@Override
	public Vendor autheticateUser(String email, String pwd) {
		
		return vendorService.autheticateUser(email, pwd);
	}
	@Override
	public List<Vendor> listVendors() {
		return vendorService.listVendors();
	}
	
	@Override
	public String deleteVendorDetails(int vendorId) {
		Vendor persistentVendor = vendorService.getVendorDetails(vendorId);
		if(persistentVendor!=null)
			return vendorService.deleteVendorDetails(persistentVendor);
		return "Vendor deletion failed!!";
	}
	@Override
	public String registerVendor(Vendor transientVendor) {
		transientVendor.setUserRole(Role.VENDOR);
		
		return vendorService.registerVendor(transientVendor);
	}
	
}
