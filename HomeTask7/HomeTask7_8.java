import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeTask7_8 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter strings: ");
		String text = scan.nextLine();
		scan.close();

		int countPalindromeNum = 0;
		String neededPalindrome = null;
		for (String word : text.split(" ")) {
			Pattern isItNumber = Pattern.compile("\\d+");
			Matcher mIsItNumber = isItNumber.matcher(word);
			if (mIsItNumber.find()) {
				if (word.equals(new StringBuilder(word).reverse().toString())) {
					countPalindromeNum++;
					if (countPalindromeNum == 1)
						neededPalindrome = word;
					else if (countPalindromeNum == 2)
						System.out.println(word);
				}
			}
		}
		if (countPalindromeNum == 0)
			System.out.println("Is apsent");
		if (countPalindromeNum == 1)
			System.out.println(neededPalindrome);
	}
}
