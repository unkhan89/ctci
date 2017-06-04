package ctci.ch4TreesAndGraphs;

import dataStructures.*;


public class P5 {

	public static void main(String[] args) {
		
		/*
		 * Write a method to check if a binary tree is a binary search tree.
		 */
		
		BinaryNode<Integer> root = new BinaryNode<>(5);
		
		root.setLeftChild(new BinaryNode<Integer>(3));
		root.getLeftChild().setLeftChild(new BinaryNode<Integer>(1));
		root.getLeftChild().setRightChild(new BinaryNode<Integer>(4));
		
		root.setRightChild(new BinaryNode<Integer>(9));
		root.getRightChild().setLeftChild(new BinaryNode<Integer>(6));
		root.getRightChild().setRightChild(new BinaryNode<Integer>(10));
		
		
		System.out.println("Is BST? " + isBST2(root));

	}
	
	// In-order traverse while checking values:
	//
	public static boolean isBST2(BinaryNode<Integer> node) {
		
		java.util.ArrayList<Integer> values = new java.util.ArrayList<>();
		
		return inOrder(node, values);
		
	}
	
	private static boolean inOrder(BinaryNode<Integer> node, java.util.ArrayList<Integer> values) {
		
		if(node == null) return true;
		
		boolean leftResult = inOrder(node.getLeftChild(), values);
		
		boolean compareResult = true;
		
		if(values.size() == 0) {
			
			values.add(node.getValue());
		
		} else if (node.getValue() > values.get(values.size()-1)) {
			
			values.add(node.getValue());
		
		} else {
			
			compareResult = false;
		}
		
		return leftResult && compareResult && inOrder(node.getRight(), values);
	}
	
	
	
	// Needs a way to know which side of grand parent child is at
	//
//	public static boolean isBST1(BinaryNode<Integer> parent, BinaryNode<Integer> grandParent) {
//		
//		if(parent == null) return true;
//		
//		if(parent.getLeftChild() != null && 
//				(parent.getLeftChild().getValue() >= parent.getValue() || (grandParent != null && parent.getLeftChild().getValue() >= grandParent.getValue()))) {
//			
//			return false;
//		}
//		
//		if(parent.getRightChild() != null && 
//				(parent.getRightChild().getValue() < parent.getValue() || (grandParent != null && parent.getRightChild().getValue() < grandParent.getValue()))) {
//			
//			return false;
//		
//		}
//		
//		return isBST1(parent.getLeftChild(), parent) && isBST1(parent.getRightChild(), parent);	
//	}
}



