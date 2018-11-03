package firstpackage;

public class Massive {

	int[] array = { 5, 2, 1, 0, 6, 8, 9, 7, 3, 4 };

	public int[] bubleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				int x;
				if (a[j - 1] > a[j]) {
					x = a[j - 1];
					a[j - 1] = a[j];
					a[j] = x;
				}
			}

		}
		return a;
	}

	public int[] everySecondElementMultipliedByTwo(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if ((i % 2) == 0) {
				a[i] *= 2;
			}
		}
		return a;
	}

	public int findMaxElement(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	public int findSumOfElements(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public int[] eachElementDivisionByNext(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] /= a[i + 1];
		}
		return a;
	}
}
