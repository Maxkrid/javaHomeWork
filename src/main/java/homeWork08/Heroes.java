package homeWork08;

public class Heroes {

	private int id;
	private String name;
	private String ultimate;

	public Heroes() {
	}

	public Heroes(String name, String ultimate) {
		this.name = name;
		this.ultimate = ultimate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUltimate() {
		return ultimate;
	}

	public void setUltimate(String ultimate) {
		this.ultimate = ultimate;
	}

	@Override
	public String toString() {
		return "Heroes [id=" + id + ", name=" + name + ", ultimate=" + ultimate + "]";
	}

}
