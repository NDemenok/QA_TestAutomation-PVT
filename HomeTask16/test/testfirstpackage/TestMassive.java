package testfirstpackage;

import org.testng.annotations.Test;

import firstpackage.Massive;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestMassive {

	@Test(enabled = false)
	public void f() {
		System.out.println("Test method");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}

	@Test(enabled = false)
	public void testArrayIsNull() {
		Massive massive = new Massive();
		Assert.assertNull(massive, "Massive is not null");
	}

	@Test
	public void testArrayIsNotNull() {
		Massive massive = new Massive();
		Assert.assertNotNull(massive, "Massive is null");
	}

	@Test(enabled = false)
	public void testArraySame() {
		Massive massive = new Massive();
		Massive massive1 = new Massive();
		Assert.assertSame(massive, massive1, "Arrays is not same");
	}

	@Test
	public void testArrayNotSame() {
		Massive massive = new Massive();
		Massive massive1 = new Massive();
		Assert.assertNotSame(massive1, massive, "Arrays is same");
	}

	@Test
	public void testBubleSortArrayEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 0, 2, 3, 7, 9 };
		int[] actual_result = massive.bubleSortArray(array);
		Assert.assertEquals(actual_result, expected_result, "Sort of array is not correct");
	}

	@Test
	public void testBubleSortArrayNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 2, 0, 3, 9, 7 };
		int[] actual_result = massive.bubleSortArray(array);
		Assert.assertNotEquals(actual_result, expected_result, "Sort of array is not correct");
	}

	@Test
	public void testEverySecondElementMultipliedByTwoEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 14, 0, 6, 9, 4 };
		int[] actual_result = massive.everySecondElementMultipliedByTwo(array);
		Assert.assertEquals(actual_result, expected_result, "Sort of array is not correct");
	}

	@Test
	public void testEverySecondElementMultipliedByTwoNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 14, 5, 6, 3, 4 };
		int[] actual_result = massive.everySecondElementMultipliedByTwo(array);
		Assert.assertNotEquals(actual_result, expected_result, "Sort of array is not correct");
	}

	@Test
	public void testFindMaxElementEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int expected_result = 9;
		int actual_result = massive.findMaxElement(array);
		Assert.assertEquals(actual_result, expected_result, "Max value is not correct");
	}

	@Test
	public void testFindMaxElementNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int expected_result = 7;
		int actual_result = massive.findMaxElement(array);
		Assert.assertNotEquals(actual_result, expected_result, "Max value is not correct");
	}

	@Test
	public void testFindMinElementEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int expected_result = 0;
		int actual_result = massive.findMinElement(array);
		Assert.assertEquals(actual_result, expected_result, "Min value is not correct");
	}

	@Test
	public void testFindMinElementNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int expected_result = 2;
		int actual_result = massive.findMinElement(array);
		Assert.assertNotEquals(actual_result, expected_result, "Min value is not correct");
	}

	@Test
	public void testFindSumOfElements() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int expected_result = 21;
		int actual_result = massive.findSumOfElements(array);
		Assert.assertEquals(actual_result, expected_result, "Sum value is not correct");
	}

	@Test
	public void testFindMultiplyOfElementsEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int expected_result = 0;
		int actual_result = massive.findMultiplyOfElements(array);
		Assert.assertEquals(actual_result, expected_result, "Multiply value is not correct");
	}

	@Test
	public void testFindMultiplyOfElementsNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int expected_result = 100;
		int actual_result = massive.findMultiplyOfElements(array);
		Assert.assertNotEquals(actual_result, expected_result, "Multiply value is not correct");
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void testEachElementDivisionByNextEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 0, 0, 0, 0, 0 };
		int[] actual_result = massive.eachElementDivisionByNext(array);
		Assert.assertEquals(actual_result, expected_result, "Division value is not correct");
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void testEachElementDivisionByNextNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 7, 0, 9, 3, 2 };
		int[] actual_result = massive.eachElementDivisionByNext(array);
		Assert.assertNotEquals(actual_result, expected_result, "Division value is not correct");
	}

	@Test
	public void testEachElementDivisionByNextThrows() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		Assert.assertThrows(ArithmeticException.class, () -> massive.eachElementDivisionByNext(array));
	}

	@Test
	public void testReverseArrayEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 2, 9, 3, 0, 7 };
		int[] actual_result = massive.reverseArray(array);
		Assert.assertEquals(actual_result, expected_result, "Reverse is not correct");
	}

	@Test
	public void testReverseArrayNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 3, 9, 2, 0, 7 };
		int[] actual_result = massive.reverseArray(array);
		Assert.assertNotEquals(actual_result, expected_result, "Reverse is not correct");
	}

	@Test
	public void testeachElementMultiplyByYourselfEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 49, 0, 9, 81, 4 };
		int[] actual_result = massive.eachElementMultiplyByYourself(array);
		Assert.assertEquals(actual_result, expected_result, "Multiply by yourself is not correct");
	}

	@Test
	public void testeachElementMultiplyByYourselfNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		int[] expected_result = { 0, 0, 0, 81, 4 };
		int[] actual_result = massive.eachElementMultiplyByYourself(array);
		Assert.assertNotEquals(actual_result, expected_result, "Multiply by yourself is not correct");
	}

	@Test
	public void testIsTheArrayAnIncreasingSequenceEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		boolean expected_result = false;
		boolean actuai_result = massive.isTheArrayAnIncreasingSequence(array);
		Assert.assertEquals(actuai_result, expected_result, "Array is increasing sequence");
	}

	@Test
	public void testIsTheArrayAnIncreasingSequenceNotEquals() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		boolean expected_result = true;
		boolean actuai_result = massive.isTheArrayAnIncreasingSequence(array);
		Assert.assertNotEquals(actuai_result, expected_result, "Array is increasing sequence");
	}

	@Test
	public void testIsTheArrayAnIncreasingSequenceFalse() {
		Massive massive = new Massive();
		int[] array = { 7, 0, 3, 9, 2 };
		boolean actuai_result = massive.isTheArrayAnIncreasingSequence(array);
		Assert.assertFalse(actuai_result, "Array is increasing sequence");
	}

	@Test
	public void testIsTheArrayAnIncreasingSequenceTrue() {
		Massive massive = new Massive();
		int[] array = { 0, 2, 3, 7, 9 };
		boolean actuai_result = massive.isTheArrayAnIncreasingSequence(array);
		Assert.assertTrue(actuai_result, "Array is not increasing sequence");
	}
}
