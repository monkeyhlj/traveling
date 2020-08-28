package com.example.administrator.traveling.login;



import java.io.Serializable;

public class Information implements Serializable {
	private String lid;
	private String cname;
	private String place;
	private String special;
	
	public Information() {
		
	}

	public Information(String lid,String cname,String place,String special) {
		this.lid=lid;
		this.cname=cname;
		this.place=place;
		this.special=special;
	}
	
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid=lid;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname=cname;
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place=place;
	}
	
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special=special;
	}

	@Override
	public String toString() {
		return "Information{" +
				"lid='" + lid + '\'' +
				", cname='" + cname + '\'' +", place='" + place + '\''+", special='" + special + '\''+
				'}';
	}
}
