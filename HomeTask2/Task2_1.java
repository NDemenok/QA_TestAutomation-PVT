import java.util.Scanner;
public class Task2_1 {

	public static void main(String[] args) {
						
		Scanner in =new Scanner (System.in);
		System.out.print("¬ведите размер массива: ");
		int size = in.nextInt();
		in.close();
		
		int [] ar  = new int [size];
					
		for( int i=0; i<ar.length; i++)
		{ 
			ar[i] = i; 
			System.out.print(ar[i]);
		}
		
		for( int i=ar.length-1; i>=0; i--)
		{ 
			ar[i] = i; 
			System.out.print(ar[i]);
		}
	}
}




		/*
double[] ar = new double[size];
		int i;
		
		for(i=0; i<ar.length; i++)
		{ 
			ar[i] = Math.random(); 
		}
		
		for(i=4; i>=0; i--)
		{ 
			ar[i] = Math.random(); 
		}
		
	for(double x : ar) System.out.print(x + " ");
	for(double y : ar) System.out.println(y + " ");*/


