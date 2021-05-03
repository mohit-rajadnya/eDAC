package com.app.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Vendor;

@Repository//tells SC about Dao layer bean + enables exc translation mechanism(caches DB related exceptions and rethrows it as spring related exc
public class VendorDaoImpl implements IVendorDao {
	//dependency : SF
	@Autowired //byType
	private SessionFactory sf;

	@Override
	public Vendor autheticateUser(String email, String pwd) {
		String jpql = "select v from vendor v where email = :email and password = :password";
		
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("email", email).
				setParameter("password", pwd).getSingleResult();
	}

}
