package com.jatin.graph;

import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Node {
	public static int id = 1;
	
	public int thisId;

	public String data; // data element
	
	public boolean visited = false; // flag to track the already visited node

	public Set<Node> adjacentNodes = new LinkedHashSet<Node>(); // adjacency list

	public Node(String data) {
		this.data = data;
	}

	@SuppressWarnings("unchecked")
	public void addAdjacentNode(final Node node) {
		adjacentNodes.add(node);
		node.adjacentNodes.add(this);
	}
	
	@Override
	public int hashCode() {
		int seed = 37;
		return seed * thisId;
	}
	
	@Override
	public boolean equals(Object obj) {
		return thisId == ((Node)obj).thisId;
	}
	
	@Override
	public String toString() {
		
		return data;
	}
	
	

}