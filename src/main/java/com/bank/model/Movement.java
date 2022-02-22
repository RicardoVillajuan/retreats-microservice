package com.bank.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movement {
	
	@Id
	private String id;
	private String idcustomer;
	private String typemovement;
	private Long ammount;
	private Double commissioncharged;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
}
