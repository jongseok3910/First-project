package com.itwill.vo;

import java.util.Date;

/*
이름              널?       유형           
--------------- -------- ------------ 
MEMBER_ID       NOT NULL VARCHAR2(10) 
MEMBER_PASSWORD          VARCHAR2(12) 
MEMBER_NAME              VARCHAR2(20) 
MEMBER_PHONE             VARCHAR2(13) 
MEMBER_ADDRESS           NUMBER       
MEMBER_JOINDATE          DATE 
 */
public class MemberJoin {
	private String member_id;
	private String member_password;
	private String member_name;
	private String member_phone;
	private String member_address;
	private Date member_joinDate;
	
	public MemberJoin() {
		// TODO Auto-generated constructor stub
	}


	public MemberJoin(String member_id, String member_password, String member_name, String member_phone,
			String member_address) {
		super();
		this.member_id = member_id;
		this.member_password = member_password;
		this.member_name = member_name;
		this.member_phone = member_phone;
		this.member_address = member_address;
	}


	public MemberJoin(String member_id, String member_password, String member_name, String member_phone,
			String member_address, Date member_joinDate) {
		super();
		this.member_id = member_id;
		this.member_password = member_password;
		this.member_name = member_name;
		this.member_phone = member_phone;
		this.member_address = member_address;
		this.member_joinDate = member_joinDate;
	}


	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public Date getMember_joinDate() {
		return member_joinDate;
	}

	public void setMember_joinDate(Date member_joinDate) {
		this.member_joinDate = member_joinDate;
	}

	@Override
	public String toString() {
		return "MemberJoin [member_id=" + member_id + ", member_password=" + member_password + ", member_name="
				+ member_name + ", member_phone=" + member_phone + ", member_address=" + member_address
				+ ", member_joinDate=" + member_joinDate + "]";
	}
	
}
