package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	@FindBy(xpath = "//*[@id=\"ss\"]")
	private WebElement fieldSearch;

	@FindBy(xpath = "(//button[@aria-label=\"Открыть календарь\"])[2]")
	private WebElement fieldCalendar;

	@FindBy(xpath = "//*[@id=\"xp__guests__toggle\"]/span")
	private WebElement fieldGuests;

	@FindBy(xpath = "//*[@id=\"no_rooms\"]")
	private WebElement fieldselectRooms;

	@FindBy(xpath = "//*[@id=\"group_adults\"]")
	private WebElement fieldselectAdults;

	@FindBy(xpath = "//*[@id=\"group_children\"]")
	private WebElement fieldselectChildren;

	@FindBy(xpath = "//button/span[text()=\"Проверить цены\"]")
	private WebElement buttonSearch;

	@FindBy(xpath = "//div[@id='search_results_table']//a[contains(@class, 'b-button')]")
	private WebElement offerHotel;

	@FindBy(xpath = "//*[@id=\"sort_by\"]/ul/li[3]/a")
	private WebElement filterByMaxRating;

	@FindBy(xpath = "//*[@id=\"hotel_4220764\"]/a/img")
	private WebElement bestOffer;

	@FindBy(xpath = ".//div[@class=\"bui-review-score__badge\"]")
	private WebElement fieldRaiting;

	private WebDriver driver;
	private Wait<WebDriver> wait;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 40, 1000);
		PageFactory.initElements(driver, this);
	}

	public void inputCity(String city) {
		fieldSearch.clear();
		fieldSearch.sendKeys(city);
	}

	public void setDate() {
		fieldCalendar.click();
		String inDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		driver.findElement(By.xpath("//td[@data-date='" + inDate + "']")).click();
		String outDate = LocalDate.now().plusDays(1 + 2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		driver.findElement(By.xpath("//td[@data-date='" + outDate + "']")).click();
	}

	public void getInformationAboutGuests(String rooms, String adults, String children) {
		fieldGuests.click();
		if (driver.findElements(By.xpath("//select[@id=\"no_rooms\"]")).isEmpty()) {
			fieldGuests.click();
		} else {
			Select selectRooms = new Select(fieldselectRooms);
			selectRooms.selectByValue(rooms);
			Select selectAdults = new Select(fieldselectAdults);
			selectAdults.selectByValue(adults);
			Select selectChildren = new Select(fieldselectChildren);
			selectChildren.selectByValue(children);
		}
	}

	public void pushSearchButton() {
		buttonSearch.click();
	}

	public boolean listNotEmpty() {
		return offerHotel.isDisplayed();
	}

	public void getFilter() {
		wait.until(ExpectedConditions.visibilityOf(filterByMaxRating));
		filterByMaxRating.click();
	}

	public String chooseFirstHotel() {
		wait.until(ExpectedConditions.visibilityOf(bestOffer));
		bestOffer.click();
		driver.switchTo();
		return fieldRaiting.getText();
	}
}
