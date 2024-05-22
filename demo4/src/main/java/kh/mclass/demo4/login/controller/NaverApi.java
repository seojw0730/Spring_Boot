package kh.mclass.demo4.login.controller;

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
	
}
