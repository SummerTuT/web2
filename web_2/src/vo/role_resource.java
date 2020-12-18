package vo;

public class role_resource {
	private int id;
	private int resourceId;
	private int roleId;
	public role_resource() {
		super();
	}
	public role_resource(int id, int resourceId, int roleId) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.roleId = roleId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
}
