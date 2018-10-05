
public class Person {

	private String name;
	private String surname;
	private int age;
	private int phone;

	public void printAllInformation() {
		System.out.println(this.name + this.surname + this.age + this.phone);
	}

	public void printName() {
		System.out.println(this.name + this.surname);
	}

	public boolean isAdult() {
		if (this.age > 18) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
