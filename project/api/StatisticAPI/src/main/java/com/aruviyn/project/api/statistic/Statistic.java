package com.aruviyn.project.api.statistic;

import java.util.Arrays;
import java.util.LinkedList;

class Statistic {
	public Statistic() {
		
	}
	
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
	
	public double mean(String[] args) {
		double[] inputs = Arrays.stream(args).mapToDouble(Double::parseDouble).toArray();
		return mean(inputs);
	}
	
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
	
	private LinkedList<Double> getValuesWithOccurence(int mostOccurence, LinkedList<NumberAndOccurence> numberAndOccurencesList) {
		LinkedList<Double> values = new LinkedList<Double>();
		
		for(NumberAndOccurence numberAndOccurence:numberAndOccurencesList) {
			if(numberAndOccurence.getOccurence() == mostOccurence) {
				values.add(numberAndOccurence.getValue());
			}
		}
		
		return values;
	}

	private int findTheMostOccurences(LinkedList<NumberAndOccurence> numberAndOccurencesList) {
		int mostOccurence = 0;
		for(NumberAndOccurence numberAndOccurence:numberAndOccurencesList) {
			if(mostOccurence<numberAndOccurence.getOccurence()) {
				mostOccurence = numberAndOccurence.getOccurence();
			}
		}
		return mostOccurence;
	}

	private void printAllNumberAndOccurences(LinkedList<NumberAndOccurence> numberAndOccurencesList) {
		for(NumberAndOccurence numberAndOccurences:numberAndOccurencesList) {
			System.out.println(numberAndOccurences.getValue()+" occur "+numberAndOccurences.getOccurence());
		}	
	}

	public LinkedList<Double> mode(String[] args){
		double[] inputs = Arrays.stream(args).mapToDouble(Double::parseDouble).toArray();
		return mode(inputs);
	}

	public static void main(String args[]) {
		Statistic statistic = new Statistic();
		//System.out.println("Mean: "+statistic.mean(args));
		System.out.println("Mode: "+statistic.mode(args).toString());
	}
}
