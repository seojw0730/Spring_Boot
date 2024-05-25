package kh.mclass.demo4.login.controller;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class NaverApi {
	
	@Value("${naver.login.clientid}")
	private String clientId;
	
	@Value("${naver.login.clientsecret}")
	private String clientSecret;
	
	@Value("${naver.login.callbackurl}")
	private String callBackUrl;
	
	public String getAccessToken(String code) {
		String accessToken = "";
		String reqUrl = "https://nid.naver.com/oauth2.0/token";
		
		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("grant_type", "authorization_code");
			conn.setRequestProperty("client_id", clientId);
			conn.setRequestProperty("client_secret", clientSecret);
			conn.setRequestProperty("code", code);
			conn.setRequestProperty("state", reqUrl);
			
		} catch (Exception e) {
		}
		return "";
	}
}
