package dataStructures;

public class HashMap<V> {
	
	private SinglyLinkedList[] keyValuePairs;
	
	private int capacity = 10;
	
	public HashMap() {
		
		this.keyValuePairs = new SinglyLinkedList[capacity];
	}
	
	public HashMap(int capacity) {
		
		if(capacity < 10 || capacity % 10 != 0) throw new Error("Capacity must be multiple of 10");
		
		this.capacity = capacity;
		this.keyValuePairs = new SinglyLinkedList[capacity];
	}
	
	public boolean containsKey(String key) {
		
		int index = hash(key);
		
		if(this.keyValuePairs[index] == null) {
			
			return false;
		
		} else {
			
			SinglyLinkedList temp = this.keyValuePairs[index];
			
			while(temp != null) {
				
				if(((Pair<V>) temp.getValue()).getKey().equals(key)) {		// update existing key
					
					return true;
					
				} else {
					
					temp = temp.getNext();		// check next one
				}
			}
			
			return false;
		}
	}
	
	private int hash(String key) {
		
		return key.hashCode() % capacity;
	}
	
	public void put(String key, V value) {
		
		int index = hash(key);
		
		if(keyValuePairs[index] == null) {
			
			keyValuePairs[index] = new SinglyLinkedList<Pair<V>>(new Pair<V>(key, value));
			return;
		
		} else {
			
			SinglyLinkedList<Pair<V>> previous = null;
			SinglyLinkedList<Pair<V>> temp = keyValuePairs[index];
			
			while(temp != null) {
				
				if(((Pair<V>) temp.getValue()).getKey().equals(key)) {		// update existing key
					
					temp.getValue().setValue(value);
					
					return;
				
				} else {
					
					previous = temp;
					temp = temp.getNext();		// check next one
				}
			}
			
			previous.setNext(new SinglyLinkedList<Pair<V>>(new Pair<V>(key, value)));
		}
	}
	
	public String toString() {
		
		final String tab = "  ";
		
		boolean isEmpty = true;
		
		StringBuilder ret = new StringBuilder("{\n");
		
		for(SinglyLinkedList<Pair<V>> list : this.keyValuePairs) {
			
			if(list != null) {
				
				SinglyLinkedList<Pair<V>> temp = list;
				
				while(temp != null) {
					
					isEmpty = false;
					
					ret.append(tab + temp.getValue().getKey() + " : " + temp.getValue().getValue().toString() + ",\n");
					
					temp = temp.getNext();
				}
			}
		}
		
		if(isEmpty) return "{}";
		
		if(ret.length() > 2)
			ret.setCharAt(ret.length() - 2, ' ');
		
		ret.append("}");
		
		return ret.toString();
	}
	
}

class Pair<V> {
	
	private String key;
	
	private V value;
	
	public Pair(String k, V v) {
		
		this.key = k;
		this.value = v;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}


