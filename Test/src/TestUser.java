
public class TestUser {
	
	private Integer id;
	private String name;
	private Integer standard;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStandard() {
		return standard;
	}
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	@Override
	public String toString() {
		return "TestUser [id=" + id + ", name=" + name + ", standard=" + standard + "]";
	}
	
	
	
	

}
