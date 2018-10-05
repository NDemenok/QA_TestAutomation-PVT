
public class LessonTasks {

	public static void main(String[] args) {

		int a = 7;
		int b = 8;
		dif(a, b);
		int c = 10;
		sum(a, b, c);
		int[] ar = { 2, 4, 6, 8 };
		pritntMas(ar);
		lengthMas(ar);
		double[] mas = { 1.3, 2.5, 7.0, 1.8 };
		printDouble(mas);
		System.out.println(sumMas(mas));
		float[] mas_2 = { 10.3f, 20.5f, 70.0f, 10.8f };
		printFloat(changeElement(mas_2));

	}

	// принимает 2 числа, выводит их разность
	public static void dif(int aa, int bb) {
		System.out.println(aa - bb);
	}

	// принимает 3 числа, выводит их сумму
	public static void sum(int aa, int bb, int cc) {
		System.out.println(aa + bb + cc);
	}

	// принимает, возвращает, но не выводит
	public static int getDif(int aa, int bb, int xx) {
		xx = aa - bb;
		return xx;
	}

	// принимает, возвращает, но не выводит
	public static int getDif(int aa, int bb, int zz, int xx) {
		xx = aa + bb + zz;
		return xx;
	}

	// выводит любой переданный массив
	public static void pritntMas(int[] myArray) {
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
	}

	// выводит длину переданного массива
	public static void lengthMas(int[] myArray) {
		System.out.println("\n");
		System.out.println(myArray.length);
	}

	// принимает массив типа double, а возвращает сумму его элементов
	public static double sumMas(double[] masDoub) {
		double result = 0;
		for (double i : masDoub) {
			result += i;
		}
		return result;
	}

	// принимает массив типа float, а возвращает массив, заменив каждый 3 элемент на
	// -1
	public static float[] changeElement(float[] aa) {
		for (int i = 2; i < aa.length; i = i + 2) {
			aa[i] = -1;
		}
		return aa;
	}

	// для проверки, как выводится
	public static void printDouble(double[] arr) {
		for (double d : arr) {
			System.out.println(d);
		}
	}

	// для проверки, как выводится
	public static void printFloat(float[] arr) {
		for (float d : arr) {
			System.out.println(d);
		}
	}
}
