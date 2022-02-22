package com.bank.model;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	
	private String id;
	private String idclient;
	private String idproduct;
	private String nameproduct;
	private String accountnumber;
	private int maxmovements;
	private double maintenancecommission;
	private long ammount;
	private Authorities authorities;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
}
