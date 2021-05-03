package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class PaymentDetails {
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="payment_mode",length=20)
	private PaymentMode mode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	private double amount;
	public PaymentDetails(PaymentMode mode, LocalDate paymentDate, double amount) {
		super();
		this.mode = mode;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentDetails() {}

	
}
