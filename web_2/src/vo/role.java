package vo;

public class role {
	private int roled;
	private String roleName;
	public role() {
		super();
	}
	public role(int roled, String roleName) {
		super();
		this.roled = roled;
		this.roleName = roleName;
	}
	public int getRoled() {
		return roled;
	}
	public void setRoled(int roled) {
		this.roled = roled;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
