package dataStructures;

import java.util.ArrayList;

public class BinaryNode<T> {
	
	private T value;
	
	private BinaryNode<T> left;
	
	private BinaryNode<T> right;
	
	public BinaryNode() {}
	
	public BinaryNode(T value) {
		
		this.value = value;
	}
	
	public BinaryNode(BinaryNode<T> left, BinaryNode<T> right) {
		
		this.left = left;
		
		this.right = right;
	}
	
	public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
		
		this.value = value;
		
		this.left = left;
		
		this.right = right;
	}
	
	public T getValue() {
		
		return this.value;
	}
	
	public void setLeft(BinaryNode<T> newLeftChild) {
		
		this.setLeftChild(newLeftChild);
	}
	
	public void setLeftChild(BinaryNode<T> newLeftChild) {
		
		this.left = newLeftChild;
	}
	
	public boolean hasLeftChild() {
		
		if(this.left == null) {
			
			return false;
			
		} else {
			
			return true;
		}
	}
	
	public boolean hasLeft() {
		
		return this.hasLeftChild();
	}
	
	public BinaryNode<T> getLeftChild() {
		
		return this.left;
	}
	
	public BinaryNode<T> getLeft() {
		
		return this.getLeftChild();
	}
	
	public void setRight(BinaryNode<T> newRightChild) {
		
		this.setRightChild(newRightChild);
	}
	
	public void setRightChild(BinaryNode<T> newRightChild) {
		
		this.right = newRightChild;
	}
	
	public boolean hasRightChild() {
		
		if(this.right == null) {
			
			return false;
			
		} else {
			
			return true;
		}
	}
	
	public boolean hasRight() {
		
		return this.hasRightChild();
	}
	
	public BinaryNode<T> getRightChild() {
		
		return this.right;
	}
	
	public BinaryNode<T> getRight() {
		
		return this.getRightChild();
	}
	
	public int getHeight() {
		
		ArrayList<BinaryNode<T>> thisLevel = new ArrayList<>();
		
		thisLevel.add(this);
		
		int count = 0;
		
		while(thisLevel.size() > 0) {
			
			count++;
			
			ArrayList<BinaryNode<T>> nextLevel = new ArrayList<>();
			
			for(BinaryNode<T> n : thisLevel) {
				
				if(n.getLeftChild() != null) nextLevel.add(n.getLeftChild());
				if(n.getRightChild() != null) nextLevel.add(n.getRightChild());
			}
			
			thisLevel = nextLevel;
		}
		
		return count;
	}
	
	public static int getDepth(BinaryNode node) {
		
		if(node == null) return 0;
		
		int leftHeight = getDepth(node.getLeftChild());
		
		int rightHeight = getDepth(node.getRightChild());
		
		if(leftHeight > rightHeight) return 1 + leftHeight;
		else return 1 + rightHeight;
	}
	
	public static int getHeight(BinaryNode node) {
		
		return getDepth(node) - 1;
	}
	
	
	public String toString() {
		
		StringBuffer ret = new StringBuffer("");
		
		ArrayList<BinaryNode<T>> thisLevel = new ArrayList<>();
		
		thisLevel.add(this);
		
		int count = 0;
		
		ret.append("L" + count + ":  " + this.getValue() + " (root)\n");
		
		while(thisLevel.size() > 0) {
			
			count++;
			
			ArrayList<BinaryNode<T>> nextLevel = new ArrayList<>();
			
			boolean isPrefixSet = false;
			
			for(BinaryNode<T> n : thisLevel) {
				
				if(n.getLeftChild() != null) {
					if(!isPrefixSet) { ret.append("L" + count + ":"); isPrefixSet = true; }
					ret.append("  " + n.getLeftChild().getValue() + "(L" + n.getValue()  + ")");
					nextLevel.add(n.getLeftChild());
				}
				if(n.getRightChild() != null) {
					if(!isPrefixSet) { ret.append("L" + count + ":"); isPrefixSet = true; }
					ret.append("  " + n.getRightChild().getValue() + "(R" + n.getValue()  + ") ");
					nextLevel.add(n.getRightChild());
				}
			}
			ret.append("\n");
			thisLevel = nextLevel;
		}
		
		return ret.toString();
	}
	
	
	/**
	 *  These should only be used for debugging easy of creating visuals:
	 */
	
	private String parentRelation;
	
	public void setParentRelation(String parentRelation) {
		
		this.parentRelation = parentRelation;
	}
	
	public String getParentRelation() {
		
		return this.parentRelation;
	}	
}
