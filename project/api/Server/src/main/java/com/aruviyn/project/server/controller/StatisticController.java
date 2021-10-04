package com.aruviyn.project.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aruviyn.project.api.statistic.Statistic;


@RestController
@RequestMapping("/statistic")
public class StatisticController {
	
	@RequestMapping(
			value = "/api/mean",
			params = "input",
			method = RequestMethod.GET)
	public String mean(@RequestParam String input) {
		String response = "";

		Statistic statistic = new Statistic();
		response = ""+statistic.mean(input.split(" "));
		
		return response;
	}
	
	@RequestMapping(
			value = "/api/mode",
			params = "input",
			method = RequestMethod.GET)
	public String mode(@RequestParam String input) {
		String response = "";
		
		Statistic statistic = new Statistic();
		response = ""+statistic.mode(input.split(" "));
		
		return response;
	}
	
	@RequestMapping(
			value = "/api/median",
			params = "input",
			method = RequestMethod.GET)
	public String median(@RequestParam String input) {
		String response = "";
		
		Statistic statistic = new Statistic();
		response = ""+statistic.median(input.split(" "));
		return response;
	}
}
