package firsttestpackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

class testDriver {
	public static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://booking.com");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testThereAreHotelsForTheDatesEntered() {
		WebElement search = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
		search.sendKeys("Москва");
		WebElement numbersOfAdultsAndRooms = driver.findElement(By.xpath("//*[@id=\"xp__guests__toggle\"]/span/span[1]"));
		numbersOfAdultsAndRooms.click();
		WebElement numbersOfRooms = driver.findElement(By.xpath("//*[@id=\"no_rooms\"]"));
		numbersOfRooms.click();
		WebElement chooseOneRoom = driver.findElement(By.xpath("//*[@id=\"no_rooms\"]/option[1]"));
		chooseOneRoom.click();
		WebElement numbersOfAdults = driver.findElement(By.xpath("//*[@id=\"group_adults\"]"));
		numbersOfAdults.click();
		WebElement chooseTwoAdults = driver.findElement(By.xpath("//*[@id=\"group_adults\"]/option[2]"));
		chooseTwoAdults.click();
		WebElement arrivalAndDeparture = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/button"));
		arrivalAndDeparture.click();
		WebElement dateOfArrival = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[5]/td[1]"));
		dateOfArrival.click();
		WebElement dateOfDeparture = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[5]/td[3]"));
		dateOfDeparture.click();
		WebElement checkPrise = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]"));
		checkPrise.click();
		Assert.assertFalse("There are no hotels for the dates entered", driver.findElements(By.xpath("//*[@id=\"right\"]/div[3]/div/div/div/h2")).isEmpty());
	}
	
	@Test
	void tesHotelRaitingOverNine() {
		WebElement filterByMaxRating = driver.findElement(By.xpath("//*[@id=\"sort_by\"]/ul/li[3]/a"));
		filterByMaxRating.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement chooseElementFirstInOrder = driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[1]/div[1]/h3/a"));
		chooseElementFirstInOrder.click();
		driver.switchTo();
		String numberOfRaiting = driver.findElement(By.xpath(".//div[@class=\"bui-review-score__badge\"]")).getText();
		Double rating = Double.parseDouble(numberOfRaiting);
		Assert.assertTrue("Rating less than 9", rating >= 9);
	}

}
