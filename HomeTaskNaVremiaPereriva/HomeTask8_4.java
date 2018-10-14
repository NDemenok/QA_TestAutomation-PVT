import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HomeTask8_4 {

	public static void main(String[] args) {

		// Task 4
		StringBuilder line = new StringBuilder("Cat is one of my family members");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new string: ");
		String text = scan.nextLine();
		scan.close();
		int k = 4; // переменна€ к-любое целое число;
		System.out.println(line.insert(k, text));

		// Task 5
		String example = "Try do it";
		String[] words = example.split(" ");
		for (String word : words) {
			if (word.endsWith("y")) {
				System.out.println(word.concat("XXX"));
			}
		}

		// Task 6
		System.out.println(task3(true, "Try do it"));
		System.out.println(task3(false, "Try do it"));

		// Task7
		String str1 = "gf;123lglk 12345 lkn\\\b nfln n;'<>fbkln///?";
		System.out.print(str1.replaceAll("[^а-€ј-яa-zA-Z\\s]", ""));

		// Task8
		String str2 = "gfhgkn /// *(hjgjj1111khglf)* ";
		Scanner scan1 = new Scanner(System.in);
		String text1 = scan1.nextLine();
		String text2 = scan1.nextLine();
		scan1.close();

		System.out.println(str2.substring(0, str2.indexOf(text1))
				+ str2.substring(str2.lastIndexOf(text2) + 1, str2.length() - 1));

		// Task9
		String str3 = "At the first, at the second, at the next....";
		Map<String, Long> result = Arrays
				.stream(str3.toLowerCase().split("[^а-€ј-€a-zA-Z]+-[^а-€ј-яa-zA-Z]+|[^а-€ј-яa-zA-Z\\-]+"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		result.remove("");

		result.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
				.forEach((entry) -> System.out.println(entry.getKey() + "[" + entry.getValue() + "]  "));

		// Task17
		String str4 = "fhhgdf 123 njbfb 1234556 /x.k .,;;;;;";

		String counter = "";
		int result1 = 0;
		for (int i = 0; i < str4.length(); i++) {
			char c = str4.charAt(i);
			if (Character.isAlphabetic(c)) {
				if (i - result1 > counter.length()) {
					counter = str4.substring(result1, i);
				}
				result1 = i + 1;
			}
		}
		System.out.println(counter);

		// Task20
		String str5 = "fhhgdf 123 njbfb 1234556 /x.k .,;;;;;";

		Pattern p1 = Pattern.compile("[\\.,?!:;]");
		Matcher m1 = p1.matcher(str5);

		int counter1 = 0;
		while (m1.find()) {
			counter1++;
		}
		System.out.println("Number of punctuation marks: " + counter);

		// Task21
		String str6 = "2djvnldfbbkjk 2jkkjbblnlnl 4jvjvb 6";

		int sum = 0;
		for (int i = 0; i < str6.length(); i++) {
			char ch = str6.charAt(i);
			if (Character.isDigit(ch)) {
				sum += ch;
			}
		}
		System.out.println(sum);

		// Task22
		String str7 = "";
		try {
			Scanner scan3 = new Scanner(new File("Example.txt"));
			while (scan3.hasNextLine()) {
				str7 += scan3.nextLine();
			}
			scan3.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		str7 = str7.replaceAll("\\/\\*([\\S\\s]+?)\\*\\/|[\\/\\/].+", "");
		System.out.println(str7);

	}

	public static String task3(boolean a, String b) {
		int k = 0;
		if (a) {
			StringBuilder strb = new StringBuilder("dqqqqqq 1111 njbhv");
			strb.insert(k, "WWW");
			return strb.toString();
		} else {
			return b.replaceAll("[tT]", "");
		}
	}

}
