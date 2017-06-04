package ctci.ch11SortingAndSearching;

public class P2 {

	public static void main(String[] args) {
		
		/*
		 * 
		 * 
		 */

	}
	
	public static int find(int[] a, int n) {
		
		int start = 0, end = a.length - 1;
		
		boolean isRotated = false;
		
		if(a[0] >= a[a.length -1]) {
			
			isRotated = true;
			
			// find true start and end:
			
			int s = 0, e = a.length - 1;
			
			while(s <= e) {
				
				int mid = (s + e) / 2;
				
				if(a[mid-1] > a[mid]) {		// found start
					
					start = mid;
					end = mid - 1;
					break;
				}
				
				// determine which half to check:
				
				int leftMid = (s + mid - 1) / 2;
				int rightMid = (mid + 1 + e) / 2;
				
				if(a[rightMid] < a[leftMid]) {		// start is in right half
					
					s = mid + 1;
					
				} else {	// start is in left half
					
					e = mid - 1;
				}
			}
		}
		
		// binary search for n per new start and end
		
		int s = 0, e = a.length - 1;
		
		while (true) {
			
			// break if true start and true end overlap:
			
			if(s >= start) break;
			
			// calculate adjusted mid: 
			
			int mid = getMid(isRotated, a.length, start, s, e);
			
			// check mid:
			
			if(a[mid] == n) return mid;
			
			// mid's not it, determine which half to check:
			
			if(n < a[mid]) {
				
				e = mid - 1;
				
			} else {
				
				s = mid + 1;
			}
			
		}
		
		return -1;
	}
	
	private static int getMid(boolean isRotated, int arrayLength, int trueStartIndex, int s, int e) {
		
		if(isRotated) {
			
			if(s >= trueStartIndex) s -= arrayLength;
			
			int mid = (s + e) / 2;
			
			if(mid < 0) mid += arrayLength;
			
			return mid;
		
		} else {
			
			return (s + e) / 2;
		}
		
	}
}
