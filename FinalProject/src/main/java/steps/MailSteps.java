package steps;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import businessobject.Recepient;
import businessobject.User;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.RecepientsDataProvider;
import dataprovider.UserDataProvider;
import pages.MailPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import webdriver.WebDriverProvider;

public class MailSteps {

	private static final String TOPIC = "Test";
	private static final Logger LOG = Logger.getLogger(MailSteps.class);
	private MailPage mailPage;
	private WebDriver driver;

	public MailSteps() {
		driver = WebDriverProvider.getDriverInstance();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		mailPage = new MailPage(driver);
		LOG.info("Constructor MailSteps");
	}

	@When("^I login as correct user$")
	public void loginAsCorrectUser() throws NumberFormatException, SQLException, ClassNotFoundException {
		User user = UserDataProvider.getUserData();
		mailPage.enterLoginAndPass(user.getLogin(), user.getPassword());
		mailPage.clickEnterButton();
		makeScreenshot();
		LOG.info("Login correct");
	}

	@When("^I move letter on folder spam$")
	public void checkLetterSpam() {
		mailPage.pushOpenLetter();
		mailPage.pushButtonSpam();
		mailPage.clickCancel();
		makeScreenshot();
		LOG.info("Move letter to spam");
	}

	@When("^I push button \"Send letter\"$")
	public void writeNewLetter() {
		mailPage.pushButtonWriteLetter();
		LOG.info("Write letter");
	}

	@When("^I input a few email addresses and letter subject$")
	public void inputDataForNewLetter() {
		List<String> recepients = new RecepientsDataProvider().getRecepientData().stream().map(Recepient::getAddress)
				.collect(Collectors.toList());
		mailPage.fillFormSendLetter(recepients, TOPIC);
		mailPage.pushButtonSend();
		mailPage.pushButtonContinue();
		makeScreenshot();
		LOG.info("Send letter");
	}

	@When("^I mark three letter with flag$")
	public void checkLetter() {
		mailPage.markFlag();
		makeScreenshot();
		mailPage.goToOrderMarkFlag();
		LOG.info("Mark three letter with flag");
	}

	@When("^I unchecked letters with flag$")
	public void uncheckLetter() {
		mailPage.markFlag();
		makeScreenshot();
		mailPage.goToOrderMarkFlag();
		LOG.info("Unchecked letters with flag");
	}

	@When("^I delete one message$")
	public void deleteLetter() {
		mailPage.pushOpenLetter();
		mailPage.deleteLetter();
		mailPage.clickCancel();
		makeScreenshot();
		LOG.info("Delete message");
	}

	@Then("^I see logout link$")
	public void seeLogoutLink() {
		Assert.assertTrue(mailPage.logoutLinkPresents());
	}

	@Then("^I see letter on mail box$")
	public void letterPresentOnMailBoxTest() {
		Assert.assertTrue(mailPage.letterPresentOnMailBox());
	}

	@Then("^I see message \"Letter moved to spam\"$")
	public void letterMoveSpamTest() {
		Assert.assertTrue(mailPage.letterMoveSpam());
	}

	@Then("^I see message \"Letter is sent\"$")
	public void letterIsSentTest() {
		Assert.assertTrue(mailPage.letterIsSent());
	}

	@Then("^I see letter with flag on folder \"Marked flag\"$")
	public void lettersWithFlagPresentsTest() {
		Assert.assertTrue(mailPage.lettersWithFlagPresents());
	}

	@Then("^I checked folder \"Marked flag\" is empty$")
	public void lettersWithFlagAbsentTest() {
		Assert.assertTrue(mailPage.lettersWithFlagAbsent());
	}

	@Then("^I see message \"Letter deleted\"$")
	public void letterDeleteSucсsessfullyTest() {
		Assert.assertTrue(mailPage.letterDeleteSucсsessfully());
	}

	@Attachment(value = "Attachment Screenshot", type = "image/png")
	public byte[] makeScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	} 
	
	@After
	public void afterClass() {
		driver.manage().deleteAllCookies();
	}
}
