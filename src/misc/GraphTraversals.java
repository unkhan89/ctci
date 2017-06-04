package misc;

import dataStructures.*;

public class GraphTraversals {

	public static void main(String[] args) {
		
		Graph g = new Graph(20);
		
		g.setEdge(1, 2);
		g.setEdge(2, 3);
		g.setEdge(3, 4);
		g.setEdge(4, 5);
		g.setEdge(1, 8);
		g.setEdge(1, 9);
		
		boolean[] visited = new boolean[g.size()];
		
		int start = 1;
		
		visited[start] = true;
		
		System.out.println("Depth first:");
		
		dfs(g, visited, start);
		
		System.out.println("Breadth first: ");
		
		visited = new boolean[g.size()];
		
		bfs(g, visited, new Queue<Integer>(), start);
	}
	
	public static void bfs(Graph g, boolean[] visited, Queue<Integer> q, int n) {
		
		System.out.println(n);
		
		ArrayList<Integer> adjacentNodes = g.getAdjacentVerticesIndex(n);
		
		for(Integer node : adjacentNodes) {
			
			if(!visited[node]) {
				
				q.enqueue(node);
				
				visited[node] = true;
			}
		}
		
		if(q.size() > 0) {
			
			bfs(g, visited, q, q.dequeue());
		}
	}
	
	public static void dfs(Graph g, boolean[] visited, int n) {
		
		System.out.println(n);
		
		ArrayList<Integer> adjacentNodes = g.getAdjacentVerticesIndex(n);
		
		for(Integer node : adjacentNodes) {
			
			if(!visited[node]) {
				
				visited[node] = true;
				
				dfs(g, visited, node);
			}
		}	
	}
}
