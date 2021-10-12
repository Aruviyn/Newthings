package com.aruviyn.project.lingo.fetcher;

import java.io.IOException;

/**
 * The interface here will be serving as a template for implementing any type of
 * Fetcher classes. May it be fetching information from api, files or databases.
 * @author fazreil
 *
 */
public interface Fetcher
{
    /**
     * The fetch function executes the data fetching. With respect to its implementation and setup, the fetch function will open up connection and perform the fetch.
     * @return This function return the data as a String.
     * @throws IOException The function throws this exception if there are problems in the IO of fetching process.
     * @author fazreil
     */
	public String fetch(  )
                 throws IOException;

	/**
	 * This function massages the data from fetch function into more meaningful information.
	 * @param originalResponse original response string obtained from fetch function
	 * @return This function return the massaged information as a String.
	 * @author fazreil
	 */
    public String processResponse( String originalResponse );

    /**
     * This function returns the source of the fetch, where it connects to. It could be url path, file path, database connection string.
     * @return This function return the path of the source in string.
     * @author fazreil
     */
    public String getSource(  );
}
