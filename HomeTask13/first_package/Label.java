package first_package;

public class Label extends PageElement implements Comparable<Label>{

	private String name;
	
	
	public Label(String name) 
	{
		this.name = name;
	}
	
	public String toString()
	{
		return String.format("Label '%s'", name);
	}

	@Override
	public int compareTo(Label obj) {
		return this.name.compareTo(obj.name);
	}
	
	
}
