package steps;

import org.apache.http.HttpResponse;
import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import service.VKService;

public class VKSteps {

	private static final String USER_ID = "9441983";
	private static final String MESSAGE_ID = "47259";
	public static final String MESSAGE = "Hello from java";
	public static final String MODIFY_MESSAGE = "Hello from java Modify";
	private int actualResponseCode;

	@When("^I call send message service$")
	public void sendMessage() {
		HttpResponse getResponse = new VKService().setMethod("send").setParam("user_id", USER_ID)
				.setParam("message", MESSAGE).setParam("random_id", "111").call();
		actualResponseCode = getResponse.getStatusLine().getStatusCode();
	}

	@Then("^I get positive status code by send$")
	public void sendMessageTest() {
		Assert.assertEquals(200, actualResponseCode);
	}

	@When("^I call edit message service$")
	public void editMessage() {
		HttpResponse getResponse = new VKService().setMethod("edit").setParam("peer_id", USER_ID)
				.setParam("message_id", MESSAGE_ID).setParam("message", MODIFY_MESSAGE).call();
		actualResponseCode = getResponse.getStatusLine().getStatusCode();
	}

	@Then("^I get positive status code by edit$")
	public void editMessageTest() {
		Assert.assertEquals(200, actualResponseCode);
	}

	@When("^I call delete message service$")
	public void deleteMessage() {
		HttpResponse getResponse = new VKService().setMethod("delete").setParam("peer_id", USER_ID)
				.setParam("message_id", MESSAGE_ID).call();
		actualResponseCode = getResponse.getStatusLine().getStatusCode();
	}

	@Then("^I get positive status code by delete$")
	public void deleteMessageTest() {
		Assert.assertEquals(200, actualResponseCode);
	}

	@When("^I call post photo service$")
	public void postPhoto() {
		HttpResponse getResponse = new VKService().setMethod("send").setParam("user_id", USER_ID)
				.setParam("message", MESSAGE).setParam("attachment", "photo9441983_318685855")
				.setParam("random_id", "111").call();
		actualResponseCode = getResponse.getStatusLine().getStatusCode();
	}

	@Then("^I get positive status code by send photo$")
	public void postPhotoTest() {
		Assert.assertEquals(200, actualResponseCode);
	}
}
