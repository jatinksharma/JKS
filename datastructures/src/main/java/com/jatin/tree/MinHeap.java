package com.jatin.tree;

public class MinHeap {
	
	public static void main(String[] args) {
		
		HeapNode node40 = new HeapNode();
		
		HeapNode node30 = new HeapNode();
		
		HeapNode node60 = new HeapNode();
		
		HeapNode node20 = new HeapNode();
		
		
	}
	
}

class Heap{
	HeapNode rootNode;
	

	public void insertNode(HeapNode node){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public HeapNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(HeapNode rootNode) {
		this.rootNode = rootNode;
	}
	
}

class HeapNode {
	int data;
	int priority;
	Node leftChild;
	Node rightChild;

	public HeapNode() {

	}

	public HeapNode(int data, int priority, Node leftChild, Node rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.priority = priority;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}