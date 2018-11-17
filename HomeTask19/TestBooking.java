package testpackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestBooking {

	private WebDriver driver;
	private static final String URL = "https://Booking.com";

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void goToBookingCom() {
		driver.get(URL);
	}

	public void selectCity(String city) {
		WebElement inputCity = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
		inputCity.clear();
		inputCity.sendKeys(city);
	}

	public void setDate() {
		inputDate(LocalDate.now().plusDays(3), LocalDate.now().plusDays(3 + 7));
	}

	public void inputDate(LocalDate arrivalDate, LocalDate departureDate) {
		WebElement calendar = driver.findElement(By.xpath("(//button[@aria-label=\"Открыть календарь\"])[2]"));
		calendar.click();
		String inDate = arrivalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		driver.findElement(By.xpath("//td[@data-date='" + inDate + "']")).click();
		String outDate = departureDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		driver.findElement(By.xpath("//td[@data-date='" + outDate + "']")).click();
	}

	public void getInformationAboutGuests(String rooms, String adults, String children) {
		WebElement fieldPeople = driver.findElement(By.xpath("//*[@id=\"xp__guests__toggle\"]/span"));
		fieldPeople.click();
		if (driver.findElements(By.xpath("//select[@id=\"no_rooms\"]")).isEmpty()) {
			WebElement selectRooms = driver
					.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/button[2]"));
			int r = Integer.parseInt(rooms);
			for (int i = 1; i <= r; i++) {
				selectRooms.click();
			}
			WebElement selectAdults = driver
					.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[2]/div/div[2]/button[2]"));
			int a = Integer.parseInt(adults);
			for (int j = 1; j <= a; j++) {
				selectAdults.click();
			}
			WebElement selectChildren = driver
					.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[3]/div/div[2]/button[2]"));
			int c = Integer.parseInt(children);
			for (int k = 0; k <= c; k++) {
				selectChildren.click();
			}
		} else {
			Select selectRooms = new Select(driver.findElement(By.xpath("//select[@id=\"no_rooms\"]")));
			selectRooms.selectByValue(rooms);
			Select selectAdults = new Select(driver.findElement(By.xpath("//select[@id=\"group_adults\"]")));
			selectAdults.selectByValue(adults);
			Select selectChildren = new Select(driver.findElement(By.xpath("//select[@id=\"group_children\"]")));
			selectChildren.selectByValue(children);
		}
	}

	public void clickSearchButton() {
		driver.findElement(By.xpath("//button/span[text()=\"Проверить цены\"]")).click();
	}

	public void searchHotel() {
		goToBookingCom();
		selectCity("Париж");
		setDate();
		getInformationAboutGuests("1", "2", "0");
		clickSearchButton();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void filterPriceRangeAndClickLowerPriceFirstTest() {
		searchHotel();
		driver.findElement(By.xpath("//div[contains(@class,\"filter_item css-checkbox\")]/span")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"sort_by\"]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//a[@data-category=\"review_score_and_price\"]")).click();
		assertFalse(
				driver.findElements(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[1]/div[1]/h3/a/span[2]"))
						.isEmpty(),
				"There are no hotels in our price range");
	}

	@Test(priority = 1)
	public void chooseHotelWithMaxRaitingButLowPrice() {
		String budgetByNight = driver.findElement(By.xpath("//div[contains(@class,\"filter_item css-checkbox\")]/span"))
				.getText();
		Integer allowableValuePrice = Integer.parseInt(budgetByNight);
		String commonPrice = driver
				.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[2]/div/div[2]/div/text()"))
				.getText();
		Integer price = Integer.parseInt(commonPrice);
		int day = 7;
		Assert.assertTrue(price / day <= allowableValuePrice, "Price does not match");
	}

	public void searchHotelForBigCompany() {
		goToBookingCom();
		selectCity("Париж");
		setDate();
		getInformationAboutGuests("2", "4", "0");
		clickSearchButton();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void filterLowPriceFromMostExpenciveTest() {
		searchHotelForBigCompany();
		driver.findElement(By.xpath("(//div[contains(@class, \"filter_item css-checkbox\")])[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"sort_by\"]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String budgetByNight = driver
				.findElement(By.xpath("(//div[contains(@class, \"filter_item css-checkbox\")])[4]")).getText();
		Integer allowableValuePrice = Integer.parseInt(budgetByNight);
		String commonPrice = driver
				.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[2]/div/div[2]/div/strong/div/b"))
				.getText();
		Integer price = Integer.parseInt(commonPrice);
		int day = 7;
		Assert.assertTrue(price / day >= allowableValuePrice, "Price does not match");
	}

	public void bookingHotel() {
		WebElement chooseHotel = driver.findElement(By.xpath("//*[@id=\"hotel_50416\"]/a"));
		chooseHotel.click();
		driver.switchTo();
		driver.findElement(By.xpath("//*[@id=\"hp_book_now_button\"]")).click();
		Select selectNumbersOfRooms = new Select(
				driver.findElement(By.xpath("//*[@id=\"hprt-form\"]/table/tbody/tr[1]/td[5]/div/label/select")));
		selectNumbersOfRooms.selectByValue("2");
		WebElement buttonIAmBooking = driver.findElement(By.xpath("//*[@id=\"b_tt_holder_3\"]"));
		buttonIAmBooking.click();
		driver.switchTo();
	}

	public void fillReservationForm() {
		Select appeal = new Select(driver.findElement(By.xpath("//*[@id=\"booker_title\"]")));
		appeal.selectByValue("ms");
		WebElement inputFirstName = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		inputFirstName.sendKeys("Mary");
		WebElement inputLastName = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
		inputLastName.sendKeys("Smit");
		WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		inputEmail.sendKeys("xxxx@mail.ru");
		WebElement confirmEmail = driver.findElement(By.xpath("//*[@id=\"email_confirm\"]"));
		confirmEmail.sendKeys("xxxx@mail.ru");
		driver.findElement(By.xpath("//*[@id=\"notstayer_false\"]")).click();
		WebElement finalDate = driver.findElement(By.xpath("//*[@id=\"b_tt_holder_3\"]/button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", finalDate);
		finalDate.click();
		driver.switchTo();
	}

	@Test(priority = 3)
	public void fillPaymentForm() {
		bookingHotel();
		fillReservationForm();
		WebElement telephonNumber = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		telephonNumber.sendKeys("290000000");
		WebElement fieldTypeCard = driver.findElement(By.xpath("//*[@id=\"cc_type\"]"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].scrollIntoView(true);", fieldTypeCard);
		Select typeCard = new Select(driver.findElement(By.xpath("//*[@id=\"cc_type\"]")));
		typeCard.selectByValue("Visa");
		WebElement fieldNumberOfCard = driver.findElement(By.xpath("//*[@id=\"cc_number\"]"));
		fieldNumberOfCard.sendKeys("4242 4242 4242 4242");
		Select month = new Select(driver.findElement(By.xpath("//*[@id=\"cc_month\"]")));
		month.selectByValue("05");
		Select year = new Select(driver.findElement(By.xpath("//*[@id=\"ccYear\"]")));
		year.selectByValue("2020");
		WebElement fieldCodeCvc = driver.findElement(By.xpath("//*[@id=\"cc_cvc\"]"));
		fieldCodeCvc.sendKeys("123");
		WebElement completeBooking = driver
				.findElement(By.xpath("//*[@id=\"bookwrapper_cell\"]/div[4]/div[1]/button[2]/ins"));
		completeBooking.click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mb-container\"]/div[4]/div/div/span")).isDisplayed(),
				"Reservation completed successfully");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
