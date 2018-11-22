package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	protected WebDriver driver;
	protected Select select;
	protected Wait<WebDriver> wait;

	public Page(WebDriver driver, Select select) {
		this.driver = driver;
		this.select = select;
		wait = new WebDriverWait(driver, 40, 1000);
	}
}
