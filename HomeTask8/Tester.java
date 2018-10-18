package tester;

public class Tester {

	public String name;
	String surname;
	protected int expirienceInYears;
	protected String englishLevel;
	private int salary;
	
	public Tester() {
		
	};
	
	Tester(String name, String surname) {
		this.name=name;
		this.surname=surname;
		
	}
	
	Tester(String name, String surname, int expirienceInYears) {
		this(name,surname);
		this.expirienceInYears=expirienceInYears;
	}
	
	public Tester (String name, String surname, int expirienceInYears,
			String englishLevel, int salary) {
		this(name,surname,expirienceInYears);
		this.englishLevel=englishLevel;
		this.salary=salary;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	int getExpirienceInYears() {
		return expirienceInYears;
	}

	void setExpirienceInYears(int expirienceInYears) {
		this.expirienceInYears = expirienceInYears;
	}

	String getEnglishLevel() {
		return englishLevel;
	}

	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	int getSalary() {
		return salary;
	}

	void setSalary(int salary) {
		this.salary = salary;
	}
	
	private int bonusToSalary() {
		int bonus=2;
		return salary*bonus;
	}
	
	int expirienseOnMonths() {
		int numberMonthInYear=12;
		return expirienceInYears*numberMonthInYear;
	}
	
	protected void getNameSurname() {
		System.out.println("Name: " + name + " Surname: " +surname);
	}
	
	public void printAllInformationAboutTester() {
		System.out.println("Name: " + name + " Surname: " + surname + 
				" Expirience in years: " + expirienceInYears + " English level: " +
				englishLevel + " Salary: " + salary);
	}
}
