package com.jcombat.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jcombat.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/test")
@Api(value = "Login Controller", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

	@GetMapping
	public String welcome() {
		return "welcome";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation("Get the login Id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = User.class)})
	public boolean check(@RequestBody User user)
	{
        if (user.getUsename().equals("user1") && user.getPassword().equals("password1")) {
			
			return true;
		} 
		return false;
	}
}