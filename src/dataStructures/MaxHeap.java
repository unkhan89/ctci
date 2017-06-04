package dataStructures;

public class MaxHeap {
	
	private Integer[] elements;
	
	public MaxHeap() {}
	
	public MaxHeap(Integer[] newElements) {
		
		this.elements = buildMaxHeap(newElements);
	}
	
	private Integer[] buildMaxHeap(Integer[] items) {
		
		for(int i = items.length - 1; i >= 0; i--) {
			
			maxHeapify(items, i);
		}
		
		return items;
	}
	
	private void maxHeapify(Integer[] items, int parentIndex) {
		
		int leftChildIndex = getLeftChildIndex(parentIndex);
		int rightChildIndex = getRightChildIndex(parentIndex);
		
		if(rightChildIndex < items.length) {	// both children exist
			
			if(items[leftChildIndex] >= items[rightChildIndex] && items[leftChildIndex] > items[parentIndex]) {
				
				swap(items, parentIndex, leftChildIndex);
				maxHeapify(items, leftChildIndex);
			
			} else if(items[leftChildIndex] <= items[rightChildIndex] && items[rightChildIndex] > items[parentIndex]) {
				
				swap(items, parentIndex, rightChildIndex);
				maxHeapify(items, rightChildIndex);
			}
			
		} else if(leftChildIndex < items.length) {		// only left child exists
			
			if(items[leftChildIndex] > items[parentIndex]) {
				
				swap(items, parentIndex, leftChildIndex);
				maxHeapify(items, leftChildIndex);
			}
		}
	}
	
	private void swap(Integer[] items, int a, int b) {
		
		Integer temp = items[a];
		items[a] = items[b];
		items[b] = temp;
	}
	
	private int getLeftChildIndex(int parentIndex) {
		
		return (parentIndex * 2) + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		
		return (parentIndex * 2) + 2;
	}
	
	private int getParentIndex(int childIndex) {
		
		return (childIndex - 1) / 2;
	}
	
	public Integer[] getElements() {
		
		return this.elements;
	}

	public String toString() {
		
		return java.util.Arrays.toString(this.elements);
	}
}
