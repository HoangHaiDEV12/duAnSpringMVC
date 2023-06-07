package com.springweb.request.login;

public class OtpNewPassWord {

	private String otp1 ;
	private String otp2 ;
	private String otp3 ;
	private String otp4 ;
	private String otp5 ;
	private String otp6; 
	private String email;
	
	private String userPass;
	private String userPass1;
	
	
	
	public OtpNewPassWord() {
		super();
	}
	public OtpNewPassWord(String otp1, String otp2, String otp3, String otp4, String otp5, String otp6, String email,
			String userPass, String userPass1) {
		super();
		this.otp1 = otp1;
		this.otp2 = otp2;
		this.otp3 = otp3;
		this.otp4 = otp4;
		this.otp5 = otp5;
		this.otp6 = otp6;
		this.email = email;
		this.userPass = userPass;
		this.userPass1 = userPass1;
	}
	public String getOtp1() {
		return otp1;
	}
	public void setOtp1(String otp1) {
		this.otp1 = otp1;
	}
	public String getOtp2() {
		return otp2;
	}
	public void setOtp2(String otp2) {
		this.otp2 = otp2;
	}
	public String getOtp3() {
		return otp3;
	}
	public void setOtp3(String otp3) {
		this.otp3 = otp3;
	}
	public String getOtp4() {
		return otp4;
	}
	public void setOtp4(String otp4) {
		this.otp4 = otp4;
	}
	public String getOtp5() {
		return otp5;
	}
	public void setOtp5(String otp5) {
		this.otp5 = otp5;
	}
	public String getOtp6() {
		return otp6;
	}
	public void setOtp6(String otp6) {
		this.otp6 = otp6;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserPass1() {
		return userPass1;
	}
	public void setUserPass1(String userPass1) {
		this.userPass1 = userPass1;
	}

	
	
	
	
	
}