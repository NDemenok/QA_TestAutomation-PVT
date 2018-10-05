package Massive;

public class ExampleForMassive {

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
		Massive mas = new Massive();
		mas.setArray(array1);
		mas.printMassiveAsLine();
		mas.printReverseMassiveAsLine();
		System.out.println(mas.getSumOfElements());
		mas.multiptyBy3();
		mas.printMassiveAsLine();
		mas.printReverseMassiveAsLine();
	}

}
