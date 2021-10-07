package com.aruviyn.project.lingo.fetcher.impl;

import com.aruviyn.project.lingo.fetcher.Fetcher;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * This function implements the Fetcher interface as a medium to fetch data from API. It setups the building blocks for classes that fetch from API.
 * @author fazreil
 *
 */
public class APIFetcher
    implements Fetcher
{
	/**
	 * sourceUrl is the variable that stores the URL of the source
	 */
	protected String sourceUrl;

	/**
	 * This is the constructor that accepts the URL of the API to be set to the sourceUrl
	 * @param sourceUrl String of the URL of the source
	 * @author fazreil
	 */
	public APIFetcher( String sourceUrl )
    {
        this.sourceUrl = sourceUrl;
    }

    /**
     * The fetch function will get the data from the sourceUrl and return the response as a string 
     * @throws IOException This function throws IOExceptions for handling IO request when connecting to the sourceURL
     */
	public String fetch(  )
                 throws IOException
    {
        Response response;
        OkHttpClient client = new OkHttpClient(  ).newBuilder(  ).build(  );
        Request request = new Request.Builder(  ).url( sourceUrl ).method( "GET", null ).build(  );
        response = client.newCall( request ).execute(  );

        return ( response.body(  ).string(  ) );
    }

	/**
	 * The processResponse here is up for extension. The processResponse here is just piping the originalResponse to its return value.
	 * @param originalResponse original response string obtained from fetch function
	 * @throws IndexOutOfBoundsException if the response is in array and we did not carefully iterate through it
	 * @author fazreil
	 */
    public String processResponse( String originalResponse )
                           throws IndexOutOfBoundsException
    {
        String processedResponse = originalResponse;

        return processedResponse;
    }

    /**
     * This function returns the source of the fetch, where it connects to. It could be url path, file path, database connection string.
     * @return This function return the path of the source in string.
     * @author fazreil
     */
    public String getSource(  )
    {
        return sourceUrl;
    }
}
