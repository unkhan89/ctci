package ctci.ch9Recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class P4 {

	public static void main(String[] args) {
		
		/*
		 * Write a method that returns all subsets of a set.
		 * 
		 */
		
		Set set = new HashSet();
		
		set.add('A');
		set.add('B');
		set.add('C');
		set.add('D');
		
		Set subsets = subsets(set);
		
		System.out.println(subsets.toString());

	}
	
	public static Set subsets(Set s) {
		
		Set subsets = new HashSet();
		
		populate(s, subsets);
		
		return subsets;
		
	}
	
	private static void populate(Set s, Set subsets) {
		
		if(s.size() == 0) return;
		
		if(s.size() == 1) {
			
			subsets.add(s.iterator().next());
			
		} else {
			
			subsets.add(s);
			
			int skip = 0;
			
			for(int i = 0; i < s.size(); i++) {
				
				Set temp = new HashSet();
				
				Iterator iter = s.iterator();
				
				for(int j = 0; iter.hasNext(); j++) {
					
					Object next = iter.next();
					
					if(j != skip) {
						
						temp.add(next);
					
					}
				}
				
				populate(temp, subsets);
				
				skip++;
			}
		}
	}
}
