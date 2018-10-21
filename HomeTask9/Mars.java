
public class Mars extends Planet {

	int radius;
	boolean isThereLife;

	public void setThereLife(boolean isThereLife) {
		this.isThereLife = isThereLife;
	}

	protected Mars(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	protected Mars(String name, int age, String colour, int radius) {
		this(name, age);
		this.colour = colour;
		this.radius = radius;
	}

	public boolean getAnswerOnTheQuestion() {
		if (isThereLife) {
			return true;
		} else {
			return false;
		}
	}

	public void printName() {
		System.out.println("I am Mars");
	}

	public void printAllInfoAboutMars() {
		System.out.println("I am " + colour + " " + this.type + ", my name is  " + this.name + " and i am " + age
				+ " millions years old, my radius is " + radius + " \nkilometers and answer to the question"
				+ " \"Is there life on Mars?\" - is " + getAnswerOnTheQuestion() + ", distance to sun is "
				+ getDistanceToSun() + " millions kilometers.");
	}

	public int hashCode() {
		return age;
	}

	public String toString() {
		return name;
	}
}