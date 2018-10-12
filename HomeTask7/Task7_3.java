package task3;

import java.util.Scanner;

public class Task7_3 {
	public static void main(String[] args) {
		Scanner in1 = new Scanner(System.in);
		System.out.print("Enter quantity strings: ");
		int size = in1.nextInt();
		in1.close();

		String[] str = new String[size];
		Scanner in2 = new Scanner(System.in);

		for (int i = 0; i < size; i++) {
			System.out.print("Enter strings ¹" + (i + 1));
			str[i] = in2.nextLine();
		}
		in2.close();

		int averageLength = str[0].length();
		// count the total length of lines
		for (int i = 0; i < str.length - 1; i++) {
			averageLength += str[i + 1].length();
		}
		// count the average length of lines
		averageLength /= str.length;
		System.out.println("Tha average length of lines =" + averageLength);
		
		System.out.println("Lines whose length is less than average: ");
		for (int i = 0; i < size; i++) {
			if (str[i].length() < averageLength) {
				System.out.print(str[i]);
				System.out.println(" her length = " + str[i].length());
			}
		}
		System.out.println("Lines whose length is more than average: ");
		for (int i = 0; i < size; i++) {
			if (str[i].length() > averageLength) {
				System.out.print(str[i]);
				System.out.println(" her length = " + str[i].length());
			}
		}
	}
}
