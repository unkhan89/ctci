package ctci.ch11SortingAndSearching;

import java.util.Arrays;

public class P1 {

	public static void main(String[] args) {
		
		/*
		 * Given 2 sorted arrays a and b, merge elements of b into a and keep them sorted.
		 * Assume there is enough space at the end of a to hold all elements of b.
		 * 
		 */
		
		int[] a = new int[] {2, 4, 5, 7, 9, 15, 0, 0, 0, 0, 0};
		int[] b = new int[] {3, 4, 6, 10, 13};
		
		System.out.println(Arrays.toString(merge(a, b)));	
	}
	
	
	public static int[] merge(int[] a, int[] b) {
		
		int j = 0;
		
		for(int i = 0; i < a.length; i++) {
			
			if( j >= b.length) return a;
			
			else if(a[i] == 0) {
				
				a[i] = b[j];
				
				j++;
			
			} else if(b[j] < a[i]) {
				
				int temp = a[i], newTemp = a[i+1];
				
				int k;
				
				for(k = i+1; k < a.length && a[k] != 0; k++) {
					
					a[k] = temp;
					
					temp = newTemp;
					
					newTemp = a[k+1];
				}
				
				a[k] = temp;
				
				a[i] = b[j];
				
				j++;
			}
		}
		
		return a;
	}
}
