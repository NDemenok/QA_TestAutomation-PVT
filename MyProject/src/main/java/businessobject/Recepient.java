package businessobject;

public class Recepient {

	private int id;
	private String address;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Recepient: : id=" + this.id + " address=" + this.address + " name=" + this.name;
	}
}
