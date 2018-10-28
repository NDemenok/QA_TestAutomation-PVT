package first_package;

public class Main {

	public static void main (String [] args) {
		
	Button button =new Button("Enter", "Enter your name");
	Button button1 = new Button("Registration", "Enter email");
	Button button2 = new Button("Create new account", "Enter password");
	Button button3 = new Button("Aaaaaaa", "Ennn");
	
	Field field = new Field(1546852, 1);
	Field field1 = new Field(1421355, 2);
	Field field2 = new Field(1648523, 3);
	
	Label label = new Label("Facebook");
	Label label1 = new Label("BlaBlaBla");
	Label label2 = new Label("Twitter");
	Label label3 = new Label("VK");
		
	Dropdown dropdown = new Dropdown(true, "Name", "email", "MMM", "KKKKK");
	Dropdown dropdown1 = new Dropdown(true, "Name1", "email1", "MMM1", "KKKKK1");
	Dropdown dropdown2 = new Dropdown(true, "Name2", "email2", "MMM2", "KKKKK2");
	
	Page page = new Page(1251253, "Mary Smit");
	page.addElements(button, button1, button2, button3, field, field1, field2, label, label1, 
			label2, dropdown, dropdown1, dropdown2);

	page.removeElement(button1);
	page.removeElement(field1);
	page.removeElement(label1);
	page.removeElement(dropdown1);
	
	page.changeElement(1, new Button("Registration", "Enter email"));
	page.changeElement(1, new Field(1421355, 2));
	page.changeElement(label1, label2);
	page.changeElement(dropdown, dropdown1);
	
	page.bubleSort();//Method BobleSort for extraHomeTask
	page.printAllButtons();
	page.printAllFields();
	page.printAllLabels();
	page.printAllDropdowns();
	
	//Implement TreeSet for extraHomeTask
	page.addElementToTreeSet(label);
	page.addElementToTreeSet(label1);
	page.addElementToTreeSet(label2);
	page.addElementToTreeSet(label3);
	page.removeElementFromTreeSet(label1);
	page.changeElementOnTreeSet(label1, label2);
	page.printAllAdditionalLabels();
		
	}
}
