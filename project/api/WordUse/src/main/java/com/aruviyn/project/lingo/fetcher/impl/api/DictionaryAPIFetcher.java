package com.aruviyn.project.lingo.fetcher.impl.api;

import com.aruviyn.project.lingo.fetcher.impl.APIFetcher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;

/**
 * This class is an extension of the APIFetcher class where it fetches data from api.dictionaryapi.dev via API call
 * @author fazreil
 *
 */
public class DictionaryAPIFetcher
    extends APIFetcher
{
    public DictionaryAPIFetcher( String sourceUrl )
    {
        super( sourceUrl );
    }

    /**
     * This function processes the response and filter out unnecessary information so that we just end up with the usage of the word requested.
     * @param originalString This is the original string from the fetch function.
     * @author fazreil
     */
    public String processResponse( String originalString )
    {
        String processedString = "";
        JSONArray responseInJsonArray = new JSONArray( originalString );
        JSONObject responseInJson;

        try
        {
            responseInJson = responseInJsonArray.getJSONObject( 0 );

            JSONArray meanings = responseInJson.getJSONArray( "meanings" );
            String word = responseInJson.getString( "word" );

            //System.out.println(meanings.toString());
            LinkedList<String> examples = new LinkedList<String>(  );

            for ( int i = 0; i < meanings.length(  ); i++ )
            {
                JSONObject meaning = meanings.getJSONObject( i );
                LinkedList<String> exampleOfDefinition = processDefinitions( meaning.getJSONArray( "definitions" ) );

                for ( String example : exampleOfDefinition )
                {
                    examples.add( example );
                }
            }

            String examplesString = transformExamplesListIntoString( examples );

            processedString = "Here " + plurality( examples ) + " sample on how to use the word " + word + ":" + "\n" +
                              examplesString;
        } catch ( IndexOutOfBoundsException ioobEx )
        {
            System.out.println( "Error: empty response" );
            throw new IndexOutOfBoundsException(  );
        }

        return processedString;
    }

    /**
     * This function processes the each of the definition and give us a list of examples
     * @param definitions an array of definitions in JSON obtained from fetch()'s Response
     * @return A list of example of how to use the word in a string datatype.
     */
    private LinkedList<String> processDefinitions( JSONArray definitions )
    {
        LinkedList<String> exampleOfThisDefinitionList = new LinkedList<String>(  );

        for ( int j = 0; j < definitions.length(  ); j++ )
        {
            try
            {
                JSONObject definition = definitions.getJSONObject( j );
                exampleOfThisDefinitionList.add( definition.getString( "example" ) );
            } catch ( JSONException jsonEx )
            {
                //skipped, this definition has no example
            }
        }

        return exampleOfThisDefinitionList;
    }

    /**
     * This function transform the list of examples into a String representation. It prepares the list of the examples and turn them into readable list of how to use the word.
     * @param examples
     * @return A string respresentation of the usage of the word
     */
    private String transformExamplesListIntoString( LinkedList<String> examples )
    {
        String returnString = "";

        for ( int k = 0; k < examples.size(  ); k++ )
        {
            returnString += ( "" + ( k + 1 ) + ". " + examples.get( k ) + "\n" );
        }

        return returnString;
    }

    /**
     * This function decides what string to append to the output depending on the length of the examples list
     * @param examples the list of examples in String
     * @return either "are some" or "is an" string to decorate the program output.
     */
    private String plurality( LinkedList<String> examples )
    {
        if ( examples.size(  ) > 1 )
        {
            return "are some";
        } else
        {
            return "is an";
        }
    }

    public static void main( String[] args )
    {
        // this is where you try out with hardcoded url
        DictionaryAPIFetcher dictionaryFetcher =
            new DictionaryAPIFetcher( "https://api.dictionaryapi.dev/api/v2/entries/en/dog" );
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
