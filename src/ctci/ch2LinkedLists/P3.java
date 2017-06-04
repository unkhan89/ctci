package ctci.ch2LinkedLists;

import dataStructures.SinglyLinkedList;

public class P3 {

	public static void main(String[] args) {
		
		/*
		 * Given the node in a singly linked list, delete the node.
		 */
		
		String[] data = {"A", "B", "C", "D", "E"};
		
		SinglyLinkedList<String> list = SinglyLinkedList.buildSinglyLinkedList(data);
		
		System.out.println("Before: " + list.toString());
		
		delete(list);
		
		System.out.println("After: " + list.toString());

	}
	
	public static void delete(SinglyLinkedList node) {
		
		if(node.getNext() == null) {

			node = null;
					
			return;
		}
		
		while(node.getNext() != null) {
			
			node.setValue(node.getNext().getValue());
			
			if(node.getNext().getNext() == null) {	// second last
				
				node.setNext(null);
				
			} else {
			
				node = node.getNext();
			}
		}
	}

}
