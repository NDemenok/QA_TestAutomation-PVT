import java.util.Scanner;

public class HomeTask7_5 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		if (scan.hasNextLine()) {
			String text = scan.nextLine();
			scan.close();

			int numberWordWithEqualLetters = 0;
			for (String myString : text.split(" ")) {
				int countLatinLetters = 0;
				int balanceLetters = 0;
				for (char letter : myString.toCharArray()) {
					if (((letter >= 'A' || letter <= 'Z')) || ((letter >= 'a' || letter <= 'z'))) {
						countLatinLetters++;
						if ((letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U'
								|| letter == 'Y' || letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o'
								|| letter == 'u' || letter == 'y')) {
							balanceLetters++;
						} else {
							balanceLetters--;
						}
					}
					if (countLatinLetters == myString.length()) {
						if (balanceLetters == 0) {
							numberWordWithEqualLetters++;
						}
					}

				}

			}
			System.out.println("The number of words with an equal " + "number of vowels and consonants: "
					+ numberWordWithEqualLetters);
		}
	}
}
