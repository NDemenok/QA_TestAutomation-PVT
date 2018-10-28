package first_package;

import java.util.Arrays;
import java.util.List;

public class Dropdown extends PageElement{

	List<String> options;
	boolean isSelected;
	String name;
	
	
	public Dropdown(boolean isSelected, String name, String... options) 
	{
		this.options = Arrays.asList(options);
		this.isSelected = isSelected;
		this.name = name;
	}
	
	public String toString()
	{
		return String.format("Dropdown options '%s' (name '%s')", options, name);
	}
}
