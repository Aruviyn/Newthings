package com.aruviyn.project.lingo.fetcher;

import java.io.IOException;

public interface Fetcher {
	
	public String fetch() throws IOException;
	
	public String processResponse(String originalResponse);
	
	public String getSource();

}
