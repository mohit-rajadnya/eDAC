package com.app.dao;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Repository//tells SC about Dao layer bean + enables exc translation mechanism(caches DB related exceptions and rethrows it as spring related exc
public class VendorDaoImpl implements IVendorDao {
	//dependency : SF
	@Autowired //byType
	private EntityManager mgr;

	@Override
	public Vendor autheticateUser(String email, String pwd) {
		String jpql = "select v from Vendor v where email = :email and password = :password";
		
		return mgr.createQuery(jpql, Vendor.class).setParameter("email", email).
				setParameter("password", pwd).getSingleResult();
	}

	@Override
	public List<Vendor> listVendors() {
		String jpql = "select v from Vendor v where v.userRole = :role";
		return mgr.createNamedQuery(jpql, Vendor.class).setParameter("role", Role.VENDOR).getResultList();
	}

}
