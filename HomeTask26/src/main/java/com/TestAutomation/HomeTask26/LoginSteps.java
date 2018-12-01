package com.TestAutomation.HomeTask26;

import java.sql.SQLException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	private static final String MAIN_URL = "http://mail.ru";
	private LoginPage loginPage;
	private WebDriver webDriver;

	public LoginSteps() {
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
	}

	@Given("^I am on main application page$")
	public void loadMainPage() {
		webDriver.get(MAIN_URL);
	}

	@When("^I login as correct user$")
	public void loginAsCorrectUser() throws NumberFormatException, SQLException {
		User user = UserDataProvider.getUserData();
		loginPage.enterLoginAndPass(user.getLogin(), user.getPassword());
		loginPage.clickEnterButton();
	}

	@Then("I see logout link")
	public void seeLogoutLink() {
		Assert.assertTrue(loginPage.logoutLinkPresents());
	}

	@Then("I see error message")
	public void seeErrorMessage() {
		Assert.assertTrue(loginPage.logoutLinkErrorPresents());
	}

	@After
	public void afterClass() {
		webDriver.quit();
	}
}
