package com._520it.vo;

public class Select {
	
	private String cid;
	private String pname;
	private String is_hot;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(String is_hot) {
		this.is_hot = is_hot;
	}
	@Override
	public String toString() {
		return "Select [cid=" + cid + ", pname=" + pname + ", is_hot=" + is_hot + "]";
	}
	

}
