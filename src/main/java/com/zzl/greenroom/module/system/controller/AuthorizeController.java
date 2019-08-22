package com.zzl.greenroom.module.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView callback(@RequestParam(value="code") String code,
						   @RequestParam(value="state") String state,
						   HttpServletRequest request ) {
		AccessToken accessToken = new AccessToken();
		accessToken.setClient_id(clientId);
		accessToken.setClient_secret(clientSecret);
		accessToken.setCode(code);
		accessToken.setRedirect_uri(redirectUri);
		accessToken.setState(state);
		String token = githubProvider.getAccessToken(accessToken);
		GithubUser user = githubProvider.getUser(token);
		if (user!=null) {
			//user不为空  登陆成功
			request.getSession().setAttribute("user", user);
			return new ModelAndView("redirect:/");
		}else {
			//user为空 登陆失败
			return new ModelAndView("redirect:/");
		}
		
	}
}
