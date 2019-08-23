package com.zzl.greenroom.module.system.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzl.greenroom.module.code.User;
import com.zzl.greenroom.module.system.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String  index(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("token")) {
				String token = cookie.getValue();
				QueryWrapper<User> wrapper = new QueryWrapper<User>();
				wrapper.eq("token", token);
				System.out.println(wrapper.getSqlSegment());
				User user = userService.getOne(wrapper);
				if(user!=null) {
					request.getSession().setAttribute("user", user);
				}
				break;
			}
		}
		
		return "index";
		
	}
}
