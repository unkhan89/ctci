package dataStructures;

public class Stack<T> {
	
	private T[] elements;
	
	private final int INCREASE_FACTOR = 2;
	
	private int size;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		
		this.elements = (T[]) new Object[INCREASE_FACTOR];
	}
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		
		this.elements = (T[]) new Object[capacity];
		
		this.size = 0;
	}
	
	public int size() {
		
		return this.size;
	}
	
	@SuppressWarnings("unchecked")
	public void push(T newElement) {
		
		this.elements[size] = newElement;
		
		size++;
		
		if(size == this.elements.length) {	// add more capacity
			
			@SuppressWarnings("unchecked")
			T[] newStack = (T[]) new Object[this.elements.length + INCREASE_FACTOR];
			
			for(int i = 0; i < this.elements.length; i++) {
				
				newStack[i] = this.elements[i];
			}
			
			this.elements = newStack;
		}
	}
	
	public T pop() {
		
		if(size == 0) return null;
		
		T ret = this.elements[size-1];
		
		size--;
		
		return ret;
	}
	
	public T peek() {
		
		if(size == 0) return null;
		
		return this.elements[size-1];
	}
}
