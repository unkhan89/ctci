package ctci.ch2LinkedLists;

import dataStructures.*;

public class P2 {

	public static void main(String[] args) {
		
		/*
		 * Write a method that returns the k-th to last element of a singly linked list.
		 */
		
		String[] data = {"A", "B", "C", "D", "E"};
		
		SinglyLinkedList<String> list = SinglyLinkedList.buildSinglyLinkedList(data);
		
		System.out.println(getKth(list, 5));

	}
	
	public static Object getKth(SinglyLinkedList l, int k) {
		
		ArrayList list = new ArrayList();
		
		list.add(l.getValue());
		
		int length = 1;
		
		SinglyLinkedList temp = l;
		
		while(temp.getNext() != null) {
			
			length++;
			
			temp = temp.getNext();
			
			list.add(temp.getValue());
		}
		
		int kthIndex = length - 1 - k;
		
		if(kthIndex < 0 || kthIndex >= length) {
			
			return null;
			
		} else {
			
			return list.get(kthIndex);
		}
	}

}
