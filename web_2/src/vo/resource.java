package vo;

public class resource {
	private int resourceId;
	private String resourceName;
	private String url;
	private String description;
	private int size;
	private int star;
	private String image;
	private String time;
	
	
	
	public resource() {
		super();
	}

	public resource(int resourceId, String resourceName, String url,
			String description, int size, int star, String image, String time) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.url = url;
		this.description = description;
		this.size = size;
		this.star = star;
		this.image = image;
		this.time = time;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
