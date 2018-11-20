package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MailPage;
import pages.WebDriverProvider;

public class LoginPageTest extends BaseTest {

	private LoginPage loginPage;
	private MailPage mailPage;

	@BeforeSuite
	public void beforeSuite() {
		driver = WebDriverProvider.getDriverInstance();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://mail.ru");
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 0)
	public void loginTest() {
		loginPage.enterLoginAndPass("UserBehaviorTest", "123aaaddd");
		loginPage.clickEnterButton();
		mailPage = new MailPage(WebDriverProvider.getDriverInstance());
		Assert.assertTrue(mailPage.logoutLinkPresents());
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}
