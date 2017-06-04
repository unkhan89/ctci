package ctci.ch4TreesAndGraphs;

import dataStructures.*;

public class P3 {

	public static void main(String[] args) {
		
		/*
		 * Given a sorted (ascending) array of integers, write a method that 
		 * creates a binary search tree with minimal height.
		 */
		
		int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		BinaryNode<Integer> binarySearchTree = generateMinHeightBST(numbers);
		
		System.out.println("Height: " + binarySearchTree.getHeight());
		System.out.println(binarySearchTree.toString());
		
	}
	
	
	public static BinaryNode<Integer> generateMinHeightBST(int[] numbers) {
		
		if(numbers.length == 0) return null;
		
		if(numbers.length == 1) return new BinaryNode<Integer>(numbers[0]);
		
		int rootIndex = (0 + numbers.length - 1) / 2;
		
		BinaryNode<Integer> root = new BinaryNode<>(numbers[rootIndex]);
		
		generateMinTree(root, rootIndex, numbers, 0, numbers.length-1);
		
		return root;
	}
	
	static void generateMinTree(BinaryNode<Integer> parent, int parentIndex, int[] numbers, int startIndex, int endIndex) {
		
		if(startIndex == endIndex) return;
		
		int leftChildIndex = (startIndex + parentIndex - 1) / 2;
		
//		if(leftChildIndex < startIndex || leftChildIndex >= parentIndex) return; // prevents right child logic from executing	
		
		if(startIndex <= leftChildIndex && leftChildIndex <= (parentIndex-1)) {
		
			parent.setLeftChild(new BinaryNode<Integer>(numbers[leftChildIndex]));
		
			generateMinTree(parent.getLeftChild(), leftChildIndex, numbers, startIndex, parentIndex - 1);
		}
		
		int rightChildIndex = (parentIndex + 1 + endIndex) / 2;
		
		// TODO: any need for safety check index is in range? 
		
		parent.setRightChild(new BinaryNode<Integer>(numbers[rightChildIndex]));
		
		generateMinTree(parent.getRightChild(), rightChildIndex, numbers, parentIndex + 1, endIndex);
	}
	
	
	
//	private static void generateMinTree(BinaryNode<Integer> parent, int parentIndex, boolean[] visited, int[] numbers, int startIndex, int endIndex) {
//		
//		if(startIndex == parentIndex && parentIndex == endIndex)  {
//			
//			return;
//		
//		} else if(startIndex == parentIndex && parentIndex + 1 == endIndex && visited[endIndex] == false) {
//			
//			parent.setRightChild(new BinaryNode<Integer>(numbers[endIndex]));
//			visited[endIndex] = true;
//		
//		} else if(parentIndex == endIndex && parentIndex - 1 == startIndex && visited[startIndex] == false) {
//			
//			parent.setLeftChild(new BinaryNode<Integer>(numbers[startIndex]));
//			visited[startIndex] = true;
//		
//		} else if(startIndex + 1 == parentIndex && parentIndex + 1 == endIndex) {
//			
//			if(visited[startIndex] == false) {
//				parent.setLeftChild(new BinaryNode<Integer>(numbers[startIndex]));
//				visited[startIndex] = true;
//			}
//			if(visited[endIndex] == false) {
//				parent.setRightChild(new BinaryNode<Integer>(numbers[endIndex]));
//				visited[endIndex] = true;
//			}
//		
//		} else {
//		
//			int leftChildIndex = getMid(startIndex, parentIndex);
//			
//			if(leftChildIndex > -1 && visited[leftChildIndex] == false) {
//				
//				visited[leftChildIndex] = true;
//				
//				parent.setLeftChild(new BinaryNode<Integer>(numbers[leftChildIndex]));
//				
//				generateMinTree(parent.getLeftChild(), leftChildIndex, visited, numbers, startIndex, parentIndex);				
//			}
//		
//			int rightChildIndex = getMid(parentIndex, endIndex);
//			
//			if(rightChildIndex < numbers.length && visited[rightChildIndex] == false) {
//				
//				visited[rightChildIndex] = true;
//				
//				parent.setRightChild(new BinaryNode<Integer>(numbers[rightChildIndex]));
//			
//				generateMinTree(parent.getRightChild(), rightChildIndex, visited, numbers, parentIndex, endIndex);
//			}
//		}
//	}
	
	
//	private static void generateMinTree(BinaryNode<Integer> parent, boolean[] visited, int[] numbers, int startIndex, int endIndex) {
//		
//		int parentIndex = getMid(startIndex, endIndex);
//		
//		if(startIndex == parentIndex || parentIndex == endIndex) return;
//		
//		if(startIndex + 1 == parentIndex && parentIndex + 1 == endIndex) {
//			
//			// check left and right children are set:
//			
//			if(visited[startIndex] == false) {
//				
//				parent.setLeftChild(new BinaryNode<Integer>(numbers[startIndex]));
//				visited[startIndex] = true;
//			}
//			
//			if(visited[endIndex] == false) {
//				parent.setRightChild(new BinaryNode<Integer>(numbers[endIndex]));
//				visited[endIndex] = true;
//			}
//			
//			return;
//		}
//		
//		int leftChildIndex = getMid(startIndex, parentIndex);
//		
//		if(leftChildIndex > -1) {
//			
//			parent.setLeftChild(new BinaryNode<Integer>(numbers[leftChildIndex]));
//			
//			visited[leftChildIndex] = true;
//			
//			generateMinTree(parent.getLeftChild(), visited, numbers, startIndex, parentIndex);
//		}
//		
//		int rightChildIndex = getMid(parentIndex, endIndex);
//		
//		if(rightChildIndex < numbers.length) {
//			
//			parent.setRightChild(new BinaryNode<Integer>(numbers[rightChildIndex]));
//			
//			visited[rightChildIndex] = true;
//			
//			generateMinTree(parent.getRightChild(), visited, numbers, parentIndex, endIndex);
//		}
//	}
	
	
	
//	private static void generateMinTree(BinaryNode<Integer> parent, int[] numbers, int startIndex, int endIndex) {
//		
//		if(parent == null || startIndex > endIndex || startIndex < 0 || endIndex > numbers.length - 1) return;
//		
//		if(startIndex == endIndex) {	// only 1 numbers remaining to set as children
//			
//			if(parent.getValue() >= numbers[startIndex]) parent.setLeftChild(new BinaryNode<Integer>(numbers[startIndex]));
//			else parent.setRightChild(new BinaryNode<Integer>(numbers[startIndex]));
//		
//		} else if(endIndex - 1 == startIndex) {	// only 2 numbers remaining to set as children
//			
//			parent.setLeftChild(new BinaryNode<Integer>(numbers[startIndex]));
//			parent.setRightChild(new BinaryNode<Integer>(numbers[endIndex]));
//		
//		} else {
//			
//			int parentIndex = getMid(startIndex, endIndex);
//			
//			// set left mid point as left child:
//			
//			int leftMidIndex = getMid(startIndex, parentIndex);
//			
//			parent.setLeftChild(new BinaryNode<Integer>(numbers[leftMidIndex]));
//			
//			// recurse on left and right halves or left mid:
//			
//			generateMinTree(parent.getLeftChild(), numbers, startIndex, parentIndex);
////			generateMinTree(parent.getLeftChild(), numbers, startIndex, leftMidIndex - 1);
////			generateMinTree(parent.getLeftChild(), numbers, leftMidIndex + 1, parentIndex - 1);
//			
//			// set right mid point as right child:
//			
//			int rightMidIndex = getMid(parentIndex, endIndex);
//			
//			parent.setRightChild(new BinaryNode<Integer>(numbers[rightMidIndex]));
//			
//			// recurse on left and right halves or right mid:
//			
//			generateMinTree(parent.getRightChild(), numbers, parentIndex, endIndex);
////			generateMinTree(parent.getRightChild(), numbers, parentIndex + 1, rightMidIndex - 1);
////			generateMinTree(parent.getLeftChild(), numbers, rightMidIndex + 1, endIndex);
//		
//		}		
//	}
	
	public static int getMid(int x, int y) {
		
		return x + y / 2;
	}
}
