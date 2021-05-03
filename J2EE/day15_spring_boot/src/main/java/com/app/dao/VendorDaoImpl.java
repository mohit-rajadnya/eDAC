package com.app.dao;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Location;
import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Repository//tells SC about Dao layer bean + enables exc translation mechanism(caches DB related exceptions and rethrows it as spring related exc
public class VendorDaoImpl implements IVendorDao {
	//dependency : SF
	@Autowired //byType
	//or jpa speicific anno. = :  @PersistenceContext
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
		return mgr.createQuery(jpql, Vendor.class).setParameter("role", Role.VENDOR).getResultList();
	}

	@Override
	public String deleteVendorDetails(Vendor persistentVendor) {
		//since there exists one to one uni asso between Vendor n Location and the pk of locations table is fk which ref pk of vendors table
		//so you cannot directly delete vendors record(parent row)
		Location l = mgr.find(Location.class, persistentVendor.getId());
		if (l!=null)
		{
			mgr.remove(l);
			mgr.remove(persistentVendor);
			return "Vendor details  and location deleted for vendor " + persistentVendor.getName();
		}
		mgr.remove(persistentVendor);
		return "Vendor details deleter for vendor " + persistentVendor.getName();
	}

	@Override
	public Vendor getVendorDetails(int vendorId) {
		Vendor v = mgr.find(Vendor.class, vendorId);
		return v;
	}

	@Override
	public String registerVendor(Vendor transientVendor) {
		mgr.persist(transientVendor);
		return "Vendor details registered with reg ID " + transientVendor.getId();
	}

}
