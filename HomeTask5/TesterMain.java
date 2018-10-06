package tester;

public class TesterMain {

	public static void main(String[] args) {

		Tester.printRequirements();
		Tester tester1 = new Tester();
		Tester tester2 = new Tester("Alex", "Cujawski", "B1");
		Tester tester3 = new Tester("Alex", "Cujawski", "B1", 5);
		Tester tester4 = new Tester("Alex", "Cujawski", "B1", 5, 1000);
		tester4.print();
		System.out.println(tester4.validateTester(5));
		System.out.println(tester4.validateTester("B1"));
		System.out.println(tester4.validateTester(5, "B1", 1000));

	}

}
