package com.jatin.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Graph {

	public List<Node> nodes = new ArrayList<Node>();

	public void addNode(Node n){
		this.nodes.add(n);
		Node.id++;
		n.thisId = Node.id; 
	}
	

	public void breadthFirstTraversal(Node rootNode) {
		Queue q = new LinkedList();
		q.add(rootNode);
		rootNode.visited = true;
		while (!q.isEmpty()) {
			Node n = (Node) q.poll();
			System.out.print(n.data + " ");
			for (Node adj : n.adjacentNodes) {
				if (!adj.visited) {
					adj.visited = true;
					q.add(adj);
				}
			}
		}

	}
	
	public void resetNodes(){
		for(Node n : nodes){
			n.visited = false;
		}
	}

}