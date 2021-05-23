package entity;

public class Admin {
	private int id;
	private String userName;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void changeUserName(String newUserName)
	{
		this.setUserName(newUserName);
	}
	
	public void changePassword(String newPass)
	{
		this.setPassword(newPass);
	}
	
}
