
public class MainForStarSystem {

	public static void main(String[] args) {

		Planet planet = new Planet();
		planet.setColour("green");
		planet.setDistanceToSun(15);
		planet.printName();
		planet.printInfoAboutPlanet();
		planet.firstmethodSuperClassa();//for example
		planet.secondMethodSuperClassa();//for example
		System.out.println("Example overriding hashCode: " + planet.hashCode());
		System.out.println("Example overriding toString: " + planet.toString());

		Star star = new Star();
		star.setPlotnost(5);
		star.setTemperature(27);
		star.printName();
		star.printInfoAboutStar();
		System.out.println("Example overriding hashCode: " + star.hashCode());
		System.out.println("Example overriding toString: " + star.toString());

		Earth earth = new Earth("Earth", 4500, "blue", 5879, 12);
		earth.getRadiusOfEarth();
		earth.setDistanceToSun(150);
		earth.getDistanceToSun();
		earth.printName();
		earth.printAllInfoAboutEarth();
		System.out.println("Example overriding hashCode: " + earth.hashCode());
		System.out.println("Example overriding toString: " + earth.toString());

		Mars mars = new Mars("Mars", 4600);
		Mars mars1 = new Mars("Mars", 4600, "yellow", 3390);
		mars1.setDistanceToSun(228);
		mars1.setThereLife(false);
		mars1.printName();
		mars1.printAllInfoAboutMars();
		System.out.println("Example overriding hashCode: " + mars.hashCode());
		System.out.println("Example overriding toString: " + mars.toString());

		Sun sun = new Sun("Sun", 4600);
		sun.setVolume(1300);
		sun.setChemicalComposition("Vodorod and Heliy");
		sun.areYouTheCenterOfUniverse();
		sun.printName();
		sun.printAllInfoAboutSun();
		System.out.println("Example overriding hashCode: " + sun.hashCode());
		System.out.println("Example overriding toString: " + sun.toString());

		Sirius sirius = new Sirius("Sirius", 230);
		sirius.setSize(2);
		sirius.setAreYouGiant(false);
		sirius.printName();
		sirius.printAllInfoAboutSirius();
		sirius.firstmethodSuperClassa();//for example
		sirius.secondMethodSuperClassa();//for example
		System.out.println("Example overriding hashCode: " + sirius.hashCode());
		System.out.println("Example overriding toString: " + sirius.toString());
		
	}

}
