package com.swapstech.fxstar.services.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/ping")
	public Boolean ping(){
		return true;
	}
}
