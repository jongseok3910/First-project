package com.itwill.vo;
/*
이름               널?       유형           
---------------- -------- ------------ 
MEMBER_NO        NOT NULL VARCHAR2(255)       
MEMBER_ID                 VARCHAR2(10) 
CARD_NO                   VARCHAR2(19) 
MEMBER_AUTOLOGIN          VARCHAR2(1)  
 */
public class MemberInfo {
	private String member_no;
	private String member_id;
	private String card_no;
	private String member_autologin;
	
	public MemberInfo() {
		// TODO Auto-generated constructor stub
	}

	public MemberInfo(String member_no, String member_id, String card_no, String member_autologin) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.card_no = card_no;
		this.member_autologin = member_autologin;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getMember_autologin() {
		return member_autologin;
	}

	public void setMember_autologin(String member_autologin) {
		this.member_autologin = member_autologin;
	}

	@Override
	public String toString() {
		return "MemberInfo [member_no=" + member_no + ", member_id=" + member_id + ", card_no=" + card_no
				+ ", member_autologin=" + member_autologin + "]";
	}
	
}
