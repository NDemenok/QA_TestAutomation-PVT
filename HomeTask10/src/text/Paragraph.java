package text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Paragraph implements TextEditor {

	private List<Sentence> sentences;
	private final String sentenceDelimeter = "\\. ";
	private final String sentenceJoiner = ". ";

	public Paragraph(String lines)
	{
		sentences = new ArrayList<>();
		String[] sentenceArray = (lines.split(sentenceDelimeter));
		for (String sentence : sentenceArray)
		{
			sentences.add(new Sentence(sentence));
		}
	}

	public void replaceSymbol(int n, char replacement)
	{
		for (Sentence singleSentence : sentences)
		{
			singleSentence.replaceSymbol(n, replacement);
		}
	}

	public String getRepresentation()
	{
		return String.join(sentenceJoiner, sentences.stream().map(Sentence::getRepresentation)
				.collect(Collectors.joining(sentenceJoiner)));
	}
}
