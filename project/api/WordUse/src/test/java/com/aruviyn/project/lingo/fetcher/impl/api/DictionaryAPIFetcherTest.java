package com.aruviyn.project.lingo.fetcher.impl.api;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.aruviyn.project.lingo.fetcher.Fetcher;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryAPIFetcherTest extends TestCase {

	@Mock
	Fetcher fetcher;
	
	@InjectMocks
	DictionaryAPIFetcher dictionaryAPIFetcher;
	
	String expectedResult = "Here are some sample on how to use the word dog:\n"
			+ "1. he was interrupted by cries of ‘dirty dog!’\n"
			+ "2. photographers seemed to dog her every step\n"
			+ "3. Eric had a reputation for dogging it a little\n"
			+ "4. she has dogged the door shut\n"
			+ "";
	static String jsonContent;
	static File sampleFetchedJsonFile = new File(DictionaryAPIFetcher.class.getClassLoader().getResource("fetchedJson.json").getFile());
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		jsonContent = readContent(sampleFetchedJsonFile);
	}
	
	private static String readContent(File file) throws IOException {
		return new String(Files.readAllBytes(Paths.get(file.getPath())));
	}
	
	@Test
	public void testProcessResponse() throws IOException {
		when(fetcher.fetch()).thenReturn(jsonContent);
		String response = dictionaryAPIFetcher.processResponse(fetcher.fetch());
		assertEquals(expectedResult, response);
	}

	@Test
	public void testDictionaryAPIFetcher() {
		DictionaryAPIFetcher dictionaryAPIFetcher = new DictionaryAPIFetcher("test");
		assertNotNull(dictionaryAPIFetcher);
	}

	@Test
	public void testAPIFetcher() throws IOException {
		when(fetcher.fetch()).thenReturn(jsonContent);
		boolean successful = true;
		try {
			new JSONArray(fetcher.fetch());
		}catch(Exception ex) {
			successful = false;
		}
		assertTrue(successful);
	}

}
