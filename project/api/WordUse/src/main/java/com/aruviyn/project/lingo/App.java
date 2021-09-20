package com.aruviyn.project.lingo;

import java.io.IOException;

import com.aruviyn.project.lingo.fetcher.impl.api.DictionaryAPIFetcher;

public class App 
{
    public static void main( String[] args )
    {
    	DictionaryAPIFetcher dictionaryFetcher = new DictionaryAPIFetcher("https://api.dictionaryapi.dev/api/v2/entries/en/"+args[0]);
		String responseString = "";
		try {
			responseString = dictionaryFetcher.processResponse(dictionaryFetcher.fetch());
			System.out.println(responseString);
		}catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
    }
}
