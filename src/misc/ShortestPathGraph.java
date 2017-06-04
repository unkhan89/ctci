package misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import dataStructures.ArrayList;
import dataStructures.Graph;
import dataStructures.Queue;

public class ShortestPathGraph {

	public static void main(String[] args) {
		
		/*
		 * Given two nodes in a weighted graph, find the shortest path.
		 */
		
		Graph g = new Graph(20);
		
		g.setEdgeUndirected(0, 2);
		g.setEdgeUndirected(0, 7);
		g.setEdgeUndirected(0, 8);
		g.setEdgeUndirected(1, 1);
		g.setEdgeUndirected(3, 0);
		g.setEdgeUndirected(3, 6);
		g.setEdgeUndirected(4, 2);
		g.setEdgeUndirected(4, 5);
		g.setEdgeUndirected(4, 8);
		g.setEdgeUndirected(6, 0);
		g.setEdgeUndirected(6, 1);
		g.setEdgeUndirected(8, 3);
		g.setEdgeUndirected(9, 4);
		g.setEdgeUndirected(10, 5);
		g.setEdgeUndirected(10, 7);
		g.setEdgeUndirected(10, 11);
		g.setEdgeUndirected(11, 1);
		g.setEdgeUndirected(12, 0);
		g.setEdgeUndirected(12, 1);
		g.setEdgeUndirected(12, 8);
		g.setEdgeUndirected(13, 11);
		
//		System.out.println(shortestPathGreedy(g, 0, 7));
//		System.out.println(shortestPathGreedy(g, 0, 8));
		System.out.println(shortestPathGreedy(g, 10, 12));	// bug, no node between 10 and 1
		
	}
	
	public static String shortestPathGreedy(Graph g, int a, int b) {
		
		HashMap<Integer, Queue<Integer>> queues = new HashMap<>();
		
		Queue<Integer> q = new Queue<>();
		
		queues.put(a, q);
		
		String path = "" + a;
		
		boolean[] visited = new boolean[g.size()];
		
		visited[a] = true;
		
		HashSet<String> allPaths = new HashSet<>();
		
		bfsGreedy(g, visited, queues, a, b, path, allPaths);
		
		if(allPaths.isEmpty()) {
			
			return "";
		
		} else {
			
			String min = null;
			
			for(String aPath : allPaths) {
				
				if(min == null) {
					
					min = aPath;
				
				} else if(aPath.length() < min.length()) {
					
					min = aPath;
				}
				
				System.out.println(aPath);
			}
			
			return min;
		}
	}
	
	private static void bfsGreedy(Graph g, boolean[] visited, HashMap<Integer, Queue<Integer>> queues, int current, int target, String path, HashSet<String> allPaths) {

		if(current == target) {
			
			allPaths.add(path);
		
		} else {
			
			ArrayList<Integer> adjacent = g.getAdjacentVerticesIndex(current);
	
			for(int i = 0; i < adjacent.size(); i++) {
				
	//			if(adjacent.get(i) == target) {
	//				
	//				return path + "-" + adjacent.get(i);
	//			}
				
				if(!visited[ adjacent.get(i) ]) {
					
					if(queues.get(current) == null) {
						
						queues.put(current, new Queue<Integer>());
					}
	
					queues.get(current).enqueue(adjacent.get(i));
					
					visited[adjacent.get(i)] = true;
				}
			}
			
			Set<Integer> vertices = queues.keySet();
			
			for(Integer vertex : vertices) {
			
				while(queues.get(vertex) != null && queues.get(vertex).size() > 0) {
					
					int nextNode = queues.get(vertex).dequeue();
						
					bfsGreedy(g, visited, queues, nextNode, target, path + "-" + nextNode, allPaths);
				}
				
			}
			
		}
	}
	
	
	
	
	
//	
//	public static String shortestPath(Graph g, int a, int b) {
//		
//		Queue<Integer> q = new Queue<>();
//		
//		String path = "" + a;
//		
//		boolean[] visited = new boolean[g.size()];
//		
//		visited[a] = true;
//		
//		ArrayList<String> allPaths = new ArrayList<>();
//		
//		bfs(g, visited, q, a, b, path, allPaths);
//		
//		if(allPaths.size() == 0) return "";
//		
//		String shortestPath = allPaths.get(0);
//		
//		System.out.println("All paths: " + allPaths);
//		
//		for(int i = 0; i < allPaths.size(); i++) {
//			
//			if(allPaths.get(i).length() < shortestPath.length()) {
//				
//				shortestPath = allPaths.get(i);
//			}
//		}
//		
//		return shortestPath;
//	}
//	
//	private static void bfs(Graph g, boolean[] visited, Queue<Integer> q, int current, int target, String path, ArrayList<String> allPaths) {
//		
//		if(current == target) {
//			
//			allPaths.add(path);
//		}
//		
//		ArrayList<Integer> adjacent = g.getAdjacentVerticesIndex(current);
//
//		for(int i = 0; i < adjacent.size(); i++) {
//			
////			if(adjacent.get(i) == target) {
////				
////				return path + "-" + adjacent.get(i);
////			}
//			
//			if(!visited[ adjacent.get(i) ]) {
//
//				q.enqueue(adjacent.get(i));
//				
//				visited[adjacent.get(i)] = true;
//			}
//		}
//
//		if(q.size() > 0) {
//			
//			int nextNode = q.dequeue();
//			
//			bfs(g, visited, q, nextNode, target, path + "-" + nextNode, allPaths);
//		}
//	}
}
