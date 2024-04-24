package com.tharun.Bank_application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="logs")
public class Logger {
	
	public Logger(long account_no,String transactionStatus, String transactionType, double initBalance, double finBalance) {
		super();
		this.transactionStatus = transactionStatus;
		this.transactionType = transactionType;
		this.initBalance = initBalance;
		this.finBalance = finBalance;
		this.account_no = account_no;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	
	private long account_no;
	private String transactionStatus;
	private String transactionType;
	private double initBalance;
	private double finBalance;

	
	
	
	

}
