import java.util.Scanner;

public class Task2_8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Введите размер массива: ");
		int size = in.nextInt();
		in.close();

		int[] ar = new int[size];

		System.out.println("Массив: ");
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) Math.floor(Math.random() * 100);
			System.out.print(ar[i] + " ");
		}

		int max = ar[0];

		for (int i = 0; i < ar.length; i++) {
			if (max < ar[i])
				max = ar[i];
		}

		System.out.println("\nMAX =" + max);

		int min = ar[0];

		for (int i = 0; i < ar.length; i++) {
			if (min > ar[i])
				min = ar[i];
		}
		System.out.println("MIN =" + min);
	}
}
