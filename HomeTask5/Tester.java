package tester;

public class Tester {

	String name;
	String surname;
	int experienceInYears;
	String englishLevel;
	int salary;

	public Tester() {
	};

	public Tester(String name, String surname, String english) {
		this.name = name;
		this.surname = surname;
		this.englishLevel = english;
	}

	public Tester(String name, String surname, String english, int experience) {
		this(name, surname, english);
		this.experienceInYears = experience;
	}

	public Tester(String name, String surname, String english, int experience, int salary) {
		this(name, surname, english, experience);
		this.salary = salary;
	}

	public boolean validateTester(int experience) {
		return this.experienceInYears >= experience;
	}

	public boolean validateTester(String english) {
		return this.englishLevel.equals(english);
		// english.equals("B1") || english.equals("B2") || english.equals("C1")
		// || english.equals("C2");
	}

	public boolean validateTester(int experience, String english, int salaryOffer) {
		return this.salary <= salaryOffer && validateTester(experience) && validateTester(english);
	}

	public static void printRequirements() {
		System.out.println("Requirements for Tester: experience more than 2 years, "
				+ "enlish level B1, last salary smaller than offers");
	}

	public void print() {
		System.out.println(this.name + " " + this.surname + " " + this.englishLevel + " " + this.experienceInYears + " "
				+ this.salary);
	}
}