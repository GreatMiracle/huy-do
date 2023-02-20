package com.example.demo.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	private String name;
	private String image;
	private int price;
	private Date createdDate;
	private int available;
	private int category;
	
}
