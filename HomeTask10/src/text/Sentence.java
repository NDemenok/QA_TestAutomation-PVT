package text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence implements TextEditor
{
	private List<Word> words;
	private final String wordDelimeter = " ";

	Sentence(String sentence)
	{
		words = new ArrayList<>();
		String[] wordsArray = sentence.split(wordDelimeter);
		for (String word : wordsArray)
		{
			words.add(new Word(word));
		}
	}

	public void replaceSymbol(int n, char replacement)
	{
		for (Word singleWord : words)
		{
			singleWord.replaceSymbol(n, replacement);
		}
	}

	public String getRepresentation()
	{
		return String.join(wordDelimeter, words.stream().map(Word::getRepresentation)
				.collect(Collectors.joining(wordDelimeter)));
	}

}
