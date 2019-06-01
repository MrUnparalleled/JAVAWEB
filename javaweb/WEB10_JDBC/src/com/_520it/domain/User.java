package com._520it.domain;

public class User {

	private int id;
	private String uname;
	private String upassword;
	
	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upassword=" + upassword + "]";
	}
	
	
	
}
