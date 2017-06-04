package dataStructures;

import java.util.HashMap;

public class Trie {

	private HashMap<Character, HashMap> dictionary;
	
	public Trie() {
		
		this.dictionary = new HashMap<Character, HashMap>();
	}
	
	public void add(String s) {
		
//		if(!this.has(s)) {
		
			HashMap<Character, HashMap> temp = this.dictionary;
			
			for(int i = 0; i < s.length(); i++) {
				
				Character thisOne = s.charAt(i);
				
				if(temp.containsKey(thisOne)) {
					
				} else {	// s doesn't exist, create new word
					
					temp.put(thisOne, new HashMap<Character, HashMap>());
					
					temp = temp.get(thisOne);
					
					int k = i + 1;
					
					while(k < s.length()) {
						
						temp.put(s.charAt(k), new HashMap<Character, HashMap>());
						
						temp = temp.get(s.charAt(k));
					}
				}
			}
			
//		}
	}
	
//	public String toString() {
//		
//		
//	}
}
