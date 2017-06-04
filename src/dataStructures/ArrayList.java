package dataStructures;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {

    private T[] list;
    
    private int size = 0;
    
    private final int INCREASE_FACTOR = 10;
    		
    @SuppressWarnings("unchecked")
	public ArrayList() {
    	
    	list = (T[]) new Object[INCREASE_FACTOR];
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList(int size) {
    	
    	list = (T[]) new Object[size];
    }
    
    public int size() {
    	
    	return this.size;
    }

    public T get(int index) {
    	
    	if(index < 0 || this.size - 1 < index) 
    		throw new Error("Index out of bounds: " + index + " of range [0," + (this.size-1) + "]");

        return this.list[index];
    }
    
    public void set(int index, T newValue) {
    	
    	if(index < 0 || this.size - 1 < index) 
    		throw new Error("Index out of bounds: " + index + " of range 0-" + (this.size-1));
    	
    	list[index] = newValue;    	
    }
    
    public void add(T newValue) {
    	
    	if(this.size == this.list.length) {
    		
    		@SuppressWarnings("unchecked")
			T[] newList = (T[]) new Object[this.list.length + this.INCREASE_FACTOR];
    		
    		for(int i = 0; i < this.list.length; i++) {
    			
    			newList[i] = this.list[i];
    		}
    		
    		this.list = newList;
    	}
    	
    	this.list[size] = newValue;
    	
    	this.size++;
    }
    
    public void remove() {
    	
    	if(this.size == 0) return;
    	
    	this.list[size - 1] = null;
    	
    	size--;
    }
    
    public void remove(int index) {
    	
    	if(this.size == 0) return;
    	
    	if(index < 0 || index >= size) throw new Error("Index out of bounds [0 " + (size-1) + ": " + index);
    	
    	for(int i = index; i < size - 2; i++) {
    		
    		list[i] = list[i+1];
    	}
    	
    	list[size - 1] = null;
    	
    	size--;
    }

    public int indexOf(T n) {

        for(int i = 0; i < this.list.length; i++) {

            if(this.list[i] == n) {

                return i;
            }
        }

        return -1;
    }
    
    public String toString() {
    	
    	String ret = "[";
    	
    	for(int i = 0; i < this.size; i++) {
    		
    		ret += this.list[i].toString();
    		
    		if(i != size - 1) {
    			
    			ret += ", ";
    		}
    	}
    	
    	return ret + "]";
    }

	@Override
	public Iterator<T> iterator() {
		
		return new ArrayListIterator<T>(list);
	}
}
