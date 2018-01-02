package com.jatin.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 40
 * 10		
 * 5 20
 * 	 15 30
 */


/*
 * 
 * 								40
				10								50
			5		20								60
				15		30						55		70
 */

public class BinarySearchTree {
	static Node root = new Node(40, null, null);
	
	static Tree tree = new Tree(root);
	
	public static void main(String[] args) {
		

		tree.insertNode(root, 10);
		tree.insertNode(root, 5);
		tree.insertNode(root, 20);
		tree.insertNode(root, 15);
		tree.insertNode(root, 30);
		tree.insertNode(root, 50);
		tree.insertNode(root, 60);
		tree.insertNode(root, 55);
		tree.insertNode(root, 70);
	
		
		tree.traverse(Tree.TraverseEnum.IN_ORDER);
		
		tree.traverse(Tree.TraverseEnum.PRE_ORDER);
		
		tree.traverse(Tree.TraverseEnum.POST_ORDER);
		
		tree.traverse(Tree.TraverseEnum.LEVEL_ORDER_W_QUEUE);
		
		tree.traverse(Tree.TraverseEnum.IN_ORDER_W_STACK);
		
		tree.traverse(Tree.TraverseEnum.PRE_ORDER_W_STACK);
		
		tree.traverse(Tree.TraverseEnum.POST_ORDER_W_QUEUE);
	}
}

class Tree {
	Node rootNode;
	
	public Tree(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public  void insertNode(Node root, int data) {
		if (data < root.getData()) {
			if (root.getLeftChild() != null) {
				insertNode(root.getLeftChild(), data);
			} else {
				root.setLeftChild(new Node(data, null, null));
			}
		} else {
			if (root.getRightChild() != null) {
				insertNode(root.getRightChild(), data);
			} else {
				root.setRightChild(new Node(data, null, null));
			}
		}

	}
	
	public void traverse(TraverseEnum traverseType) {
		System.out.println("\nRoot node is " + rootNode.getData());
		switch(traverseType){
			case IN_ORDER:
				System.out.println("INOrder");
				inOrderTraverse(rootNode);
				break;
			case PRE_ORDER:
				System.out.println("PREOrder");
				preOrderTraverse(rootNode);
				break;
			case POST_ORDER:
				System.out.println("POSTOrder");
				postOrderTraverse(rootNode);
				break;
			case LEVEL_ORDER_W_QUEUE:
				System.out.println("LEVELOrder");
				levelOrderTraverse(rootNode);
				break;
			case IN_ORDER_W_STACK:
				System.out.println("INOrder");
				inOrderTraverseWStack(rootNode);
				break;
			case PRE_ORDER_W_STACK:
				System.out.println("PREOrder");
				preOrderTraverseWQueue(rootNode);
				break;
			case POST_ORDER_W_QUEUE:
				System.out.println("POSTOrder");
				postOrderTraverseW(rootNode);
				break;
			default: break;
		}
		
		
	}
	
	private void postOrderTraverseW(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		System.out.println("  Traversed " + root.getData());
		
		// process left subtree
		queue.add(root.leftChild);
		
		while(!queue.isEmpty()){
			Node n = queue.poll();
			if(n.leftChild != null){
				System.out.println(n.leftChild.getData());
				queue.add(n.leftChild);	
			}
			if(n.rightChild != null){
				System.out.println(n.rightChild.getData());
				queue.add(n.rightChild);	
			}
			
//			System.out.println(n.getData());
			
			
		}
		
		
	}
	
	private void preOrderTraverseWQueue(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		
		System.out.println("  Traversed " + root.getData());
		
		// process left subtree
		queue.add(root.leftChild);
		processPreOrderQ(root.leftChild, queue);
		
		// process right subtree
		queue.add(root.rightChild);
		processPreOrderQ(root.rightChild, queue);
		
	}
	
	private void processPreOrderQ(Node node, Queue<Node> queue){
		while(!queue.isEmpty()){
			Node n = queue.poll();
			System.out.println("  Traversed " + n.getData());
			if(n.leftChild != null){
				queue.add(n.leftChild);	
			}
			
			if(n.rightChild != null){
				queue.add(n.rightChild);	
			}
		}
	}
	

	
	
	private void inOrderTraverseWStack(Node root){
		Stack<Node> s = new Stack<Node>();
		pushLeftToStack(root, s);
		while(!s.isEmpty()){
			Node n = s.pop();
			System.out.println("  Traversed " + n.getData());
			pushLeftToStack(n.rightChild,s);
		}
	}
	
	private void pushLeftToStack(Node n, Stack<Node> s){
		while(n != null){
			s.push(n);
			n = n.leftChild;
		}
	}
	
	private void levelOrderTraverse(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		while(queue.peek() != null){
			Node n = queue.poll();
			
			System.out.println("  Traversed " + n.getData());
			
			if(n.leftChild != null){
				queue.add(n.leftChild);
			}
			
			if(n.rightChild != null){
				queue.add(n.rightChild);
			}
		}
		
		
	}
	
	
	
	private void preOrderTraverse(Node root){
//		System.out.println("Traversing root, left, right");
		if(root != null){
			System.out.println("  Traversed " + root.getData());
			preOrderTraverse(root.getLeftChild());
			preOrderTraverse(root.getRightChild());
		}
	}
	
	private void postOrderTraverse(Node root){
//		System.out.println("Traversing left, right, root");
		if (root != null) {
			postOrderTraverse(root.getLeftChild());
			postOrderTraverse(root.getRightChild());
			System.out.println("  Traversed " + root.getData());
		}
	}
	
	private void inOrderTraverse(Node root) {
//		System.out.println("Traversing left, root, right");
		if (root != null) {
			inOrderTraverse(root.getLeftChild());
			System.out.println("  Traversed " + root.getData());
			inOrderTraverse(root.getRightChild());
		}
	}
	
	public static enum TraverseEnum{
		IN_ORDER, PRE_ORDER, POST_ORDER, LEVEL_ORDER_W_QUEUE, IN_ORDER_W_STACK, PRE_ORDER_W_STACK, POST_ORDER_W_QUEUE;
	}

}



class Node {
	int data;
	Node leftChild;
	Node rightChild;

	public Node() {

	}

	public Node(int data, Node leftChild, Node rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
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

}
