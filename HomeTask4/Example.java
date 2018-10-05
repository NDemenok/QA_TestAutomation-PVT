
public class Example {

	public static void main(String[] args) {

		Person person1 = new Person();
		person1.setName("Natallia");
		person1.setSurname("Dzemianok");
		person1.setAge(32);
		person1.setPhone(7031332);
		person1.printAllInformation();
		person1.printName();
		System.out.println(person1.isAdult());
	}

}
