package com.mfpe.loanwebportal.modelvo;



public class Admin {
	
	private String userid;

	private String upassword;

	private String uname;

	private String authToken;

	public Admin() {
		
	}

	public Admin(String userid, String upassword, String uname, String authToken) {
		super();
		this.userid = userid;
		this.upassword = upassword;
		this.uname = uname;
		this.authToken = authToken;
	}
	
	@Override
	public String toString() {
		return "Admin [userid=" + userid + ", upassword=" + upassword + ", uname=" + uname + ", authToken=" + authToken
				+ "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	

}
