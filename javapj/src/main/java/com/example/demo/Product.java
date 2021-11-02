package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	
	private String pname;
	
	private int count;
	
	private String division;
	
	private String price;
	
	@ManyToOne
	@JoinColumn(name="mid", nullable=false)
	private Manager mg;
	
	
	
}
