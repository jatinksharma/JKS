package com.jatin.graph;

import java.util.List;

public class MainCreateGraph {

	public static void main(String[] args) {
		Graph cityGraph = new Graph();

		// create nodes
		Node chandigarh 	= new Node("chandigarh");
		Node ambala 		= new Node("ambala");
		Node karnal 		= new Node("karnal");
		Node panipat 		= new Node("panipat");
		Node delhi 			= new Node("delhi");
		Node noida 			= new Node("noida");
		Node meerut 		= new Node("meerut");
		Node shimla 		= new Node("shimla");

		
		// add nodes to graph
		cityGraph.addNode(chandigarh);
		cityGraph.addNode(ambala);
		cityGraph.addNode(karnal);
		cityGraph.addNode(panipat);
		cityGraph.addNode(delhi);
		cityGraph.addNode(noida);
		cityGraph.addNode(meerut);
		cityGraph.addNode(shimla);
		
		// add adjacency
		chandigarh.addAdjacentNode(ambala);
		chandigarh.addAdjacentNode(karnal);
		chandigarh.addAdjacentNode(shimla);
		chandigarh.addAdjacentNode(delhi);
		delhi.addAdjacentNode(noida);
		delhi.addAdjacentNode(meerut);
		meerut.addAdjacentNode(shimla);
		meerut.addAdjacentNode(panipat);
		ambala.addAdjacentNode(karnal);
		karnal.addAdjacentNode(panipat);
		shimla.addAdjacentNode(delhi);

		cityGraph.breadthFirstTraversal(chandigarh);
		
		System.out.println("\n");
		cityGraph.resetNodes();
		cityGraph.breadthFirstTraversal(delhi);
		
		System.out.println("\n");
		cityGraph.resetNodes();
		cityGraph.breadthFirstTraversal(shimla);
	}
	
	
}
