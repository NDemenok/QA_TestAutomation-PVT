package steps;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import webdriver.WebDriverProvider;

public class SearchSteps {

	private static final String MAIN_URL = "http://mail.ru";
	private static final Logger LOG = Logger.getLogger(SearchSteps.class);
	private SearchPage searchPage;
	private WebDriver driver;

	public SearchSteps() {
		driver = WebDriverProvider.getDriverInstance();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		searchPage = new SearchPage(driver);
		LOG.info("Constructor SearchSteps");
	}

	@Given("^I am on main application page$")
	public void loadMainPage() {
		driver.get(MAIN_URL);
		LOG.info("Loading page");
	}

	@When("^I perform search by \"([^\"]*)\"$")
	public void performSearchByData(String data) {
		searchPage.enterSearchValue(data);
		searchPage.clickSearchButton();
		makeScreenshot();
		LOG.info("Search perform");
	}

	@Then("^I see name \"Бенедикт Камбербэтч\" in the first link$")
	public void performSearchByDataTest() {
		Assert.assertTrue("No result", searchPage.seeLinkWithResult());
	}

	@When("^I follow the link \"Мой Мир\"$")
	public void followLinkMoyMirTest() {
		searchPage.followLinkMoyMir();
		makeScreenshot();
		LOG.info("Follow link Moy Mir");
	}

	@Then("^I see button \"Зарегистрируйтесь сейчас\"$")
	public void seeButtonRegisterNowTest() {
		Assert.assertTrue("Don't follow by link", searchPage.seeButtonRegisterNow());
	}

	@When("^I follow the link \"ICQ\"$")
	public void followLinkICQTest() {
		searchPage.followLinkICQ();
		makeScreenshot();
		LOG.info("Follow link ICQ");
	}

	@Then("^I see button \"Скачать ICQ\"$")
	public void seeLinkDownloadICQTest() {
		Assert.assertTrue("Don't follow by link", searchPage.seeLinkDownloadICQ());
	}

	@Attachment(value = "Attachment Screenshot", type = "image/png")
	public byte[] makeScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@After
	public void afterClass() {
		driver.quit();
		LOG.info("Driver close");
	}
}
