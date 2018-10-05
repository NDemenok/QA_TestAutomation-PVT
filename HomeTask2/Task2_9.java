import java.util.Scanner;

public class Task2_9 {

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

		int maxIndex = 0;

		for (int i = 0; i < ar.length; i++) {
			if (ar[maxIndex] < ar[i])
				maxIndex = i;
		}

		System.out.println("\nИндекс максимального элемента =" + maxIndex);

		int minIndex = 0;

		for (int i = 0; i < ar.length; i++) {
			if (ar[minIndex] > ar[i])
				minIndex = i;
		}
		System.out.println("Индекс минимального элемента =" + minIndex);

	}

}
