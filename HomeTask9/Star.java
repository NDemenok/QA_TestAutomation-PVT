
public class Star extends StarSystem {

	protected int plotnost;
	protected int temperature;

	protected Star() {
		this.type = "star";
	}

	public int getPlotnost() {
		return plotnost;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setPlotnost(int plotnost) {
		this.plotnost = plotnost;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public void printName() {
		System.out.println("I am Star");
	}

	@Override
	public void printAge() {
		System.out.println("I am many stars years old");
	}

	public void createGalaxy() {
		System.out.println("WE HAVE NEW GALAXY!!!");
	}

	public void printInfoAboutStar() {
		System.out.println("I have some plotnost, like " + getPlotnost()
				+ " milligram per cubic meter, and some temperature, like " + getTemperature() + " degrees Celsius");
	}

	public int hashCode() {
		return age;
	}

	public String toString() {
		return name;
	}
}
