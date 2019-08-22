package com.zzl.greenroom.module.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzl.greenroom.common.AccessToken;
import com.zzl.greenroom.common.GithubUser;
import com.zzl.greenroom.module.system.provider.GithubProvider;

@Controller
public class AuthorizeController {
	@Autowired
	private GithubProvider githubProvider;
	
	@Value("${github.client.id}")
	private String clientId;
	
	@Value("${github.client.secret}")
	private String clientSecret;
	
	@Value("${github.redirect.uri}")
	private String redirectUri;
	
	@GetMapping("/callback")
	public String callback(@RequestParam(value="code") String code,
						   @RequestParam(value="state") String state) {
		AccessToken accessToken = new AccessToken();
		accessToken.setClient_id(clientId);
		accessToken.setClient_secret(clientSecret);
		accessToken.setCode(code);
		accessToken.setRedirect_uri(redirectUri);
		accessToken.setState(state);
		String token = githubProvider.getAccessToken(accessToken);
		GithubUser user = githubProvider.getUser(token);
		System.out.println(user.getName());
		return "index";
		
	}
}
