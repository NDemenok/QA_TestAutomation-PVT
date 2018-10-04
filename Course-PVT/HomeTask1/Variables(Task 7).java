
public class Variables {

	public static void main(String[] args) {

		int a = 5;
		short ds = 5;
		long dL = 12222;
		double d = 999999.25;
		float dF = 99.25f;
		char e = 'x';
		boolean f = true;

		int result1 = a + ds;
		double result2 = dL - d;
		double result3 = dF * d;

		System.out.println(a + " " + ds + " " + dL+ " " + d + " " + dF+ " " + e+ " " + f + " " + result1 + " " + result2 + " " + result3 );

		if (dL > d) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		if (dF < a) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		if (a == ds) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

}
