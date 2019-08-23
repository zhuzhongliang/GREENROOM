package com.zzl.greenroom.module.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.greenroom.common.User;
import com.zzl.greenroom.module.system.dao.UserMapper;




@Controller
public class LoginController {
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String Login() {
		
		
		return "login";
		
	}
}
