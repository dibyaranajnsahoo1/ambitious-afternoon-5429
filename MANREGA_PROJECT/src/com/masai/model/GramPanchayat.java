package com.masai.model;

public class GramPanchayat {
	
	private int gpid;
	private String gname;
	private String address;
	private String gmail;
	private String gphone;
	private String password;
	
	
	public GramPanchayat() {
		super();
	}
	
	public GramPanchayat(int gpid, String gname, String address, String gmail, String gphone, String password) {
		super();
		this.gpid = gpid;
		this.gname = gname;
		this.address = address;
		this.gmail = gmail;
		this.gphone = gphone;
		this.password = password;
	}
	
	
	public int getGpid() {
		return gpid;
	}
	public void setGpid(int gpid) {
		this.gpid = gpid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGphone() {
		return gphone;
	}
	public void setGphone(String gphone) {
		this.gphone = gphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	@Override
	public String toString() {
		return "GramPanchayat [gpid=" + gpid + ", gname=" + gname + ", address=" + address + ", gmail=" + gmail
				+ ", gphone=" + gphone + ", password=" + password + "]";
	}


	
	
	
	
	
	

}
