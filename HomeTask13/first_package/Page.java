package first_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Page {

	ArrayList<Button> buttons;
	LinkedList<Field> fields;
	HashSet<Label> labels;
	HashMap<String,Dropdown> dropdowns;
	float id;
	String title;
	TreeSet<Label> additionalLabels;
	
	
	public Page( float id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public void addElements(PageElement... elements)
	{
		for (PageElement element: elements) 
		{
			if (element instanceof Button) 
			{
				addElement((Button)element);
			}
			if (element instanceof Field)
			{
				addElement((Field)element);
			}
			if (element instanceof Label)
			{
				addElement((Label)element);
			}
			if (element instanceof Dropdown)
			{
				addElement((Dropdown)element);
			}
		}
	}
	
	//First method
	public void addElement(Button newButton)
	{
		if(buttons == null) {
		buttons = new ArrayList<>();
		}
		buttons.add(newButton);
	}
	
	public void addElement(Field newField)
	{
		if (fields == null) {
		fields = new LinkedList<>();
		}
		fields.add(newField);
	}
	
	public void addElement(Label newLabel)
	{
		if(labels == null) {
		labels = new HashSet<>();
		}
		labels.add(newLabel);
	}
	
	public void addElement(Dropdown newDropdown)
	{		
		if(dropdowns == null) {
		dropdowns = new HashMap<>();
		}
		dropdowns.put(newDropdown.name, newDropdown);
	}
	
	
	//Second method
	public void removeElement(Button oldButton)
	{
		if(buttons != null) {
		buttons.remove(oldButton);
		}
	}
	
	public void removeElement(Field oldField)
	{
		if(fields != null) {
		fields.remove(oldField);
		}
	}
	
	public void removeElement(Label newLabel)
	{
		if(labels != null) {
		labels.remove(newLabel);
		}
	}
	
	public void removeElement(Dropdown newDropdown)
	{
		if(dropdowns != null) {
		dropdowns.remove(newDropdown.name, newDropdown);
		}
	}
	
	
	//Third method
	public void changeElement(int index, Button newButton)
	{
		buttons.set(index, newButton);
	}
	
	public void changeElement(int index, Field newField)
	{
		fields.set(index, newField);
	}
	
	public void changeElement(Label oldLabel, Label newLabel)
	{
		labels.remove(oldLabel);
		labels.add(newLabel);
	}
	
	public void changeElement(Dropdown dropdown, Dropdown newDropdown)
	{
		dropdowns.put(dropdown.name, newDropdown);
	}
	
	//Fourth method
	public void printAllButtons()
	{
		buttons.stream().forEach(System.out::println);
	}
	
	public void printAllFields()
	{
		fields.stream().forEach(System.out::println);
	}
	
	public void printAllLabels()
	{
		labels.stream().forEach(System.out::println);
	}
	
	public void printAllDropdowns()
	{
		dropdowns.keySet().stream().forEach(key -> System.out.println(dropdowns.get(key)));
	}
	
	//Method BobleSort for extraHomeTask
	public void bubleSort() 
	{
		int size = buttons.size();
		for(int i=0; i<size; i++) 
		{
			for(int j=size-1; j>i; j--) 
			{
				if (buttons.get(j-1).compareTo(buttons.get(j)) > 0) 
				{
					Button temp = buttons.get(j-1);
					changeElement(j-1, buttons.get(j));
					changeElement(j, temp);
					
				}
			}
		}
	}
	
	//Implement TreeSet for extraHomeTask
	
	public void addElementToTreeSet(Label newAdditionalLabel)
	{
		if(additionalLabels == null) {
			additionalLabels = new TreeSet<>();
			}
		additionalLabels.add(newAdditionalLabel);
	}
	
	public void removeElementFromTreeSet(Label oldAdditionalLabel) 
	{
		if(additionalLabels != null) {
			additionalLabels.remove(oldAdditionalLabel);
			}
	}
	
	public void changeElementOnTreeSet(Label oldLabel, Label newLabel) 
	{
		additionalLabels.remove(oldLabel);
		additionalLabels.add(newLabel);	
	}
	
	public void printAllAdditionalLabels()
	{
		additionalLabels.stream().forEach(System.out::println);
	}
}
