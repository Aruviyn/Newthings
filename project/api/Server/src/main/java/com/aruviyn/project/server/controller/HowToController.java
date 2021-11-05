package com.aruviyn.project.server.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aruviyn.project.lingo.fetcher.impl.api.DictionaryAPIFetcher;

@RestController
@RequestMapping("/howto")
public class HowToController {
	
	@RequestMapping(
			value 	= "/api/howToUse",
			params 	= "word",
			method	= RequestMethod.GET)
	public String howToUse(@RequestParam String word) {
		String response = "";
		DictionaryAPIFetcher dictionaryFetcher = new DictionaryAPIFetcher("https://api.dictionaryapi.dev/api/v2/entries/en/"+word);
		try {
			response = dictionaryFetcher.processResponse(dictionaryFetcher.fetch());
		}catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
		return response;
	}
	

}
