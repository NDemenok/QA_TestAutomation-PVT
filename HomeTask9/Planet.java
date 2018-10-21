
public class Planet extends StarSystem {

	protected int distanceToSun;
	protected String colour;

	protected Planet() {
		this.type = "planet";
	}

	public int getDistanceToSun() {
		return distanceToSun;
	}

	public void setDistanceToSun(int distanceToSun) {
		this.distanceToSun = distanceToSun;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	@Override
	public void printName() {
		System.out.println("I am Planet");

	}

	@Override
	public void printAge() {
		System.out.println("I am many planets years old");

	}

	public void pushAnotherPlanet() {
		System.out.println("BIG BANG!!!");
	}

	public void printInfoAboutPlanet() {
		System.out.println("I have some distance to sun, like " + getDistanceToSun()
				+ " millions kilometres, and some colour, like " + getColour());
	}

	public int hashCode() {
		return age;
	}

	public String toString() {
		return name;
	}
}
