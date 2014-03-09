package com.androiddemo.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	// »ù´¡URL
	// public static final String BASE_URL =
	// "http://10.0.2.2:8080/WirelessOrder_Server/";
	public static final String BASE_URL = "http://192.168.1.104:8080/Login/";

	public static String login(String url) {
		HttpPost post = new HttpPost(url);
		String result = null;
		try {
			HttpResponse response = new DefaultHttpClient().execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (ClientProtocolException e) {
			result="1";
			e.printStackTrace();
		} catch (IOException e) {
			result="2";
			e.printStackTrace();
		}
		return result;
	}
}