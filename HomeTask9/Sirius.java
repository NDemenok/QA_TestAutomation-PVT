
public class Sirius extends Star {

	int size;
	boolean areYouGiant;

	protected Sirius(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	protected Sirius(int size, boolean areYouGiant) {
		this.size = size;
		this.areYouGiant = areYouGiant;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isAreYouGiant() {
		return areYouGiant;
	}

	public void setAreYouGiant(boolean areYouGiant) {
		this.areYouGiant = areYouGiant;
	}

	public boolean areYouGiant() {
		if (areYouGiant) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void printName() {
		System.out.println("I am Sirius");
	}

	public void printAllInfoAboutSirius() {
		System.out.println("I am " + this.type + ", my size is  " + size
				+ " millions kilometres and, if you ask me:\n\"Are you a Giant?\" - i will answer...its "
				+ areYouGiant() + " but, i am the brightest star in the world");
	}

	public int hashCode() {
		return age;
	}

	public String toString() {
		return name;
	}
}
