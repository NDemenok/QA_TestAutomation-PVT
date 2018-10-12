import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class HomeTask7_7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter strings: ");
		String text = scan.nextLine();
		String[] words = text.split(" ");
		scan.close();

		for (String word : words) {
			int numberOfDifSymbols = new HashSet<String>(Arrays.asList(word.split(""))).size();
			if (numberOfDifSymbols == word.length()) {
				System.out.println(word);
				break;
			}
		}
	}

}
