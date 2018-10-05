import java.util.Scanner;

public class Task2_12 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Введите размер массива: ");
		int size = in.nextInt();
		
				
		int[] ar = new int[size];
		int[] ar1 = new int[size];

		System.out.println("Заполните массив: ");
		for (int i = 0; i < ar.length; i++) {
			ar[i] = in.nextInt();
		}
		in.close();
		System.out.println("\nРезультирующий массив: ");
		for (int i = 0; i < ar.length; i++) {
			ar1[(i + 2) % ar.length] = ar[i];
		}
		for (int i = 0; i < ar1.length; i++) {
			System.out.print(ar1[i] + " ");
		}
	}
}
