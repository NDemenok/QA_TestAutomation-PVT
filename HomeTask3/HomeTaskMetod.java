package homeTaskMetod;

import java.util.Random;

public class HomeTaskMetod {

	public static void main(String[] args) {

		int a = generateNumber();
		int b = generateNumber();

		System.out.println(maxMin(a, b));
		System.out.println(chetNech(a));
		System.out.println(vCvadrat(a));
		System.out.println(vCub(a));
	}

	private static int generateNumber() {
		Random generator = new Random();
		int rnd = generator.nextInt(100);
		System.out.println(rnd);
		return rnd;
	}
	public static int maxMin(int aa, int bb) {
		if ((aa - bb) < 0) {
			return aa;
		}
		return bb;
	}

	public static boolean chetNech(int aa) {
		boolean flag = false;
		if (aa % 2 == 0) {
			flag = true;
		}
		return flag;
	}

	public static int vCvadrat(int aa) {
		return aa * aa;
	}

	public static int vCub(int aa) {
		return (aa * aa * aa);
	}
}
