package ctci.ch4TreesAndGraphs;

import java.util.Arrays;
import dataStructures.ArrayList;

import dataStructures.*;

public class P2 {

	public static void main(String[] args) {
		
		/*
		 * Given a directed graph, find if there's a route between 2 nodes.
		 */
		
		Graph g = new Graph(10);
		
		g.setEdge(0, 2);
		g.setEdge(0, 7);
		g.setEdge(0, 8);
		g.setEdge(1, 1);
		g.setEdge(3, 0);
		g.setEdge(3, 6);
		g.setEdge(4, 2);
		g.setEdge(4, 5);
		g.setEdge(4, 8);
		g.setEdge(6, 0);
		g.setEdge(6, 1);
		g.setEdge(8, 3);
		g.setEdge(9, 4);
		
//		System.out.println("Size of graph: " + g.size());
//		System.out.println("Adjacents: ");
//		System.out.println("> 0 : " + Arrays.toString(g.getAdjacentVerticesIndex(0).toArray()));
		
		System.out.println("Are 0 2 connected? " + areConnected(g, 0, 2));
		System.out.println("Are 0 9 connected? " + areConnected(g, 0, 9));
		System.out.println("Are 9 1 connected? " + areConnected(g, 9, 1));
		System.out.println("Are 4 7 connected? " + areConnected(g, 4, 7));
		System.out.println("Are 0 3 connected? " + areConnected(g, 0, 3));
		System.out.println("Are 1 1 connected? " + areConnected(g, 1, 1));
		System.out.println("Are 6 4 connected? " + areConnected(g, 6, 4));
	}
	
	public static boolean areConnected(Graph g, int a, int b) {
		
		if(a == b) {
			
			return true;
		}
		
		boolean[] visited = new boolean[g.size()];	// ones that have been enqueued, and will eventually get checked
		
//		Queue<Integer> q = new Queue<>();
//		return bfs(g, q, visited, a, b);
//		
//		Stack<Integer> s = new Stack<>();
//		return dfs(g, s, visited, a, b);
		
		return dfsStackLess(g, visited, a, b);
	}
	
	private static boolean dfsStackLess(Graph g, boolean[] visited, int n, int m) {
		
		if(n == m) {	// found target
			
			return true;
		}
		
		ArrayList<Integer> adjacent = g.getAdjacentVerticesIndex(n);
		
		for(int i : adjacent) {
			
			if(!visited[i]) {
				
				visited[i] = true;
				
				return dfsStackLess(g, visited, i, m);
			}
		}
		
		return false; 		// not found, all nodes checked
	}
	
	
	private static boolean dfs(Graph g, Stack<Integer> s, boolean[] visited, int n, int m) {
		
		if(n == m) {	// found target
			
			return true;
		}
		
		ArrayList<Integer> adjacent = g.getAdjacentVerticesIndex(n);
		
		for(int i : adjacent) {
			
			if(!visited[i]) {
				
				s.push(i);
				
				visited[i] = true;
			}
		}
		
		if(s.size() != 0) {		// more vertices to check
			
			return dfs(g, s, visited, s.pop(), m);
			
		} else {
			
			return false; 		// not found, all nodes checked
		}
	}
	
	
	
	
	private static boolean bfs(Graph g, Queue<Integer> q, boolean[] visited, int n, int m) {
		
		if(n == m) {	// found target
			
			return true;
		}
		
		ArrayList<Integer> adjacent = g.getAdjacentVerticesIndex(n);
		
		for(int i : adjacent) {
			
			if(!visited[i]) {
				
				q.enqueue(i);
				
				visited[i] = true;
			}
		}
		
		if(q.size() != 0) {		// more vertices to check
			
			return bfs(g, q, visited, q.dequeue(), m);
			
		} else {
			
			return false; 		// not found, all nodes checked
		}
	}

}
