package otherPackage;

import tester.Tester;

public class OtherClass {

	public static void main(String[] args) {
		
		Tester tester1 = new Tester("Alex", "Cujawsky", 5, "C2", 2000);

		//tester.expirienseOnMonths(); не работает, т.к. метод со 
		//спецификатором friendly доступен только внутри пакета
		//tester.getNameSurname(); не работает, т.к. спецификатор protected
		//позволяет доступ только в классе-наследнике
		tester1.printAllInformationAboutTester();
	
	}

}
