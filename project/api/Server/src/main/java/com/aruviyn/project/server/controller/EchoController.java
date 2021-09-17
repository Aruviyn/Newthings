package com.aruviyn.project.server.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

	@RequestMapping(
			value	= "/api/toLower",
			params	= "input",
			method	= RequestMethod.GET)
	public String toLower(
			@RequestParam String input) {
		String ret = "";
		ret = input.toLowerCase();
		return ret;
	}
}
