package first_package;

public class Button extends PageElement{

	private String name;
	private String action;
	
	
	public Button (String name, String action) 
	{
		this.name = name;
		this.action = action;
	}
	
	public String toString()
	{
		return String.format("Button '%s' (action '%s')", name, action);
	}
	
	public int compareTo(Button obj) 
	{
		return this.name.compareTo(obj.name);
	}
}
