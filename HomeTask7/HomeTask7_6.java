import java.util.Scanner;

public class HomeTask7_6 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter strings: ");

		String text = scan.nextLine();
		scan.close();

		for (String word : text.split(" ")) {
			boolean result = false;
			for (int i = 1; i < word.length(); i++) {
				if (word.codePointAt(i) > word.codePointAt(i - 1)) {
					result = true;
				} else {
					result = false;
					break;
				}
			}
			if (result) {
				System.out.println("Word with symbols in strict order of increasing their codes: " + word);
				break;
			}
		}

	}

}
