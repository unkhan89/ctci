package ctci.ch1ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class P6 {

	public static void main(String[] args) {
		
		/*
		 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes
		 * write a method to rotate the image in place by 90 degrees. 
		 */
		
		int[][] matrix1 = {
			{1, 2, 3, 4, 5},
			{16, 101, 102, 103, 6},
			{15, 108, 0, 104, 7},
			{14, 107, 106, 105 ,8},
			{13,12,11,10,9}
		};
		
		System.out.println("Before rotation: ");
		
		for(int[] row : matrix1) {
			System.out.println(Arrays.toString(row));
		}
		
		rotate(matrix1);
		
		System.out.println("After rotation: ");
		
		for(int[] row : matrix1) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	static void rotate(int[][] m) {
		
		if(m.length == 0) return;
		
		// for convenience:
		
		int n = m.length;
		
		// find number of layers to rotate:
		
		int layers = (int) Math.floor(m.length / 2);
		
		// rotate each layer, where (l,l) represents the coordinates to layer origin (upper left most cell),
		// as well as the layer identifier:
		
		for(int l = 0; l < layers; l++) {
			
			// using predetermined rules, find coordinates of cells making up the rows and columns of layer ...
			
			// attempting to use arrays, not flexible enough though
			// int numOfCellsInEachRowAndColumn = n - (2 * l);		// for this specific layer			
			// Cell[] row1 = new Cell[numOfCellsInEachRowAndColumn];
			
			int LAYER_BOUNDARY_INDEX = n-l-1;	// inclusive
			
			ArrayList<Cell> topRow = new ArrayList<Cell>();
			
			for(int y = l; y <= LAYER_BOUNDARY_INDEX; y++) {
				
				int x = l; 	// constant x coordinate equal to layer index
				
				topRow.add(new Cell(x, y));	
			}
			
			ArrayList<Cell> rightColumn = new ArrayList<Cell>();
			
			for(int x = l; x <= LAYER_BOUNDARY_INDEX; x++) {
				
				int y = LAYER_BOUNDARY_INDEX; 	// constant y coordinate equal to left layer boundary
				
				rightColumn.add(new Cell(x, y));	
			}
			
			ArrayList<Cell> bottomRow = new ArrayList<Cell>();
			
			for(int y = LAYER_BOUNDARY_INDEX; y >= l; y--) {
				
				int x = LAYER_BOUNDARY_INDEX; 	// constant x coordinate equal to bottom layer boundary
				
				bottomRow.add(new Cell(x, y));
			}
			
			ArrayList<Cell> leftColumn = new ArrayList<Cell>();
			
			for(int x = LAYER_BOUNDARY_INDEX; x >= l; x--) {
				
				int y = l;		// constant y coordinate equal to layer index
				
				leftColumn.add(new Cell(x, y));
			}
			
//			System.out.println("Layer " + l + " components...");
//			System.out.println("> Top row: " + Arrays.toString(topRow.toArray()));
//			System.out.println("> Right col: " + Arrays.toString(rightColumn.toArray()));
//			System.out.println("> Bottom row: " + Arrays.toString(bottomRow.toArray()));
//			System.out.println("> Left col: " + Arrays.toString(leftColumn.toArray()));
			
			// Swap values rotationally. Recall that lists were populated in order such that their index corresponds to 
			// the index in next row/col where its value will be placed:
			
			int numberOfCellsInEachRowAndCol = n - (2 * l); // alternatively we can look at size of any 1 of 4 lists created above
			
			for(int i = 0; i < numberOfCellsInEachRowAndCol - 1; i++) {		
				
				// NOTE: loop is ran (numberOfCellsInEachRowAndCol - 1) times because after first iteration, the value at
				// index 0 is already in its correct position
				
				// store value of top left cell in layer and replace values in reverse order:
				
				int temp = m[topRow.get(i).getX()][topRow.get(i).getY()];
				
				m[topRow.get(i).getX()][topRow.get(i).getY()] = m[leftColumn.get(i).getX()][leftColumn.get(i).getY()];
				
				m[leftColumn.get(i).getX()][leftColumn.get(i).getY()] = m[bottomRow.get(i).getX()][bottomRow.get(i).getY()];
				
				m[bottomRow.get(i).getX()][bottomRow.get(i).getY()] = m[rightColumn.get(i).getX()][rightColumn.get(i).getY()];
						
				m[rightColumn.get(i).getX()][rightColumn.get(i).getY()] = temp;
			}
		}
	}
}


class Cell { 
	
	private int x; 
	
	private int y; 
	
	public Cell(int x, int y) { 
	
		this.x = x; 
	    this.y = y; 
	}
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public String toString() {
		
		return "(" + x + "," + y + ")";
	}
} 