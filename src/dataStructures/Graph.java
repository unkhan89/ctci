package dataStructures;


// TODO: Support generics such that vertices can be represented 
// using anything other than integers

public class Graph {
	
	private SinglyLinkedList<Edge>[] vertices;
	
	@SuppressWarnings("unchecked")
	public Graph(int numberOfVertices) {
		
		vertices = (SinglyLinkedList<Edge>[]) new SinglyLinkedList[numberOfVertices];
	}
	
	public int size() {
		
		return vertices.length;
	}
	
	public void setEdge(int i, int j) {
		
		if(vertices[i] == null) {
			
			vertices[i] = new SinglyLinkedList<Edge>(new Edge(j));
		
		} else {
			
			SinglyLinkedList<Edge> temp = vertices[i];
			
			while(temp.hasNext()) {
				
				if(temp.getValue().getTo() == j) return;	// edge already set
				
				temp = temp.getNext();
			}
			
			temp.setNext(new SinglyLinkedList<Edge>(new Edge(j)));
		}
	} 
	
	public void setEdge(int i, int j, int weight) {
		
		if(vertices[i] == null) {
			
			vertices[i] = new SinglyLinkedList<Edge>(new Edge(j));
		
		} else {
			
			SinglyLinkedList<Edge> temp = vertices[i];
			
			while(temp.hasNext()) {
				
				if(temp.getValue().getTo() == j) return;	// edge already set
				
				temp = temp.getNext();
			}
			
			temp.setNext(new SinglyLinkedList<Edge>(new Edge(j, weight)));
		}
	} 
	
	public void setEdgeUndirected(int i, int j) {
		
		this.setEdge(i, j);
		this.setEdge(j, i);
	}

	public void setEdgeUndirected(int i, int j, int weight) {
		
		this.setEdge(i, j, weight);
		this.setEdge(j, i, weight);
	}
	
	public SinglyLinkedList<Edge> getAdjacentEdgeList(int i) {
		
		return this.vertices[i];
	}
	
	public ArrayList<Integer> getAdjacentVerticesIndex(int i) {
		
		SinglyLinkedList<Edge> adjacent = this.vertices[i];
		
		if(adjacent == null) {
			
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> ret = new ArrayList<>();
		
		SinglyLinkedList<Edge> temp = adjacent;
		
		while(temp.hasNext()) {
//			System.out.println(i + " has adjacent " + temp.getValue().getTo());
			ret.add(temp.getValue().getTo());
			
			temp = temp.getNext();
		}
//		System.out.println(i + " has adjacent " + temp.getValue().getTo());
		ret.add(temp.getValue().getTo());	// add last one
//		System.out.println("Returning " + ret.size() + " elements");
		return ret;
	}
}

class Edge {
	
	private int to;
	
	private int weight = 0;
	
	public Edge(int to) {
		
		this.to = to;
	}
	
	public Edge(int to, int weight) {
		
		this.to = to;
		
		this.weight = weight;
	}
	
	public int getTo() {
		
		return this.to;
	}
	
	public int getWeight() {
		
		return this.weight;
	}
}
