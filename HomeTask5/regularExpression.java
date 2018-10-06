package tester;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularExpression {

	public static void main(String[] args) {
		System.out.println("Check string that there no more than 4 latin letters:");
		
		System.out.println(testTask1("12ruta$"));
		System.out.println(testTask1("ruta"));
		System.out.println(testTask1("@rut5"));
		System.out.println(testTask1("Rut"));
		System.out.println(testTask1("Rutaco"));
		
		System.out.println("Check string that there only 4 symbols:");
		
		System.out.println(testTask2("1@3f"));
		System.out.println(testTask2("1av2555"));
		System.out.println(testTask2("Hugo"));
		System.out.println(testTask2("Sun"));
		System.out.println(testTask2("Imagine Dragons"));
		

	}
public static boolean testTask1(String testString) {
	Pattern p = Pattern.compile("^.*?([a-zA-Z]{0,4})$");
	Matcher m = p.matcher(testString);
	return m.matches();
}
public static boolean testTask2(String testString) {
	Pattern p = Pattern.compile(".{4}");
	Matcher m = p.matcher(testString);
	return m.matches();
}
}
