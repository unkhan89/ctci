package ctci.ch4TreesAndGraphs;

import dataStructures.*;

public class P9 {

	public static void main(String[] args) {
		
		/*
		 * You are given a binary tree in which each node contains a value. Write a method
		 * that prints all paths that sum to a given value. The path does not need to start or 
		 * end at the root or a leaf, but it must go down in a straight line. 
		 * 
		 */
	}
	
	public static void printPaths(BinaryNode<Integer> n, int sum) {
		
		
	}
	
	private static void findPaths(BinaryNode<Integer> n, int sum, int runningSum, ArrayList<Integer> path) {
		
		if(n == null) return;
		
		if(n.getValue() + runningSum == sum) {
			
			runningSum += n.getValue();
			path.add(n.getValue());
			System.out.println(path);
			
			runningSum -= path.get(0);
			path.remove(0);
			
			findPaths(n.getLeftChild(), sum, runningSum, path);
			findPaths(n.getRightChild(), sum, runningSum, path);
		
		} else if(n.getValue() + runningSum < sum) {
			
			runningSum += n.getValue();
			path.add(n.getValue());
			findPaths(n.getLeftChild(), sum, runningSum, path);
			findPaths(n.getRightChild(), sum, runningSum, path);
			
		} else if(n.getValue() + runningSum > sum) {
			
			if(runningSum - path.get(0) == sum) {	// check if removing 
				
				
			}
			
		}
		
	}

}
