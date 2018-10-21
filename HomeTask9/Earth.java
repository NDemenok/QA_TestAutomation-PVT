
public class Earth extends Planet {

	int weight;
	int diametr;

	public Earth(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Earth(String name, int age, String colour) {
		this(name, age);
		this.colour = colour;
	}

	public Earth(String name, int age, String colour, int weight, int diametr) {
		this(name, age, colour);
		this.weight = weight;
		this.diametr = diametr;
	}

	public int getRadiusOfEarth() {
		int radiusOfEarth = diametr / 2;
		return radiusOfEarth;
	}

	public void printName() {
		System.out.println("I am Earth");
	}

	public void printAllInfoAboutEarth() {
		System.out.println("I am " + colour + " " + this.type + ", my name is  " + this.name + " and i am " + age
				+ " millions years old, my weight is " + weight + "\ntonn, my radius is " + getRadiusOfEarth()
				+ " thousand kilometers and my " + "distance to sun is " + getDistanceToSun()
				+ " millions kilometers.");
	}

	public int hashCode() {
		return age;
	}

	public String toString() {
		return name;
	}
}
