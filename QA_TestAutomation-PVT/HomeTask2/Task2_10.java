import java.util.Scanner;

public class Task2_10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("������� ������ �������: ");
		int size = in.nextInt();
		in.close();

		int[] ar = new int[size];

		System.out.println("������: ");
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) Math.floor(Math.random() * 100);
			System.out.print(ar[i] + " ");
		}

		boolean yes = true;
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] <= ar[i - 1]) {
				yes = false;
				break;
			}
		}
		if (yes) {
			System.out.println("\n������ �������� ������������ �������������������");
		} else {
			System.out.println("\n������ �� �������� ������������ �������������������");
		}
	}

}
