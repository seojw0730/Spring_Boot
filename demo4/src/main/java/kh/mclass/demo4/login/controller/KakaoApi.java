package kh.mclass.demo4.login.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import lombok.Data;

@Component
@Data
public class KakaoApi {
	
	@Value("${kakao.login.clientid}")
	private String apiKey;
	
	@Value("${kakao.login.redirecturi}")
	private String loginRedirectUri;
	
	@Value("${kakao.logout.redirecturi}")
	private String logoutRedirectUri;
	
	public String getAccessToken(String code) {
		String accessToken = "";
		String refreshToken = "";
		String reqUrl = "https://kauth.kakao.com/oauth/token";
		
		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setDoOutput(true);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=").append(apiKey);
			sb.append("&redirect_url=").append(loginRedirectUri);
			sb.append("&code=").append(code);
			
			bw.write(sb.toString());
			bw.flush();
			
			int responseCode = conn.getResponseCode();
			System.out.println("[KakaoApi.getAccessToken] responseCode = "+responseCode);
			
			BufferedReader br;
			if (responseCode >= 200 && responseCode <= 300) {
	            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
			
			String line = "";
			StringBuilder responseSb = new StringBuilder();
			while((line = br.readLine())!=null) {
				responseSb.append(line);
			}
			String result = responseSb.toString();
			System.out.println("responseBody = "+result);
			
			Map<String, String> resultMap = new Gson().fromJson(result, Map.class);
			accessToken = resultMap.get("access_token");
			refreshToken = resultMap.get("refresh_token");
			
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return accessToken;
	}
	
	public HashMap<String, Object> getUserInfo(String accessToken){
		HashMap<String, Object> userInfo = new HashMap<>();
		String reqUrl = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer "+accessToken);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;utf-8");
			
			int responseCode = conn.getResponseCode();
			System.out.println("[KakaoApi.getUserInfo] responseCode : "+responseCode);
			
			BufferedReader br;
			if (responseCode >= 200 && responseCode <= 300) {
	            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
			
			String line = "";
			StringBuilder responseSb = new StringBuilder();
			while((line = br.readLine())!=null) {
				responseSb.append(line);
			}
			String result = responseSb.toString();
			System.out.println("responseBody = "+result);
			
			Gson gson = new Gson();
			
			HashMap<String, Object> resultMap = gson.fromJson(result, HashMap.class);
			
			
			String propertiesStr = gson.toJson(resultMap.get("properties"));
			System.out.println(propertiesStr);
			String kakaoAccountStr = gson.toJson(resultMap.get("kakao_account"));
			
			HashMap<String, Object> properties = gson.fromJson(propertiesStr, HashMap.class);
			HashMap<String, Object> kakaoAccount = gson.fromJson(kakaoAccountStr, HashMap.class);
			
			String nickname = (String)properties.get("nickname");
			String email = (String)kakaoAccount.get("email");
			
			userInfo.put("nickname", nickname);
			userInfo.put("email", email);
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userInfo;
	}
	
	public void kakaoLogout(String accessToken) {
		String reqUrl = "https://kapi.kakao.com/v1/user/logout";
		
		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer "+accessToken);
			
			int responseCode = conn.getResponseCode();
			System.out.println("[KakaoApi.kakaoLogout] responseCode : "+responseCode);
			
			BufferedReader br;
		    if (responseCode >= 200 && responseCode <= 300) {
		    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    } else {
		    br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		    }

		    String line = "";
		    StringBuilder responseSb = new StringBuilder();
		    while((line = br.readLine()) != null){
		    responseSb.append(line);
		    }
		    String result = responseSb.toString();
		    System.out.println("kakao logout - responseBody = "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
