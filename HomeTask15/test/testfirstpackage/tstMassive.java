package testfirstpackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import firstpackage.Massive;

public class tstMassive {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testMassiveIsNull() {
		Massive massive = new Massive();
		assertNull("Object massive is not null", massive);
	}
		
	@Test
	public void testMassiveIsNotNull() {
		Massive massive = new Massive();
		assertNotNull("Object massive is null", massive);
	}
		
	@Test
	public void testBubleSort() {
		Massive massive = new Massive();
		int [] array = {5,2,1,0,6,8,9,7,3,4};
		int [] actual_result = massive.bubleSort(array);
		int [] expected_result = {0,1,2,3,4,5,6,7,8,9};
		assertArrayEquals("Sort of array is not correct", 
				expected_result, actual_result);
	}
	
	@Test
	public void testEverySecondElementMultipliedByTwo() {
		Massive massive = new Massive();
		int [] array = {5,2,1,0,6,8,9,7,3,4};
		int [] actual_result = massive.everySecondElementMultipliedByTwo(array);
		int [] expected_result = {10,2,2,0,12,8,18,7,6,4};
		assertArrayEquals("Sort of array is not correct", 
				expected_result, actual_result);
	}
	
	@Test
	public void testFindMaxElementIsCorrect() {
		Massive massive = new Massive();
		int [] array = {5,2,1,0,6,8,9,7,3,4};
		int actual_result = massive.findMaxElement(array);
		int expected_result = 9;
		assertEquals("Max value is not correct", expected_result, actual_result);
	}
	
	@Test
	public void testFindMaxElementIsNotCorrect() {
		Massive massive = new Massive();
		int [] array = {5,2,1,0,6,8,9,7,3,4};
		int actual_result = massive.findMaxElement(array);
		int expected_result = 10;
		assertNotEquals("Max value is correct", expected_result, actual_result);
	}
	
	@Test
	public void testfindSumOfElementsIsCorrect() {
		Massive massive = new Massive();
		int [] array = {5,2,1,0,6,8,9,7,3,4};
		int actual_result = massive.findSumOfElements(array);
		int expected_result = 45;
		assertEquals("Sum value is not correct", expected_result, actual_result);
	}
	
	@Test
	public void testfindSumOfElementsIsNotCorrect() {
		Massive massive = new Massive();
		int [] array = {5,2,1,0,6,8,9,7,3,4};
		int actual_result = massive.findSumOfElements(array);
		int expected_result = 155;
		Assert.assertNotEquals("Sum value is correct", expected_result, actual_result);
	}
	
	@Test (expected = ArithmeticException.class)
	public void testeachElementDivisionByNext() {
		Massive massive = new Massive();
		int [] array = {5,2,1,0,6,8,9,7,3,4};
		massive.eachElementDivisionByNext(array);
	}
	
	@Test
	public void testSomeAsserts() {
		int [] array = {5,2,1,0,6,8,9,7,3,4};
		assertTrue("No", array[0] == 5);
	}
}
