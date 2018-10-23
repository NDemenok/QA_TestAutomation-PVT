package text;

public class Word implements TextEditor
{
	private String word;

	Word(String word)
	{
		this.word = word;
	}

	public void replaceSymbol(int n, char replacement)
	{
		// заменяем только в том случае, если n-ый символ действительно есть в слове
		if (word.length() >= n)
		{
			StringBuilder currentWord = new StringBuilder(word);
			currentWord.setCharAt(n - 1, replacement);
			word = currentWord.toString();
		}
	}

	public String getRepresentation()
	{
		return word;
	}
}
