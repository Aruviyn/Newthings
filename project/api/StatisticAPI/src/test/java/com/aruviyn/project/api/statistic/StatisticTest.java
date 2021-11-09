package com.aruviyn.project.api.statistic;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

import org.junit.Test;

public class StatisticTest extends TestCase {

	Statistic statistic;
	
	protected void setUp() throws Exception {
		super.setUp();
		statistic = new Statistic();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testMeanDoubleArray() {
		double[] input = {2,5,4};
		assertEquals(3.666, statistic.mean(input),2);
	}

	@Test
	public void testMeanStringArray() {
		String[] input = {"2","3","4"};
		assertEquals(3.0, statistic.mean(input),2);
	}

	@Test
	public void testMedianStringArray() {
		double[] input = {11, 15, 13};
		assertEquals(13.0,statistic.median(input),2);
	}

	@Test
	public void testMedianDoubleArray() {
		String[] input = {"11","15","13"};
		assertEquals(13.0,statistic.median(input),2);
	}

	private Double[] populateDoubleArray(LinkedList<Double> actualList) {
		Double actual[] = new Double[actualList.size()];
		for(int a=0;a<actualList.size();a++) {
			actual[a]=actualList.get(a);
		}
		return actual;
	}
	
	@Test
	public void testModeDoubleArray() {
		double[] input = {1,3,3,5,2,7,4};
		double[] expected = {3.0};
		double[] actual = Stream.of(populateDoubleArray(statistic.mode(input)))
				.mapToDouble(Double::doubleValue)
				.toArray();
		assertArrayEquals(expected, actual, 0);
	}

	@Test
	public void testModeStringArray() {
		String[] input = {"1","3","3","5","2","7","4"};
		double[] expected = {3.0};
		double[] actual = Stream.of(populateDoubleArray(statistic.mode(input)))
				.mapToDouble(Double::doubleValue)
				.toArray();
		assertArrayEquals(expected, actual, 0);
	}
	
	@Test
	public void testModeDoubleArrayWithMultipleModes() {
		double[] input = {1,3,3,5,2,7,7,4};
		double[] expected = {3.0,7.0};
		double[] actual = Stream.of(populateDoubleArray(statistic.mode(input)))
				.mapToDouble(Double::doubleValue)
				.toArray();
		assertArrayEquals(expected, actual, 0);		
	}

	@Test
	public void testModeStringArrayWithMultipleModes() {
		String[] input = {"1","3","3","5","2","7","7","4"};
		double[] expected = {3.0,7.0};
		double[] actual = Stream.of(populateDoubleArray(statistic.mode(input)))
				.mapToDouble(Double::doubleValue)
				.toArray();
		assertArrayEquals(expected, actual, 0);	
	}
}
