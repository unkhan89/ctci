package dataStructures;

public class SinglyLinkedList<T> {
	
	private SinglyLinkedList<T> next;
	
	private T value;
	
	public SinglyLinkedList() {}
	
	public SinglyLinkedList(T value) {
		
		this.value = value;
	}
	
	public int size() {
		
		int size = 1;
		
		SinglyLinkedList temp = this;
		
		while(temp.hasNext()) {
			
			size++;
			
			temp = temp.getNext();
		}
		
		return size;
	}
	
	public boolean hasNext() {
		
		if(next != null) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
	
	public SinglyLinkedList<T> getNext() {
		
		return this.next;
	}
	
	public void setNext(SinglyLinkedList<T> newNext) {
		
		this.next = newNext;
	}
	
	public T getValue() {
		
		return this.value;
	}
	
	public void setValue(T value) {
		
		this.value = value;
	}
	
	public void add(T value) {
		
		SinglyLinkedList temp = this;
		
		while(temp.hasNext()) {
			
			temp = temp.getNext();
		}
		
		temp.setNext(new SinglyLinkedList(value));
	}
	
	public SinglyLinkedList get(int index) {
		
		if(index < 0)
			throw new Error("Index out of bounds: " + index);
		
		SinglyLinkedList temp = this;
		
		while(temp.hasNext()) {
			
			if(index == 0) {
				
				return temp;
				
			} else {
				
				temp = temp.getNext();
				
				index--;
			}
		}
		
		throw new Error("Index out of bounds: " + index);
	}
	
	public String toString() {
		
		StringBuffer ret = new StringBuffer(this.getValue().toString());
		
		SinglyLinkedList n = this;
		
		while(n.getNext() != null) {
			
			ret.append(" -> ");
			
			ret.append(n.getNext().getValue());
			
			n = n.getNext();
		}
		
		return ret.toString();
	}
	
	public static int[] toIntArray(SinglyLinkedList<Integer> list) {
		
		if(list == null) return null;
		
		// count number of item to init array:
		
		int count = 1;
		
		SinglyLinkedList<Integer> temp = list;
		
		while(temp.hasNext()) {
			
			count++;	// count next one
			
			temp = temp.getNext();			
		}
		
		temp = list;	// reset and re-use
		
		int[] ret = new int[count];
		
		for(int i = 0; i < count; i++) {
			
			ret[i] = (int) temp.getValue().intValue();
			
			temp = temp.getNext();
		}
		
		return ret;
	}
	
	public static SinglyLinkedList<Integer> buildSinglyLinkedList(int[] values) {
		
		SinglyLinkedList<Integer> ret = new SinglyLinkedList<Integer>(values[0]);
		
		SinglyLinkedList<Integer> pointer = ret;
		
		for(int i = 1; i < values.length; i++) {
			
			pointer.setNext(new SinglyLinkedList<Integer>(values[i]));
			
			pointer = pointer.getNext();
		}
		
		return ret; 
	}
	
	public static SinglyLinkedList<String> buildSinglyLinkedList(String[] values) {
		
		SinglyLinkedList<String> ret = new SinglyLinkedList<String>(values[0]);
		
		SinglyLinkedList<String> pointer = ret;
		
		for(int i = 1; i < values.length; i++) {
			
			pointer.setNext(new SinglyLinkedList<String>(values[i]));
			
			pointer = pointer.getNext();
		}
		
		return ret; 
	}
}
