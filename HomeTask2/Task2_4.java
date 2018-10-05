import java.util.Scanner;

public class Task2_4 {
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

		System.out.println("\nКоличество нулевых элементов массива: ");
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == 0) {
				count++;
		}
		}
		if (count > 0) {
			System.out.print(count);
		} else {
			System.out.print("нет");
		}

	}
}
