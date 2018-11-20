package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailPage extends Page {

	public MailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='PH_logoutLink']")
	private WebElement logoutLink;

	@FindBy(xpath = "//a[@data-subject=\"TestLetter\"]")
	private WebElement myletter;

	@FindBy(xpath = "//div[@class=\"message-sent__title\"]")
	private WebElement messageSent;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div[1]/div/div[2]/div[4]/div/div[1]")
	private WebElement buttonSpam;

	@FindBy(xpath = "//span[text()=\"Написать письмо\"]")
	private WebElement buttonWriteLetter;

	@FindBy(xpath = "(//div[@data-name=\"send\"]/span[text()=\"Отправить\"])[1]")
	private WebElement buttonSend;

	@FindBy(xpath = "//button[@class=\"btn btn_stylish btn_main confirm-ok\"]" + 
							"/span[text()=\"Продолжить\"]")
	private WebElement buttonContinue;

	@FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span")
	private WebElement messageMoveOnSpam;

	@FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span/a")
	private WebElement cancel;

	@FindBy(xpath = "//a[@id=\"ph_mail\"]")
	private WebElement folderIncoming;

	@FindBy(xpath = "//textarea[@data-original-name=\"To\"]")
	private WebElement fieldWhom;

	@FindBy(xpath = "//input[@data-bem=\"b-input\"]")
	private WebElement fieldTopic;

	@FindBy(xpath = "//iframe[@id=\"toolkit-154271479739141composeEditor_ifr\"]")
	private WebElement fieldText;

	@FindBy(xpath = "(//div[@class=\"b-datalist__item__flag\"]/div[@data-id])[1]")
	private WebElement fieldFirstFlag;

	@FindBy(xpath = "(//div[@class=\"b-datalist__item__flag\"]/div[@data-id])[2]")
	private WebElement fieldTwoFlag;

	@FindBy(xpath = "(//div[@class=\"b-datalist__item__flag\"]/div[@data-id])[3]")
	private WebElement fieldThreeFlag;

	@FindBy(xpath = "(//i[@class=\"ico ico_filters ico_filters_flagged\"])[1]")
	private WebElement fieldMarkFlag;

	@FindBy(xpath = "//a[@data-subject=\"Вход с нового устройства\"]")
	private WebElement testLetter;
	
	@FindBy(xpath="(//div[@class=\"b-datalist__empty\"])[1]")
	private WebElement isEmpty;

	public boolean logoutLinkPresents() {
		wait.until(ExpectedConditions.visibilityOf(logoutLink));
		return logoutLink.isDisplayed();
	}

	public void pushOpenLetter() {
		myletter.click();
	}

	public void pushButtonSpam() {
		wait.until(ExpectedConditions.visibilityOf(buttonSpam));
		buttonSpam.click();
	}

	public boolean letterMoveSpam() {
		return messageMoveOnSpam.isDisplayed();
	}

	public void clickCancel() {
		cancel.click();
	}

	public boolean elementPresentInFolder() {
		wait.until(ExpectedConditions.visibilityOf(myletter));
		return myletter.isDisplayed();
	}

	public void openFolderIncoming() {
		wait.until(ExpectedConditions.elementToBeClickable(folderIncoming));
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
		wait.until(ExpectedConditions.elementToBeClickable(fieldTwoFlag));
		fieldTwoFlag.click();
		wait.until(ExpectedConditions.elementToBeClickable(fieldThreeFlag));
		fieldThreeFlag.click();
	}

	public void goToOrderMarkFlag() {
		wait.until(ExpectedConditions.visibilityOf(fieldMarkFlag));
		fieldMarkFlag.click();
	}

	public boolean lettersWithFlagPresents() {
		return myletter.isDisplayed();
	}

	public void uncheckFlag() {
		wait.until(ExpectedConditions.visibilityOf(fieldFirstFlag));
		fieldFirstFlag.click();
		wait.until(ExpectedConditions.visibilityOf(fieldTwoFlag));
		fieldTwoFlag.click();
		wait.until(ExpectedConditions.visibilityOf(fieldThreeFlag));
		fieldThreeFlag.click();
	}
	
	public boolean lettersWithFlagAbsent() {
		return isEmpty.isDisplayed();
	}
}
