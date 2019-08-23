package com.zzl.greenroom.module.system.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zzl.greenroom.common.AccessToken;
import com.zzl.greenroom.common.GithubUser;
import com.zzl.greenroom.module.code.User;
import com.zzl.greenroom.module.system.provider.GithubProvider;
import com.zzl.greenroom.module.system.service.UserService;

@Controller
public class AuthorizeController {
	@Autowired
	private GithubProvider githubProvider;
	
	@Autowired
	private UserService userService;
	
	@Value("${github.client.id}")
	private String clientId;
	
	@Value("${github.client.secret}")
	private String clientSecret;
	
	@Value("${github.redirect.uri}")
	private String redirectUri;
	
	@GetMapping("/callback")
	public ModelAndView callback(@RequestParam(value="code") String code,
						   @RequestParam(value="state") String state,
						   HttpServletResponse response) {
		AccessToken accessToken = new AccessToken();
		accessToken.setClient_id(clientId);
		accessToken.setClient_secret(clientSecret);
		accessToken.setCode(code);
		accessToken.setRedirect_uri(redirectUri);
		accessToken.setState(state);
		String hubtoken = githubProvider.getAccessToken(accessToken);
		GithubUser hubUser = githubProvider.getUser(hubtoken);
		if (hubUser!=null) {
			//user不为空  登陆成功
			User user = new User();
			String token = UUID.randomUUID().toString();
			user.setToken(token);
			user.setName(hubUser.getName());
			user.setAccountId(String.valueOf(hubUser.getId()));
			user.setGmtCreate(System.currentTimeMillis());
			user.setGmtModified(user.getGmtCreate());
			boolean b = userService.save(user);
			//登陆成功 写入cookie
			response.addCookie(new Cookie("token", token));
			return new ModelAndView("redirect:/");
		}else {
			//user为空 登陆失败
			return new ModelAndView("redirect:/");
		}
		
	}
}
