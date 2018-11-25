package com.HomeTask23;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class TestJUnitVK{
	
	private VK vk = new VK();
	
	@Test
	public void sendMessageTest() throws ClientProtocolException, URISyntaxException, IOException {
		HttpResponse response = vk.sendMessage();
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	}
	
	@Test
	public void editMessageTest() throws ClientProtocolException, URISyntaxException, IOException {
		HttpResponse response = vk.editMessage();
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	}
	
	@Test
	public void deleteMessageTest() throws ClientProtocolException, URISyntaxException, IOException {
		HttpResponse response = vk.deleteMessage();
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	}
	
	@Test
	public void sendPhotoTest() throws ClientProtocolException, URISyntaxException, IOException {
		HttpResponse response = vk.sendPhoto();
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	}
}
