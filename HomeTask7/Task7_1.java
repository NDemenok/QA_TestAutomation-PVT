package task1;

import java.util.Scanner;

public class Task7_1 {

	public static void main(String[] args) {

		Scanner in1 = new Scanner(System.in);
		System.out.print("Enter quantity strings: ");
		int size = in1.nextInt();
		in1.close();

		String[] str = new String [size];
		Scanner in2 = new Scanner(System.in);

		for (int i = 0; i < str.length; i++) {
			System.out.print("Enter string ¹: " + (i+1));
			str[i] = in2.nextLine();
		}
		in2.close();

		String maxString = str[0];
		String minString = str[0];
		int maxLength = str[0].length();
		int minLength = str[0].length();
		for (int i = 0; i < str.length; i++) {
			if (maxLength < str[i].length()) {
				maxLength = str[i].length();
				maxString = str[i].toString();
			}
		}
		System.out.println("Maximum length = " + maxLength);
		System.out.println("Maximum string: " + maxString);
		for (int i = 0; i < str.length; i++) {
			if (minLength > str[i].length()) {
				minLength = str[i].length();
				minString = str[i].toString();
			}
		}
		System.out.println("Minimum length = " + minLength);
		System.out.println("Minimum string: " + minString);
	}
}
