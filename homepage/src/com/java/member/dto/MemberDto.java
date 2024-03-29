package com.java.member.dto;

import java.util.Date;

/**
 * @개발자 : 길찬호
 * @작성일 : 2019. 10. 25.						<---Shift + Alt  + J
 * @설명  :DTO(Data Transfer Object) java beans 역활 (getter setter / 생성자 / tostring)
 * 	
 */
          
public class MemberDto { //DTO == DB
	private int num;			//자동 증가 번호
	private String id;	//아이디
	private	 String password;	//비밀번호
	private String name;		//이름
	
	private String jumin1;	//앞주민
	private String jumin2;	//뒷주민
	private String email;	//이메일
	private String zipcode;	//우편번호
	private String address;	//주소

	private String job;	//직업
	private String mailing;	//메일수신
	private String interest;	//관심사	
	private String memberLevel;	//회원등급
	private Date registerDate;	//가입날짜
	
	public MemberDto() {}
														//생성자 사용안해도 생성해놓아야됨(다른사람이 사용할수있기 때문에)
	public MemberDto(int num, String id, String password, String name, String jumin1, String jumin2, String email,
			String zipcode, String address, String job, String mailing, String interest, String memberLevel,
			Date registerDate) {
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.email = email;
		this.zipcode = zipcode;
		this.address = address;
		this.job = job;
		this.mailing = mailing;
		this.interest = interest;
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

	public String getJumin1() {
		return jumin1;
	}

	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}

	public String getJumin2() {
		return jumin2;
	}

	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMailing() {
		return mailing;
	}

	public void setMailing(String mailing) {
		this.mailing = mailing;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
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
	public String toString() {	//String으로 값이 제대로들어오는지 확인
		return "MemberDto [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", jumin1="
				+ jumin1 + ", jumin2=" + jumin2 + ", email=" + email + ", zipcode=" + zipcode + ", address=" + address
				+ ", job=" + job + ", mailing=" + mailing + ", interest=" + interest + ", memberLevel=" + memberLevel
				+ ", registerDate=" + registerDate + "]";
	}
	
	

}
