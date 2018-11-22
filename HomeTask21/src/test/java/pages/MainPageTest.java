package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MainPageTest {

	public WebDriver driver;
	public Select select;
	private MainPage mainPage;
	private static final String URL = "https://Booking.com";
	private String city = "Москва";

	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		mainPage = new MainPage(driver, select);
	}

	@Test
	public void availabilityHotelsOnSelectedDates() {
		mainPage.inputCity(city);
		mainPage.setDate();
		mainPage.getInformationAboutGuests("1", "2", "0");
		mainPage.pushSearchButton();
		Assert.assertTrue("There are not hotels on selected dates", mainPage.listNotEmpty());
	}

	@Test
	public void checkHotelRaiting() {
		mainPage.getFilter();
		mainPage.chooseFirstHotel();
		String numberOfRaiting = mainPage.chooseFirstHotel();
		Double rating = Double.parseDouble(numberOfRaiting);
		Assert.assertTrue("Rating less than 9", rating >= 9);
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}
