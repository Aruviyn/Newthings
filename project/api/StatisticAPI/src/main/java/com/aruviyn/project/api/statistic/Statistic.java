package com.aruviyn.project.api.statistic;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * This class consists of multiple implementation of formulas to calculate the mean, mode, and median.
 * @author Aruviyn
 *
 */

public class Statistic {
	public Statistic() {
		
	}
	/**
	 * This function calculates the mean 
	 * @param inputs is the series of numbers fetched from the user's input. 
	 * @return the output of the mean calculation.
	 */
	public double mean(double[] inputs) {
		double mean = 0;
		
		try {
			double sum = 0;
			for(double input:inputs) {
				sum = sum + input;
			}
			mean = sum/inputs.length;
		}catch(ArithmeticException arithEx) {
			arithEx.printStackTrace();
		}catch(IndexOutOfBoundsException indexEx) {
			indexEx.printStackTrace();
		}
		
		return mean;
	}
	
	/**
	 * This function is to convert the double to a string of array given by the user input.
	 * @param args is an array of command-line arguments for the application.
	 * @return The mean value from the mean calculation function.
	 */
	
	public double mean(String[] args) {
		double[] inputs = Arrays.stream(args).mapToDouble(Double::parseDouble).toArray();
		return mean(inputs);
	}
	
	/**
	 * This function is to convert the double array to string of array 
	 * @param args is an array of command-line arguments for the application.
	 * @return the median value from the median calculation function.
	 */

	public double median(String[] args) {
		double[] inputs = Arrays.stream(args).mapToDouble(Double::parseDouble).toArray();
		return median(inputs);
	}

	/**
	 * This function is to calculate the median
	 * @param inputs is the series of numbers fetched from the user's input. 
	 * @return the output of the median calculation
	 */
	
	public double median(double[] inputs) {
		double mid = 0;
		Arrays.sort(inputs);
		double odd = inputs[inputs.length/2];
		double even = (inputs[inputs.length/2] + inputs[(inputs.length/2)-1])/2;
		if(inputs.length%2!=0) {
			mid = odd;
		}else {
			mid = even;
		}
		return mid;
	}
	
	/**
	 * This function is the getter and setter function for the mode function
	 * The getter gets input from the users
	 * The setter sets input into the variable
	 * @author Aruviyn
	 *
	 */
	
	public class NumberAndOccurence{
		private double value;
		private int occurence;
		
		public NumberAndOccurence(double value,int occurence) {
			this.value = value;
			this.occurence = occurence;
		}
		
		public double getValue() {
			return value;
		}
		public void setValue(double value) {
			this.value = value;
		}
		public int getOccurence() {
			return occurence;
		}
		public void setOccurence(int occurence) {
			this.occurence = occurence;
		}
		
	}
	
	/**
	 * This function is to identify the most occurring number in the series of numbers from the getter and setter function.
	 * @param inputs is the series of numbers fetched from the user's input.
	 * @return the mode result which is the most occurring number in the series of numbers.
	 */

	//input could be 1,3,3,4,4,6
	public LinkedList<Double> mode(double[] inputs) {
		LinkedList<Double> modResult = new LinkedList<Double>();
		
		LinkedList<NumberAndOccurence> numberAndOccurencesList = new LinkedList<Statistic.NumberAndOccurence>();
		
		for(double input:inputs) {
			if(numberAndOccurencesList.size()==0) {
				numberAndOccurencesList.add(new NumberAndOccurence(input,1));
			}else {
				boolean foundSameValue = false;
				for(int i=0;i<numberAndOccurencesList.size();i++) {
					if(numberAndOccurencesList.get(i).getValue() == input) {
						numberAndOccurencesList.get(i).setOccurence(numberAndOccurencesList.get(i).getOccurence()+1);
						foundSameValue = true;
					}
				}
				if(!foundSameValue==true) {
					numberAndOccurencesList.add(new NumberAndOccurence(input,1));
				}
			}
		}
		//printAllNumberAndOccurences(numberAndOccurencesList);
		
		int mostOccurence = findTheMostOccurences(numberAndOccurencesList);
		
		modResult = getValuesWithOccurence(mostOccurence,numberAndOccurencesList);
		
		return modResult;
	}
	
	/**
	 * This function is to inform how many times each number has occurred in a series of number from the getter and setter function. 
	 * @param mostOccurence is the most occurring number in the sequence
	 * @param numberAndOccurencesList is the list of each number with the number of occurring in the series of numbers.
	 * @return the values of each numbers has occurred in the series of number.
	 */
	
	private LinkedList<Double> getValuesWithOccurence(int mostOccurence, LinkedList<NumberAndOccurence> numberAndOccurencesList) {
		LinkedList<Double> values = new LinkedList<Double>();
		
		for(NumberAndOccurence numberAndOccurence:numberAndOccurencesList) {
			if(numberAndOccurence.getOccurence() == mostOccurence) {
				values.add(numberAndOccurence.getValue());
			}
		}
		
		return values;
	}
	
	/**
	 * This function searches for the most occurring number in a series of numbers given by user input from the getter and setter function.
	 * @param numberAndOccurencesList This is the number and occurrences list from the get value with occurrence function.
	 * @return the most occurring number in the series of number. 
	 */

	private int findTheMostOccurences(LinkedList<NumberAndOccurence> numberAndOccurencesList) {
		int mostOccurence = 0;
		for(NumberAndOccurence numberAndOccurence:numberAndOccurencesList) {
			if(mostOccurence<numberAndOccurence.getOccurence()) {
				mostOccurence = numberAndOccurence.getOccurence();
			}
		}
		return mostOccurence;
	}
	
	/**
	 * This function prints the series of number input by the user from the getter and setter function.
	 * and also prints the number of times each number has occurred in the series.
	 * @param numberAndOccurencesList This is the number and occurrences list from the get value with occurrence function.
	 */

	private void printAllNumberAndOccurences(LinkedList<NumberAndOccurence> numberAndOccurencesList) {
		for(NumberAndOccurence numberAndOccurences:numberAndOccurencesList) {
			System.out.println(numberAndOccurences.getValue()+" occur "+numberAndOccurences.getOccurence());
		}	
	}
	
	/**
	 * This function converts the linked list into string of array.
	 * @param args is an array of command-line arguments for the application.
	 * @return mode value from the mode function.
	 */

	public LinkedList<Double> mode(String[] args){
		double[] inputs = Arrays.stream(args).mapToDouble(Double::parseDouble).toArray();
		return mode(inputs);
	}
	
	/**
	 * This function is to test the calculation by debugging on eclipse.
	 * @param args is the input from the debug configuration arguments set manually on eclipse. 
	 */

	public static void main(String args[]) {
		Statistic statistic = new Statistic();
		//System.out.println("Mean: "+statistic.mean(args));
		System.out.println("Median: "+statistic.median(args));
	}
}
