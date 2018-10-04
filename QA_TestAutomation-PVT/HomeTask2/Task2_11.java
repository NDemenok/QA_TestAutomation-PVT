import java.util.Scanner;

public class Task2_11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Введите размер массива: ");
		int size = in.nextInt();
		in.close();

		int[] ar = new int[size];
		int[] ar1 = new int[size];

		System.out.println("Исходный массив: ");
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) Math.round(Math.random() * 100);
			System.out.print(ar[i] + " ");
		}

		System.out.println("\nРезультирующий массив: ");

		for (int i = 0; i < ar.length; i++) {

			if (i == 0 || i == ar.length - 1) {
				ar1[i] = ar[i];
			} else {
				ar1[i] = (ar[i - 1] + ar[i + 1]) / 2;
			}
		}

		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar1[i] + " ");
		}
	}

}
