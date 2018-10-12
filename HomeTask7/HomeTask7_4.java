import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HomeTask7_4 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		if (scan.hasNextLine()) {
			System.out.print("Enter strings: ");
			String text = scan.nextLine();
			String[] words = text.split(" ");
			scan.close();

			String minWordChar = words[0];
			int minSizeChar = new HashSet<String>(Arrays.asList(words[0].split(""))).size();

			for (String word : words) {
				Set<String> set = new HashSet<String>(Arrays.asList(word.split("")));
				if (set.size() < minSizeChar) {
					minWordChar = word;
					minSizeChar = set.size();
				}
			}
			System.out.println("Word with minimal amount different symbols " + minWordChar);
		}

	}

}
