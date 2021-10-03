package com.aruviyn.project.lingo.fetcher.impl;

import com.aruviyn.project.lingo.fetcher.Fetcher;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class APIFetcher
    implements Fetcher
{
    protected String sourceUrl;

    public APIFetcher( String sourceUrl )
    {
        this.sourceUrl = sourceUrl;
    }

    public String fetch(  )
                 throws IOException
    {
        Response response;
        OkHttpClient client = new OkHttpClient(  ).newBuilder(  ).build(  );
        Request request = new Request.Builder(  ).url( sourceUrl ).method( "GET", null ).build(  );
        response = client.newCall( request ).execute(  );

        return ( response.body(  ).string(  ) );
    }

    public String processResponse( String originalResponse )
                           throws IndexOutOfBoundsException
    {
        String processedResponse = originalResponse;

        return processedResponse;
    }

    public String getSource(  )
    {
        return sourceUrl;
    }
}
