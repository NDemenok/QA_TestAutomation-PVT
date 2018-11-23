package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainSteps {

	private WebDriver driver;
	private MainPage mainPage;
	private static final String URL = "https://Booking.com";
	private static final String CITY = "Москва";

	public MainSteps() {
		driver = new ChromeDriver();
		mainPage = new MainPage(driver);
	}

	@Given("^I am on main application page$")
	public void loadMainPage() {
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@When("^I input city$")
	public void inputCity() {
		mainPage.inputCity(CITY);
	}

	@And("^I choose date$")
	public void chooseDate() {
		mainPage.setDate();
	}

	@And("^Input information about guests$")
	public void informationAboutGuests() {
		mainPage.getInformationAboutGuests("1", "2", "0");
	}

	@And("^I click search button$")
	public void clickSearchButton() {
		mainPage.pushSearchButton();
	}

	@Then("^I see order with hotel offers$")
	public void seeOrderHotels() {
		Assert.assertTrue("There are not hotels on selected dates", mainPage.listNotEmpty());
	}

	@Given("^I on page with hotel offers$")
	public void stayHere() {

	}

	@When("^I push field filter by feedbacks$")
	public void pushFieldFilter() {
		mainPage.getFilter();
	}

	@And("^I go by first link$")
	public void goByFirstLink() {
		mainPage.chooseFirstHotel();
	}

	@Then("^I check hotel rating more than 9$")
	public void checkRating() {
		String numberOfRaiting = mainPage.chooseFirstHotel();
		Double rating = Double.parseDouble(numberOfRaiting);
		Assert.assertTrue("Rating less than 9", rating >= 9);
	}

	@After
	public void afterSuite() {
		driver.quit();
	}
}
