package vo;

public class user_role {
	private int id;
	private int roleId;
	private String userName;
	public user_role() {
		super();
	}
	public user_role(int id, int roleId, String userName) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
