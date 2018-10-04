import java.util.Scanner;

public class Task2_2 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Введите размер массива: ");
		int size = in.nextInt();
		in.close();

		int[] ar = new int[size];
		int proizv = 1;

		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) Math.floor(Math.random() * 100);
		}

		for (int i : ar)
			System.out.print(i + " ");

		int i = 0;
		while (i < ar.length) {
			proizv *= ar[i];
			i++;
		}

		System.out.println("\nПроизведение элементов " + proizv);

	}

}
