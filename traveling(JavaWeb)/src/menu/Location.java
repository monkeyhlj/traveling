package menu;

public class Location {
	private String lid;
	private String lname;
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Location(String lid, String lname) {
		super();
		this.lid = lid;
		this.lname = lname;
	}
	
}
