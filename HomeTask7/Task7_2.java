package task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task7_2 {
	public static void main(String[] args) {

		int size = 0;
		while (true) {
		Scanner in1 = new Scanner(System.in);
		System.out.print("Enter quantity strings: ");
		try {
		size = in1.nextInt();
		break;
		} catch (InputMismatchException e) {
			System.out.print("You entered not a number: ");
		}
		
		in1.close();
		}
		String[] str = new String[size];
		Scanner in2 = new Scanner(System.in);
				
		for (int i = 0; i < size; i++) {
			System.out.print("Enter strings ¹: " + (i+1));
			str[i] = in2.nextLine();
		}
		in2.close();

		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].length() < str[j].length()) {
					String temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		int maxlength = str[0].length();
		System.out.println("Strings in decreasing order of length:");
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
			for (int j = 0; j < maxlength - str[i].length(); j++)
			
			System.out.print(" ");
			System.out.println(" her length = " + str[i].length());
		}
	}
}
