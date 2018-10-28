package first_package;

public class Field extends PageElement{

	private int id;
	private int value;
	
	public Field(int id, int value)
	{
		this.id = id;
		this.value = value;
	}
	public String toString()
	{
		return String.format("Field '%s' (value '%s')", id, value);
	}
}
