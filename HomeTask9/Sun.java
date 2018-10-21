
public class Sun extends Star {

	int volume;
	String chemicalComposition;

	protected Sun(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getChemicalComposition() {
		return chemicalComposition;
	}

	public void setChemicalComposition(String chemicalComposition) {
		this.chemicalComposition = chemicalComposition;
	}

	@Override
	public void printName() {
		System.out.println("I am Sun");
	}

	public boolean areYouTheCenterOfUniverse() {
		boolean theCenterOfUniverse = true;
		return true;
	}

	public void printAllInfoAboutSun() {
		System.out.println("I am " + this.type + ", my volume is  " + getVolume()
				+ " thousand volumes of Earth and i composed of " + getChemicalComposition()
				+ ", if you ask me:\n\"Are you the center of universe?\" - i will answer...its "
				+ areYouTheCenterOfUniverse());
	}

	public int hashCode() {
		return age;
	}

	public String toString() {
		return name;
	}
}
