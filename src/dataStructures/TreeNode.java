package dataStructures;

import java.util.ArrayList;

public class TreeNode<T> {
	
	private T value;
	
	private ArrayList<TreeNode> children;
	
	public TreeNode() {
		
		this.children = new ArrayList<TreeNode>();
	}
	
	public TreeNode(T value) {
		
		this.value = value;
		
		this.children = new ArrayList<TreeNode>();
	}
	
	public T getValue() {
		
		return this.value;
	}
	
	public void setValue(T newValue) {
		
		this.value = newValue;
	}
	
	public ArrayList<TreeNode> getChildren() {
		
		return this.children;
	}
	
	public void removeChildren() {
		
		this.children = new ArrayList<TreeNode>();
	}
	
	public int getNumberOfChildren(){
		
		return this.children.size();
	}
	
	public TreeNode getChild(int index) {
		
		return this.children.get(index);
	}
	
	public T[] getChildrenValues() {
		
		T[] childrenValues = (T[]) new Object[this.children.size()];
		
		for(int i = 0; i < this.children.size(); i++) {
			
			childrenValues[i] = (T) this.children.get(i).getValue();
		}
		
		return childrenValues;
	}
	
	public void addChild(TreeNode child) {
		
		this.children.add(child);
	}
	
	public void addChild(T childValue) {
		
		this.children.add(new TreeNode<T>(childValue));
	}
	
	public void removeChild(int index) {
		
		this.children.remove(index);
	}
	
	public String toString() {
		
		StringBuffer ret = new StringBuffer("");
		
		ArrayList<TreeNode<T>> thisLevel = new ArrayList<>();
		
		thisLevel.add(this);
		
		int count = 0;
		
		ret.append("L" + count + ":  " + this.getValue() + " (root)\n");
		
		while(thisLevel.size() > 0) {
			
			count++;
			
			ArrayList<TreeNode<T>> nextLevel = new ArrayList<>();
			
			boolean isPrefixSet = false;
			
			for(TreeNode<T> n : thisLevel) {
				
				if(n.getNumberOfChildren() > 0) {
					
					if(!isPrefixSet) { ret.append("L" + count + ":"); isPrefixSet = true; }
					
					for(TreeNode<T> child : n.getChildren()) {
						
						ret.append(" " + child.getValue() + "(P" + n.getValue() + ")");
						nextLevel.add(child);
					}
				}
			}
			ret.append("\n");
			thisLevel = nextLevel;
		}
		
		return ret.toString();
	}
}
