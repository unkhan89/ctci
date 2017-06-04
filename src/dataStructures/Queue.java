package dataStructures;

import java.util.ArrayList;

public class Queue<T> {
	
	private ArrayList<T> queue;
	
	public Queue() {
		
		queue = new ArrayList<T>();
	}
	
	public void enqueue(T obj) {
		
		queue.add(obj);
	}
	
	public T dequeue() {
		
		if(queue.size() == 0) return null;
		
		T ret = queue.get(0);
		
		// shift everything over:
		
		for(int i = 1; i <= queue.size() - 1; i++) {
			
			queue.set(i-1, queue.get(i));
		}
		
		queue.remove(queue.size() - 1);
			
		return ret;
	}
	
	public int size() {
		
		return queue.size();
	}
	
	public String toString() {
		
		return this.queue.toString();
	}
}
