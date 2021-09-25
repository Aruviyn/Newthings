package com.aruviyn.project.api.statistic;

import java.util.Arrays;

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

	public static void main(String args[]) {
		Statistic statistic = new Statistic();
		System.out.println("Mean: "+statistic.mean(args));
	}
}
