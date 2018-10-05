package homeTaskMetod;

public class DopHomeTaskMetod {

	public static void main(String[] args) {
		
		int [] m = {2,4,6,8,1,3,5,7,9};
		
		printMassForwardRevers(m);
		myltyhlyElements(m);
		eachThreemyltyplyTwo(m);
		quantityZeroElements(m);
		numbersZeroElements(m);
		changeEachTwoElements(m);
		changeFirstLastElements(m);
		printMaxMinElements(m);
		numberMaxMinElements(m);
		ascendingSequenceMassive(m);
		changeElementsHalfSummNeighbors(m);
		ciclicMoveElementsRightTwoPosition(m);
	}
	public static void printMassForwardRevers (int [] aa) {
		for( int i=0; i<aa.length; i++)
		{ 
			aa[i] = i; 
			System.out.print(aa[i]);
		}
		
		for( int i=aa.length-1; i>=0; i--)
		{ 
			aa[i] = i; 
			System.out.print(aa[i]);
		}
	}
	public static void myltyhlyElements (int [] aa) {
		int result = 1;
		for( int i=0; i<aa.length; i++) {
			result *= aa[i];
		}
		System.out.println("\nПроизведение элементов " + result);
	}
	public static void eachThreemyltyplyTwo (int [] aa) {
		for( int i=0; i<aa.length; i++) {
			if ((i+1)%3==0) {
				aa[i]*=2;
			}
			System.out.print(aa[i] + " ");
		}
	}
	public static void quantityZeroElements (int [] aa) {
		System.out.println("\nКоличество нулевых элементов массива: ");
		int count = 0;
		for (int i = 0; i < aa.length; i++) {
			if (aa[i] == 0) {
				count++;
		}
		}
		if (count > 0) {
			System.out.print(count);
		} else {
			System.out.print("нет");
		}
	}
	public static void numbersZeroElements (int [] aa) {
		System.out.println("\nНомера нулевых элементов массива: ");
		int number = 0;
		for (int i = 0; i < aa.length; i++) {
			if (aa[i] == 0) {
				number++;
				System.out.print(i + " ");
			}
		}
		if (number < 1) {
			System.out.print("нет");
		}
	}
	public static void changeEachTwoElements (int [] aa) {
System.out.println("\nРезультирующий массив: ");
		
		for (int i=0; i< aa.length-1; i+=2) {
			int a = aa [i];
			aa [i] = aa [i+1];
			aa [i+1] = a;
			
		}
		for (int i=0; i< aa.length; i++) {
		System.out.print(aa[i] + " ");
		}
	}
	public static void changeFirstLastElements (int [] aa) {
System.out.println("\nРезультирующий массив: ");
		
		for (int i=1; i< aa.length-i; i++) {
			int a = aa [i-1];
			aa[i-1]= aa[aa.length - i];
			aa [aa.length - i] = a;
			}
		for (int i=0; i< aa.length; i++) {
		System.out.print(aa[i] + " ");
		}
	}
	public static void printMaxMinElements (int [] aa) {
		int max = aa[0];

		for (int i = 0; i < aa.length; i++) {
			if (max < aa[i])
				max = aa[i];
		}

		System.out.println("\nMAX =" + max);

		int min = aa[0];

		for (int i = 0; i < aa.length; i++) {
			if (min > aa[i])
				min = aa[i];
		}
		System.out.println("MIN =" + min);
	}
	public static void numberMaxMinElements (int [] aa) {
		int maxIndex = 0;

		for (int i = 0; i < aa.length; i++) {
			if (aa[maxIndex] < aa[i])
				maxIndex = i;
		}

		System.out.println("\nИндекс максимального элемента =" + maxIndex);

		int minIndex = 0;

		for (int i = 0; i < aa.length; i++) {
			if (aa[minIndex] > aa[i])
				minIndex = i;
		}
		System.out.println("Индекс минимального элемента =" + minIndex);
	}
	public static void ascendingSequenceMassive (int [] aa) {
		boolean yes = true;
		for (int i = 1; i < aa.length; i++) {
			if (aa[i] <= aa[i - 1]) {
				yes = false;
				break;
			}
		}
		if (yes) {
			System.out.println("\nМассив является возрастающей последовательностью");
		} else {
			System.out.println("\nМассив не является возрастающей последовательностью");
		}
	}
	public static void changeElementsHalfSummNeighbors (int [] aa) {
		int [] aa1= {0,0,0,0,0,0,0,0,0};
		System.out.println("\nРезультирующий массив: ");

		for (int i = 0; i < aa.length; i++) {

			if (i == 0 || i == aa.length - 1) {
				aa1[i] = aa[i];
			} else {
				aa1[i] = (aa[i - 1] + aa[i + 1]) / 2;
			}
		}

		for (int i = 0; i < aa.length; i++) {
			System.out.print(aa1[i] + " ");
		}
	}
	public static void ciclicMoveElementsRightTwoPosition (int [] aa) {
		int [] aa1= {0,0,0,0,0,0,0,0,0};
		System.out.println("\nРезультирующий массив: ");
		for (int i = 0; i < aa.length; i++) {
			aa1[(i + 2) % aa.length] = aa[i];
		}
		for (int i = 0; i < aa1.length; i++) {
			System.out.print(aa1[i] + " ");
		}
	}
}

