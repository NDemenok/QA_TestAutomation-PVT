import java.util.Scanner;

public class Task2_3 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Введите размер массива: ");
		int size = in.nextInt();
		in.close();
		
		int[] ar = new int[size];

		System.out.println("Исходный массив: ");
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i;
			System.out.print(ar[i] + " ");
		}

		System.out.println("\nРезультирующий массив 1: ");
		for (int i = 0; i < ar.length; i++) {
			if ((i + 1)% 3 == 0) {
				ar[i] *= 2;
			}
			System.out.print(ar[i] + " ");
		}
		System.out.println("\nРезультирующий массив 2: ");

		int k = 0;
		while (k < ar.length) {
			if ((k + 1) % 3 == 0) {
				ar[k] *= 2;
			}
			System.out.print(ar[k] + " ");
			k++;
		}
	}
	}
		
	
