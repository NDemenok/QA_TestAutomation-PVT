package test;

import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MailPage;
import pages.WebDriverProvider;

public class MailPageTest extends BaseTest{

	private MailPage mailPage;

	@Test(priority = 1)
	public void moveLetterToSpam() {
		mailPage = new MailPage(WebDriverProvider.getDriverInstance());
		mailPage.pushOpenLetter();
		mailPage.pushButtonSpam();
		Assert.assertTrue(mailPage.letterMoveSpam(), "Letter not move on spam");
	}

	@Test(priority = 2)
	public void moveLetterFromSpam() {
		mailPage.clickCancel();
		;
		mailPage.openFolderIncoming();
		Assert.assertTrue(mailPage.elementPresentInFolder(), "Letter not move from spam");
	}

	@Test(priority = 3)
	public void sendMessageForGroupUsers() {
		mailPage.pushButtonWriteLetter();
		mailPage.fillFormSendLetter(Arrays.asList("xxxx@unmail.ru;", "yyyy@unmail.ru;", "zzzz@unmail.ru;"), "topic");
		mailPage.pushButtonSend();
		mailPage.pushButtonContinue();
		Assert.assertTrue(mailPage.letterIsSent(), "Letter not sent");
	}

	@Test(priority = 4)
	public void markThreeLettersWithFlag() {
		mailPage.markFlag();
		mailPage.goToOrderMarkFlag();
		Assert.assertTrue(mailPage.lettersWithFlagPresents(), "No letters with flag");
	}

	@Test(priority = 5)
	public void uncheckAllLetters() {
		mailPage.openFolderIncoming();
		mailPage.uncheckFlag();
		mailPage.goToOrderMarkFlag();
		Assert.assertTrue(mailPage.lettersWithFlagAbsent(), "Order is not empty");
	}
	
}
