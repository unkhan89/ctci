package dataStructures;

import java.util.Iterator;

public class ArrayListIterator<T> implements Iterator<T> {

	private T[] list;
	
	private int index;
	
	public ArrayListIterator(T[] list) {
		
		this.list = list;
		
		this.index = 0;
	}
	
	@Override
	public boolean hasNext() {
		
		if(this.index < list.length - 1) {
			
			return true;
		
		} else {
			
			return false;
		}
	}

	@Override
	public T next() {
		
		T ret = this.list[this.index];
		
		index++;
		
		return ret;
		
	}
}
