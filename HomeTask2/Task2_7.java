import java.util.Scanner;

public class Task2_7 {
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
		
		System.out.println("\nРезультирующий массив: ");
		
		for (int i=1; i< ar.length-i; i++) {
			int a = ar [i-1];
			ar[i-1]= ar[ar.length - i];
			ar [ar.length - i] = a;
			}
		for (int i=0; i< ar.length; i++) {
		System.out.print(ar[i] + " ");
		}
		}
}
