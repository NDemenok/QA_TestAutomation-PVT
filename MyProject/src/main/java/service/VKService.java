package service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

public class VKService {

	private static final String URL = "https://api.vk.com/method/messages.%s?";
	private static final String ACCESS_TOKEN = "86de54f7f2605dc2a6812225133da09f0af4bcec4725918ccf997d105d13e7a7703f2a098a75c285de0e3";
	private static final String VERSION = "5.92";
	private static final Logger LOG = Logger.getLogger(VKService.class);

	private HttpClient client;
	private URIBuilder uri;

	public VKService() {
		client = HttpClientBuilder.create().build();
	}

	public VKService setMethod(String path) {
		try {
			uri = new URIBuilder(String.format(URL, path));
			uri.setParameter("access_token", ACCESS_TOKEN).setParameter("v", VERSION);
		} catch (URISyntaxException e) {
			LOG.info("Failed to send request");
		}
		return this;
	}

	public VKService setParam(String param, String value) {
		uri.setParameter(param, value);
		return this;
	}

	public HttpResponse call() {
        HttpResponse response = null;
        try {
            HttpGet getRequest = new HttpGet(uri.build());
            response = client.execute(getRequest);
        }
        catch (URISyntaxException | IOException e) {
        	LOG.info("Failed to get response");
        }
        return response;
    }
}
