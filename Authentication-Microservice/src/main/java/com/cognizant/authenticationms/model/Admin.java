package com.cognizant.authenticationms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@Column(name = "userid", length = 20)
	private String userid;

	@Column(name = "upassword", length = 20)
	private String upassword;

	@Column(name = "uname", length = 20)
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

	@Override
	public String toString() {
		return "Admin [userid=" + userid + ", upassword=" + upassword + ", uname=" + uname + ", authToken=" + authToken
				+ "]";
	}
	
		

}
