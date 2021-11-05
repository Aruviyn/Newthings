package com.aruviyn.project.lingo;

import com.aruviyn.project.lingo.fetcher.impl.api.DictionaryAPIFetcher;

import java.io.IOException;

/**
 * This class serves as a program to execute the various implementation of functions in this project.
 * @author fazreil
 *
 */
public class App
{
    /**
     * Main function to execute the various implementation of functions
     * @param args The arguments will be the one used to work with the functions.
     * @author fazreil
     */
	public static void main( String[] args )
    {
        DictionaryAPIFetcher dictionaryFetcher =
            new DictionaryAPIFetcher( "https://api.dictionaryapi.dev/api/v2/entries/en/" + args[0] );
        String responseString = "";

        try
        {
            responseString = dictionaryFetcher.processResponse( dictionaryFetcher.fetch(  ) );
            System.out.println( responseString );
        } catch ( IOException ioEx )
        {
            ioEx.printStackTrace(  );
        }
    }
}
