import text.Paragraph;

public class Runner {

	public static void main(String[] args)
	{
		Reader reader = new Reader();
		int n = reader.getInputInt();
		Paragraph p = new Paragraph(reader.getInputText());
		p.replaceSymbol(n, '%');
		System.out.println(p.getRepresentation());
	}
}
