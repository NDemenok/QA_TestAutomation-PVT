package Massive;

public class Massive {

	private int[] array;

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public void printMassiveAsLine() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public void printReverseMassiveAsLine() {
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public int getSumOfElements() {
		int summ = 0;
		for (int i = 0; i < array.length; i++) {
			summ += array[i];
		}
		return summ;
	}

	public int[] multiptyBy3() {
		for (int i = 0; i < array.length; i++) {
			array[i] *= 3;
		}
		return array;
	}

}
