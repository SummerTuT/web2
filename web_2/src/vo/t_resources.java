package vo;

public class t_resources {
	private int id;
	private String resourceName;
	private String url;
	public t_resources(int id, String resourceName, String url) {
		super();
		this.id = id;
		this.resourceName = resourceName;
		this.url = url;
	}
	public t_resources() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
