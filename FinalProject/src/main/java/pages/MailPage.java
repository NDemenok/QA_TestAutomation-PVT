package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends Page {

	private static final int LINK_PRESENSE_TIMEOUT = 30;

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id='mailbox:submit']/input")
	private WebElement buttonEnter;

	@FindBy(xpath = "//*[@id='PH_logoutLink']")
	private WebElement logoutLink;

	@FindBy(xpath = "//a[@data-subject=\"TestLetter\"]/descendant::div[contains(text(),\"TestLetter\")]")
	private WebElement myletter;

	@FindBy(xpath = "//div[@class=\"message-sent__title\"]")
	private WebElement messageSent;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div[1]/div/div[2]/div[4]/div/div[1]")
	private WebElement buttonSpam;

	@FindBy(xpath = "//span[text()=\"Написать письмо\"]")
	private WebElement buttonWriteLetter;

	@FindBy(xpath = "(//div[@data-name='send'])[1]")
	private WebElement buttonSend;

	@FindBy(xpath = "//button[@class=\"btn btn_stylish btn_main confirm-ok\"]" + "/span[text()=\"Продолжить\"]")
	private WebElement buttonContinue;
	
	@FindBy(xpath = "(//div[@data-name=\"remove\"]/child::span[contains(text(),\"Удалить\")])[2]")
	private WebElement buttonDelete;
	
	@FindBy(xpath = "//div[@class=\"js-ok notify-message\"]/descendant::span")
	private WebElement signalMessage;

	@FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span/a")
	private WebElement cancel;

	@FindBy(xpath = "//a[@id=\"ph_mail\"]")
	private WebElement folderIncoming;

	@FindBy(xpath = "//textarea[@data-original-name=\"To\"]")
	private WebElement fieldWhom;

	@FindBy(xpath = "//input[@data-bem=\"b-input\"]")
	private WebElement fieldTopic;

	@FindBy(xpath = "(//div[@class=\"b-datalist__item__flag\"]/div[@data-id])[1]")
	private WebElement fieldFirstFlag;

	@FindBy(xpath = "(//div[@class=\"b-datalist__item__flag\"]/div[@data-id])[2]")
	private WebElement fieldTwoFlag;

	@FindBy(xpath = "(//div[@class=\"b-datalist__item__flag\"]/div[@data-id])[3]")
	private WebElement fieldThreeFlag;

	@FindBy(xpath = "(//i[@class=\"ico ico_filters ico_filters_flagged\"])[1]")
	private WebElement fieldMarkFlag;

	@FindBy(xpath = "(//div[@class=\"b-datalist__empty\"])[1]")
	private WebElement isEmpty;
	
	public MailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterLoginAndPass(String login, String password) {
		loginField.clear();
		loginField.sendKeys(login);
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickEnterButton() {
		buttonEnter.click();
	}

	public boolean logoutLinkPresents() {
		return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(logoutLink))
				.isDisplayed();
	}

	public boolean letterPresentOnMailBox() {
		return fluentWait.until(ExpectedConditions.visibilityOf(myletter)).isDisplayed();
	}

	public void pushOpenLetter() {
		fluentWait.until(ExpectedConditions.elementToBeClickable(myletter));
		myletter.click();
	}

	public void pushButtonSpam() {
		fluentWait.until(ExpectedConditions.elementToBeClickable(buttonSpam));
		buttonSpam.click();
	}

	public boolean letterMoveSpam() {
		return signalMessage.isDisplayed();
	}

	public void clickCancel() {
		cancel.click();
	}

	public void openFolderIncoming() {
		fluentWait.until(ExpectedConditions.visibilityOf(folderIncoming));
		folderIncoming.click();
	}

	public void pushButtonWriteLetter() {
		buttonWriteLetter.click();
	}

	public void fillFormSendLetter(List<String> emails, String topic) {
		fieldWhom.clear();
		emails.forEach(email -> fieldWhom.sendKeys(email));
		fieldTopic.clear();
		fieldTopic.sendKeys(topic);
	}

	public void pushButtonContinue() {
		buttonContinue.click();
	}

	public void pushButtonSend() {
		buttonSend.click();
	}

	public boolean letterIsSent() {
		return messageSent.isDisplayed();
	}

	public void markFlag() {
		fieldFirstFlag.click();
		fieldTwoFlag.click();
		fieldThreeFlag.click();
	}

	public void goToOrderMarkFlag() {
		fieldMarkFlag.click();
	}

	public boolean lettersWithFlagPresents() {
		return fluentWait.until(ExpectedConditions.visibilityOf(myletter)).isDisplayed();
	}

	public boolean lettersWithFlagAbsent() {
		return fluentWait.until(ExpectedConditions.visibilityOf(isEmpty)).isDisplayed();
	}

	public void deleteLetter() {
		fluentWait.until(ExpectedConditions.elementToBeClickable(buttonDelete)).click();
	}
	
	public boolean letterDeleteSucсsessfully() {
		return signalMessage.isDisplayed();
	}
}
