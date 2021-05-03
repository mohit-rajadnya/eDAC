package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//name,email,password,regAmount,regDate(LocalDate)
@Entity
@Table(name = "vendors")
public class Vendor extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length =20)
	@Enumerated(EnumType.STRING)
	private Role userRole;
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	@Column(length = 20,unique =true)
	private String email;
	@Column(length = 20,nullable = false)
	private String password;
	@Column(name="reg_amt")
	private double regAmount;
	@Column(name="reg_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate regDate;
	@OneToMany(mappedBy = "acctOwner",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<BankAccount> accounts=new ArrayList<>();
	//one to one mapping between entity(vendor)---> ValueType(PaymentDetails)
	@Embedded//optional annotation(added only for understanding purpose)
	private PaymentDetails details;
	//one to many unidirectional mapping between Vendor(ENtity)1 ---> * String(Phone no)
	//how to tell hibernate : whatever follow is collection of basic value types
	@ElementCollection //mandatory otherwise mapping exception
	//how to specify name of collection table n FK col name
	@CollectionTable(name = "vendor_phones" , joinColumns= @JoinColumn(name="vendor_id")) // optional but recommended for clarity
	@Column(name="phone_no",length=10 , unique=true)
	private List<String> phoneNo = new ArrayList<String>();
	
	//one to many unidirectional asso between Entity(vendor)1--->*VendorServices(ValueType)
	//collection of composite(Embeddables)types
	@ElementCollection
	@CollectionTable(name = "vendor_services" , joinColumns = @JoinColumn(name="v_id"))
	private List<VendorService> services = new ArrayList<VendorService>();
	
	public List<VendorService> getServices() {
		return services;
	}
	public void setServices(List<VendorService> services) {
		this.services = services;
	}
	public List<String> getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(List<String> phoneNo) {
		this.phoneNo = phoneNo;
	}
	public PaymentDetails getDetails() {
		return details;
	}
	public void setDetails(PaymentDetails details) {
		this.details = details;
	}
	public Vendor() {
		System.out.println("in vendor ctor");
	}
	public Vendor(String name, String email, String password, double regAmount, LocalDate regDate, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		userRole = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "Vendor [name=" + name + ", email=" + email + ", regAmount=" + regAmount + ", regDate=" + regDate
				+ ", getId()=" + getId() + "]";
	}	
	//helper methods to add n remove acct
	public void addAccount(BankAccount a)
	{
		accounts.add(a);
		a.setAcctOwner(this);
	}
	public void removeAccount(BankAccount a)
	{
		accounts.remove(a);
		a.setAcctOwner(null);
	}
	}
