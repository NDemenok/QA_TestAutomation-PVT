package otherPackage;

import tester.Tester;

public class OtherClass {

	public static void main(String[] args) {
		
		Tester tester1 = new Tester("Alex", "Cujawsky", 5, "C2", 2000);

		//tester.expirienseOnMonths(); �� ��������, �.�. ����� �� 
		//�������������� friendly �������� ������ ������ ������
		//tester.getNameSurname(); �� ��������, �.�. ������������ protected
		//��������� ������ ������ � ������-����������
		tester1.printAllInformationAboutTester();
	
	}

}
