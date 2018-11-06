package firstpackage;

public class Massive {

	int[] array = { 7, 0, 3, 9, 2 };

	public int[] bubleSortArray(int[] a) {
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

	public int findMinElement(int[] a) {
		int min = a[0];
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		return min;
	}

	public int findSumOfElements(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public int findMultiplyOfElements(int[] a) {
		int multiply = 0;
		for (int i = 0; i < a.length; i++) {
			multiply *= a[i];
		}
		return multiply;
	}

	public int[] eachElementDivisionByNext(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] /= a[i + 1];
		}
		return a;
	}

	public int[] reverseArray(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			int tmp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = tmp;
		}
		return a;
	}

	public int[] eachElementMultiplyByYourself(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * a[i];
		}
		return a;
	}

	public boolean isTheArrayAnIncreasingSequence(int[] a) {
		boolean result = true;
		for (int i = 1; i < a.length; i++) {
			if (a[i] <= a[i - 1]) {
				result = false;
				break;
			}
		}
		return result;
	}
}
