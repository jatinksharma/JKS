package com.jatin.graph.boggle;

import com.jatin.graph.Graph;
import com.jatin.graph.Node;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;



public class Boggle {
	
	static Graph BOARD_GRAPH = new Graph();
	
	static Node[][] nodeMatrix = new Node[4][4];
	
	static String[][] BOARD = 
							{
								{"a", "b", "c", "d"}, 
								{"a", "e", "x", "x"},
								{"m", "l", "l", "h"},
								{"e", "e", "p", "y"}
							};
	
	public Boggle() {
		convertMatrixToGraph();
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean find(String s) {
		System.out.println("\n");
		
		boolean isPresent = false;
		int currIndexInString = 0; 
		
		Node rootNode = nodeMatrix[0][0];
		
		rootNode.visited = true;
		Queue q = new LinkedList();
		q.add(rootNode);
		rootNode.visited = true;
		Set<Node> set1stLetterNodes = new LinkedHashSet<Node>();
		// BFS and create all nodes that have 1st letter
		while (!q.isEmpty()) {
			Node n = (Node) q.poll();
			if(n.data.equalsIgnoreCase(Character.toString(s.charAt(currIndexInString)))){
				set1stLetterNodes.add(n);
			}
			System.out.print(n.data + " ");
			for (Node adj : n.adjacentNodes) {
				if (!adj.visited) {
					adj.visited = true;
					q.add(adj);
				}
			}
		}
		
		System.out.println("\n");
		
		currIndexInString++;
		
		// For every neighbor, check if the value is there
		for(Node n : set1stLetterNodes){
			System.out.println("Processing " + n.data);
			boolean b = process1stLetterNghbrs(null, n, s, 1);
			BOARD_GRAPH.resetNodes();
			if(b){
				isPresent = true;
				return b;
			}
		}
		
		return isPresent;

	}
	
	boolean process1stLetterNghbrs(Node prevNode, Node n, String s, int index){
		
		boolean found = false;
		System.out.println("Processing " + n + " neighbors "+ n.adjacentNodes);
		for(Node neighbor: n.adjacentNodes){
			
			System.out.println("\tNeighbor and index " + neighbor.data + " , " + index);
			if(neighbor.data.equalsIgnoreCase(Character.toString(s.charAt(index))) && neighbor != prevNode){
				index++;
				if(index < s.length() ){
					BOARD_GRAPH.resetNodes();
					return true && process1stLetterNghbrs(n, neighbor, s, index);
				}else{
					found = true;
					System.out.println("Found!");
					return found;
				}
				
			}

			
		}
		
		return found;
		
		
	}
	
	
	static void convertMatrixToGraph(){
		// create matrix with nodes
//		Node[][] nodeMatrix = new Node[4][4];
		
		for(int i=0; i< BOARD.length; i++){
			for(int j=0; j< BOARD.length ; j++){
				nodeMatrix[i][j] = new Node(BOARD[i][j]);
			}
		}
				
		
		// iterate, create node for every coordinate
		// assign adjacent nodes as follows:
		// for every node add
		// i-1,j-1 | i-1,j | i-1, j+1
		// i,j-1 | i,j+1
		// i+1, j-1 | i+1, j | i+1, j+1
		for(int i=0; i< nodeMatrix.length; i++){
			for(int j=0; j< nodeMatrix.length ; j++){
				if(i!=0 && j!=0 && null != nodeMatrix[i-1][j-1]){
					nodeMatrix[i][j].addAdjacentNode(nodeMatrix[i-1][j-1]);
				}
				if(i!=0 && null != nodeMatrix[i-1][j]){
					nodeMatrix[i][j].addAdjacentNode(nodeMatrix[i-1][j]);
				}
				if(i!=0 && j<nodeMatrix.length-1 && null != nodeMatrix[i-1][j+1]){
					nodeMatrix[i][j].addAdjacentNode(nodeMatrix[i-1][j+1]);
				}
				if(j!=0 && null != nodeMatrix[i][j-1]){
					nodeMatrix[i][j].addAdjacentNode(nodeMatrix[i][j-1]);
				}
				if(j < nodeMatrix.length -1 && null != nodeMatrix[i][j+1]){
					nodeMatrix[i][j].addAdjacentNode(nodeMatrix[i][j+1]);
				}
				if(i<nodeMatrix.length-1 && j!=0 && null != nodeMatrix[i+1][j-1]){
					nodeMatrix[i][j].addAdjacentNode(nodeMatrix[i+1][j-1]);
				}
				if(i<nodeMatrix.length-1 && null != nodeMatrix[i+1][j]){
					nodeMatrix[i][j].addAdjacentNode(nodeMatrix[i+1][j]);
				}
				if(i<nodeMatrix.length-1 && j<nodeMatrix.length-1 && null != nodeMatrix[i+1][j+1]){
					nodeMatrix[i][j].addAdjacentNode(nodeMatrix[i+1][j+1]);
				}
				
				BOARD_GRAPH.addNode(nodeMatrix[i][j]);
			}
		}
		
		BOARD_GRAPH.breadthFirstTraversal(nodeMatrix[0][0]);
		
		BOARD_GRAPH.resetNodes();
		
		
	}

	
	public static void main(String[] args) {
		Boggle boggle = new Boggle();
		System.out.println("\n"+boggle.find("aely"));
	}
	

	
	
}
