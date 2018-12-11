package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Page {

	@FindBy(xpath = "//*[@id=\"q\"]")
    private WebElement searchField;
	
	@FindBy(id = "search:submit")
    private WebElement searchButton;
	
	@FindBy(xpath = "(//li[@class=\"result__li\"]/descendant::b[text()=\"Камбербэтч\"])[1]")
    private WebElement firstSearchLink;
	
	@FindBy(xpath = "//a[@data-alias=\"moymir\"]//h3[text()=\"Мой Мир\"]")
	private WebElement linkMoyMir;
	
	@FindBy(xpath = "//a[@data-alias=\"icq\"]//h3[text()=\"ICQ\"]")
	private WebElement linkICQ;
	
	@FindBy(xpath = "//a[text()=\"Зарегистрируйтесь сейчас\"]")
	private WebElement buttonRegisterNow;
	
	@FindBy(xpath = "//span[contains(text(),\"Скачать ICQ\")]")
	private WebElement buttonDownloadICQ;
	
	public SearchPage(WebDriver driver)
    {
		super(driver);
		PageFactory.initElements(driver, this);
    }
	
	public void enterSearchValue(String request) {
		searchField.clear();
		searchField.sendKeys(request);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public boolean seeLinkWithResult() {
		return firstSearchLink.isDisplayed();
	}
	
	public void followLinkMoyMir() {
		linkMoyMir.click();
	}
	
	public boolean seeButtonRegisterNow() {
		return buttonRegisterNow.isDisplayed();
	}
	
	public void followLinkICQ() {
		linkICQ.click();
	}
	
	public boolean seeLinkDownloadICQ() {
		return buttonDownloadICQ.isDisplayed();
	}
}
