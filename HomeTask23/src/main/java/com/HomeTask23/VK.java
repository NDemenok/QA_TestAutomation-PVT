package com.HomeTask23;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class VK {

	public static final String URL = "https://api.vk.com/method/";
	public static final String ACCESS_TOKEN = "86de54f7f2605dc2a6812225133da09f0af4bcec4725918ccf997d105d13e7a7703f2a098a75c285de0e3";
	public static final String USER_ID = "9441983";
	public static final String RANDOM_ID = "222";
	public static final String VERSION = "5.92";
	public static final String ATTACHMENT = "photo9441983_318685855";
	public static final String MESSAGE = "Hello from java";
	public static final String MODIFY_MESSAGE = "Hello from java for Nataly";

	HttpClient client = HttpClientBuilder.create().build();

	public HttpResponse sendMessage() throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder builder = new URIBuilder(URL + "messages.send?");
		builder.setParameter("access_token", ACCESS_TOKEN).setParameter("user_id", USER_ID)
				.setParameter("message", MESSAGE).setParameter("v", VERSION).setParameter("random_id", RANDOM_ID);
		HttpGet request = new HttpGet(builder.build());
		HttpResponse response = client.execute(request);
		return response;
	}

	public HttpResponse editMessage() throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder builder1 = new URIBuilder(URL + "messages.edit?");
		builder1.setParameter("access_token", ACCESS_TOKEN).setParameter("peer_id", USER_ID)
				.setParameter("message", MODIFY_MESSAGE).setParameter("v", VERSION).setParameter("message_id", "47259");
		HttpGet request1 = new HttpGet(builder1.build());
		HttpResponse response1 = client.execute(request1);
		return response1;
	}

	public HttpResponse deleteMessage() throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder builder2 = new URIBuilder(URL + "messages.delete?");
		builder2.setParameter("access_token", ACCESS_TOKEN).setParameter("peer_id", USER_ID).setParameter("v", VERSION)
				.setParameter("message_ids", "47259");
		HttpGet request2 = new HttpGet(builder2.build());
		HttpResponse response2 = client.execute(request2);
		return response2;
	}

	public HttpResponse sendPhoto() throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder builder3 = new URIBuilder(URL + "messages.send?");
		builder3.setParameter("access_token", ACCESS_TOKEN).setParameter("user_id", USER_ID)
				.setParameter("message", MESSAGE).setParameter("attachment", ATTACHMENT).setParameter("v", VERSION)
				.setParameter("random_id", RANDOM_ID);
		HttpGet request3 = new HttpGet(builder3.build());
		HttpResponse response3 = client.execute(request3);
		return response3;
	}
}
