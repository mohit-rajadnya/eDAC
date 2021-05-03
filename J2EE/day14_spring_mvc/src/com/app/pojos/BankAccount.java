package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// type (enum) , balance
@Entity
@Table(name="bank_accts")
public class BankAccount extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@Column(name="type",length = 20)
	private AcctType acctType;
	private double balance;
	@ManyToOne
	@JoinColumn(name="v_id",nullable = false)
	private Vendor acctOwner;
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	public BankAccount(AcctType acctType, double balance) {
		super();
		this.acctType = acctType;
		this.balance = balance;
	}
	public AcctType getAcctType() {
		return acctType;
	}
	public void setAcctType(AcctType acctType) {
		this.acctType = acctType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Vendor getAcctOwner() {
		return acctOwner;
	}
	public void setAcctOwner(Vendor acctOwner) {
		this.acctOwner = acctOwner;
	}
	@Override
	public String toString() {
		return "BankAccount [acctType=" + acctType + ", balance=" + balance + ", getId()=" + getId() + "]";
	}
	
	
}
