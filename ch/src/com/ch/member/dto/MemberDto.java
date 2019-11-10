package com.ch.member.dto;

import java.util.Date;

public class MemberDto {
	private int num;			//자동 증가 번호
	private String id;	//아이디
	private	 String password;	//비밀번호
	private String name;		//이름
	private int born;			//년도
	private int month;			//월
	private int year;						//일
	private String gender;
	
	private String email;	//이메일

	private String memberLevel;	//회원등급
	private Date registerDate;	//가입날짜

	public  MemberDto() {}

	
	
	public MemberDto(int num, String id, String password, String name, int born, int month, int year, String gender,
			String email, String memberLevel, Date registerDate) {
		super();
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.born = born;
		this.month = month;
		this.year = year;
		this.gender = gender;
		this.email = email;
		this.memberLevel = memberLevel;
		this.registerDate = registerDate;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBorn() {
		return born;
	}

	public void setBorn(int born) {
		this.born = born;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}



	@Override
	public String toString() {
		return "MemberDto [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", born=" + born
				+ ", month=" + month + ", year=" + year + ", gender=" + gender + ", email=" + email + ", memberLevel="
				+ memberLevel + ", registerDate=" + registerDate + "]";
	}
	
	

}



