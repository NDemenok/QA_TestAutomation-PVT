package firstpackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Massive {
			
	int[] array;
	int size = getSize();
	
	public Massive() {
		this.array =  new int[size];
	};
	
	public int getSize() {
		Scanner scanner = new Scanner(System.in);
		try 
		{
			System.out.println("Enter size of massive: ");
			size = scanner.nextInt();
			System.out.println("You entered " + size);
		return size;
		} catch (InputMismatchException e) 
		{
			System.out.println("Thats not an integer. Try again: ");
		}
//		finally
//		{
//			scanner.close();
//		}
		return getSize();
	}

	public void fillArray() 
	{
		for (int i = 0; i < size; i++) 
		{	
			array[i] = (int) Math.round(Math.random()*10);
			System.out.print(array[i] + " ");
		}
	}
	
	public void changeSomeElementsOfArray() {
		int a;
			try 
			{
			a = 0;
			array[3] = array[1]/a;
			array[size] = a;
			}
			catch (ArithmeticException e1)
			{
			System.out.println("\nDivision by zero!");
			}
			catch (ArrayIndexOutOfBoundsException e2)
			{
			System.out.println("You went beyond the array!");
			}
		}
	
	
	public void changeSomeElementsOfArray(int a) {
		try 
		{
		array[3] = array[1]/a;
		array[size] = a;
		}
		catch (ArithmeticException | ArrayIndexOutOfBoundsException e3)
		{
		System.out.println("Check entered data!");
		}
	}
	
	public void addElement()
	{
		Scanner scan = new Scanner(System.in);
		try
		{
		System.out.println("Enter integer value: ");
		array[0] = scan.nextInt();
		}
		catch (InputMismatchException e4)
		{
		System.out.println("Thats not an integer.");
		}
		finally
		{
		scan.close();
		}
	}
}
