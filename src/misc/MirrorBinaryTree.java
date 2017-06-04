package misc;

import dataStructures.*;

public class MirrorBinaryTree {

	public static void main(String[] args) {
		
		/*
		 * Given a binary tree, return a new one with left and right subtrees swapped.
		 */
		
		
		BinaryNode<Integer> root = new BinaryNode<>(5);
		
		root.setLeftChild(new BinaryNode<Integer>(3));
		root.getLeftChild().setLeftChild(new BinaryNode<Integer>(1));
		root.getLeftChild().setRightChild(new BinaryNode<Integer>(4));
		
		root.setRightChild(new BinaryNode<Integer>(9));
		root.getRightChild().setLeftChild(new BinaryNode<Integer>(6));
		root.getRightChild().setRightChild(new BinaryNode<Integer>(10));
		
		System.out.println("Before: " + root.toString());
		
		BinaryNode mirrored = mirror(root);
		
		System.out.println("After: " + mirrored.toString());		
	}
	
	public static BinaryNode mirror(BinaryNode root) {
		
		BinaryNode mirrored = new BinaryNode(root.getValue());
		
		doMirroring(root, mirrored);
		
		return mirrored;
	}
	
	private static void doMirroring(BinaryNode original, BinaryNode mirrored) {
		
		if(original.getLeftChild() != null) {
			
			mirrored.setRightChild(new BinaryNode(original.getLeftChild().getValue()));
			
			doMirroring(original.getLeftChild(), mirrored.getRightChild());
		}
		
		if(original.getRightChild() != null) {
			
			mirrored.setLeftChild(new BinaryNode(original.getRightChild().getValue()));
			
			doMirroring(original.getRightChild(), mirrored.getLeftChild());
		}
	}

}
