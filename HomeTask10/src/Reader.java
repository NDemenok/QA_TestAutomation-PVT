import java.util.Scanner;

public class Reader
{
	private Scanner scanner;
	private final int LIMIT = 10;

	public Reader()
	{
		scanner = new Scanner(System.in);
	}

	public String getInputText()
	{
		String result = "";
		while (scanner.hasNextLine() && !scanner.nextLine().equals("end"))
		{
			result += scanner.nextLine();
		}
		return result;
	}

	public int getInputInt()
	{
		int result = 1;
		if (scanner.hasNextInt())
		{
			result = scanner.nextInt(LIMIT);
		}
		return result;
	}
}
