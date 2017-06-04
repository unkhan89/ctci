package ctci.ch4TreesAndGraphs;

import java.util.*;
import dataStructures.BinaryNode;

public class P1 {

	public static void main(String[] args) {
		
		/*
		 * Write function that checks if a binary tree is balanced, where a balanced tree is defined to
		 * be a tree such that the heights of the two sub trees of any node never differ by more that one.
		 */
		
		BinaryNode root = new BinaryNode();
		root.setLeftChild(new BinaryNode());
		root.getLeftChild().setLeftChild(new BinaryNode());
		root.getLeftChild().getLeftChild().setLeftChild(new BinaryNode());
		
//		root.setRightChild(new BinaryNode());
		
		System.out.println("Is balanced? " + isBalanced(root));
		
	}
	
	static boolean isBalanced(BinaryNode n) {
		
		HashSet<Integer> distances = new HashSet<Integer>();
		
		populateLeafDistances(n, distances, 0);
		
		if(distances.size() > 2) {
			
			return false;
			
		} else if(distances.size() == 0 || distances.size() == 1) {
			
			return true;
		
		} else {
			
			Object[] d = distances.toArray();
			
			int d1 = (int) d[0];
			int d2 = (int) d[1];
			
			if(d1 + 1 == d2 || d1 - 1 == d2) return true;
			else return false;
			
		}
	}
	
	static void populateLeafDistances(BinaryNode n, Set s, int distance) {
		
		if(n == null) return;
		
		populateLeafDistances(n.getLeftChild(), s, distance + 1);
		
		populateLeafDistances(n.getRightChild(), s, distance + 1);
		
		if(n.getLeftChild() == null && n.getRightChild() == null) {
			
			s.add(distance);
		}
	}

}
