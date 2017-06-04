package dataStructures;

public class BinaryNodeDirect {
	
	public Object data;
	public Object left;
	public Object right;
	
	public BinaryNodeDirect(Object data, Object left, Object right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		
		return "Data: " + this.data.toString() + "\nLeft: " + this.left.toString() + "\nRight: " + this.right.toString();
	}
}
