package com.example.demo.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cn;
	
	private int count;
	
	private String price;
	
	@ManyToOne
	@JoinColumn(name="uid")
	private User u;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Product pd;
}