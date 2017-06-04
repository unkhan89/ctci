package ctci.ch2LinkedLists;

import java.util.*;
import dataStructures.*;

public class P1 {

	public static void main(String[] args) {
		
		/*
		 * Write a function that removes a duplicate element from a linked list.
		 * 
		 * Follow up: What if a temporary buffer is not allowed? 
		 */
		
		String[] data = {"A", "B", "A", "C", "D", "A"};
		
		SinglyLinkedList<String> n = SinglyLinkedList.buildSinglyLinkedList(data);
		
		dedupe1(n);
		
		System.out.println("Deduped: " + n.toString());
		
	}
	
	static void dedupe1(SinglyLinkedList<String> n) {
		
		if(n == null || n.getNext() == null) {
			
			return;
		}
		
		Set<String> s = new HashSet<String>();
		
		s.add(n.getValue());
		
		while(n.getNext() != null) {
			
			if(s.contains(n.getNext().getValue())) {
				
				n.setNext(n.getNext().getNext());
			
			} else {
				
				s.add(n.getNext().getValue());
			}
			
			if(n.getNext() != null) {	// safety check in case last element is being removed
				
				n = n.getNext();
			}
		}
	}

}
