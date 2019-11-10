package com.ch.admin.dto;

import java.util.Date;

public class AdminDto {

	private int num;
	private String name;
	private String cateCode;
	private int price;
	private int stock;
	private String	des;
	private String img;
	private Date registerDate;
	
	
	public AdminDto() {}


	public AdminDto(int num, String name, String cateCode, int price, int stock, String des, String img,
			Date registerDate) {
		super();
		this.num = num;
		this.name = name;
		this.cateCode = cateCode;
		this.price = price;
		this.stock = stock;
		this.des = des;
		this.img = img;
		this.registerDate = registerDate;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCateCode() {
		return cateCode;
	}


	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	@Override
	public String toString() {
		return "AdminDto [num=" + num + ", name=" + name + ", cateCode=" + cateCode + ", price=" + price + ", stock="
				+ stock + ", des=" + des + ", img=" + img + ", registerDate=" + registerDate + "]";
	}
	
	
	
}
