package com.jatin.tree;

public class RedBlackBSTTry {
	static RBNode ROOT;

	public void insert(RBNode newNode) {
		if (ROOT == null) {
			ROOT = newNode;
			paint(ROOT, RBNodeColor.BLACK); // (1) Root always BLACK
			
		} else {
			System.out.println("Inserting " + newNode.data);
			paint(newNode, RBNodeColor.RED); // (2) New node always RED
			insertLeaf(ROOT, newNode); // (3) Insert as leaf
			inOrderTraverse(ROOT);
			
		}
	}

	private void insertLeaf(RBNode existingNode, RBNode newNode) {
		if (newNode.data < existingNode.data) {
			if (existingNode.leftChild != null) {
				insertLeaf(existingNode.leftChild, newNode);
			} else {
				existingNode.leftChild = newNode; // inserted as left leaf!, now
				newNode.parent = existingNode;
				
				if(!hasSibling(existingNode)){
					rotateClockWise(existingNode); // unbalanced as no sibling and depth differs by 1, rotate
				}
				setRootNPaintBlack(existingNode);
			}
		} else {
			if (existingNode.rightChild != null) {
				insertLeaf(existingNode.rightChild, newNode);
			} else {
				existingNode.rightChild = newNode; // inserted as right leaf!, now
				newNode.parent = existingNode;
				
				if(!hasSibling(existingNode)){
					rotateAntiClockWise(existingNode); // unbalanced as no sibling and depth differs by 1, rotate
				}
				setRootNPaintBlack(existingNode);
			}
		}

	}

	boolean hasSibling(RBNode existingNode) {
		boolean hasSibling = false;
		boolean isRightSibling = false;
		
		RBNode sibling = null; // check if existingNode has sibling
		if(existingNode.parent != null && existingNode.parent.leftChild != null && existingNode.parent.rightChild != null){ // there are siblings
			if(existingNode.data != existingNode.parent.leftChild.data){
				sibling = existingNode.parent.leftChild;
				isRightSibling = false;
			}else{
				sibling = existingNode.parent.rightChild;
				isRightSibling = true;
			}
		}
		
		if(sibling != null){
			if(sibling.color.equals(RBNodeColor.RED)){ // check if sibling is red
				hasSibling = true;
				/* bring down BLACK from parent and paint both siblings BLACK */
				paint(existingNode, existingNode.parent.color);// Invariant: Has to be BLACK, else an issue
				paint(sibling, existingNode.parent.color); // Invariant: Has to be BLACK, else an issue
				paint(existingNode.parent, RBNodeColor.RED);
//				setRootNPaintBlack(existingNode);
			}
			// TODO: Check now for parent's red violation after taking parent's color
			if(existingNode.parent != null && existingNode.parent.parent !=null ){
				if(existingNode.parent.color.equals(RBNodeColor.RED) && existingNode.parent.parent.color.equals(RBNodeColor.RED)){
					if(existingNode.parent.leftChild != null && existingNode.parent.leftChild.data.equals(existingNode.data)){
						rotateClockWise(existingNode.parent.parent);
					}else{
						rotateAntiClockWise(existingNode.parent.parent);
					}
				}
			}
			
			
			
		}
		
	
		
		return hasSibling;
	}
	
	void paint(RBNode node, RBNodeColor color) {
		node.color = color; 
	}
	
	void setRootNPaintBlack(RBNode node) {
		System.out.println("\t\tSetting root using " + node );
		RBNode x = node;
		while(x.parent != null){
			x = x.parent;
		}
		

		
		ROOT = x;
		ROOT.parent = null;
		paint(ROOT, RBNodeColor.BLACK);
		System.out.println("\t\tRoot set to " + ROOT );
	}

	/**
	 * Rotate clockwise on current node's parent.
	 * if current is B 
	 * and branch is 
	 * A->B
	 * and C inserted to become 
	 * A->B->C then rotate right on A so that the branch becomes
	 * B->A
	 * B->C
	 *      
	 */
	void rotateClockWise(RBNode existingNode) {
		if(existingNode.parent !=null){
			if(existingNode.parent.color.equals(RBNodeColor.BLACK)){
				System.out.println(" Rotating Clockwise");
				
				RBNode parent = existingNode.parent;
				
				if(existingNode.parent.parent != null){
					RBNode grandparent = existingNode.parent.parent;
					
					existingNode.parent = grandparent;
					grandparent.leftChild =  existingNode;
					
				}else{
					existingNode.parent = null;
				}
				
				parent.parent = existingNode;
				
				if(existingNode.rightChild != null){
					parent.leftChild = existingNode.rightChild;
				}else{
					parent.leftChild = null;
				}
				
				
				
				existingNode.rightChild = parent;
				
				paint(existingNode, existingNode.rightChild.color); // Invariant, should be black else problem
				paint(existingNode.rightChild, RBNodeColor.RED);
			}
//			else{
//				rotateClockWise(existingNode.parent);
//			}
		}
		
	}

	/**
	 * Rotate antiClockwise on current node's parent.
	 * if current is B 
	 * and branch is 
	 * A->B
	 * and C inserted to become 
	 * A->B->C then rotate left on A so that the branch becomes
	 * B->A
	 * B->C
	 *      
	 */
	void rotateAntiClockWise(RBNode existingNode) {
		if(existingNode.parent !=null ){
			System.out.println(" Rotating Anticlockwise");
			
			RBNode parent = existingNode.parent;
			
			//swap
			RBNode temp1 = existingNode.leftChild;
			temp1.rightChild = existingNode;
			existingNode.leftChild = null;
			existingNode = temp1;
			
			
			if(existingNode.parent.parent != null){
				RBNode grandparent = existingNode.parent.parent;
				
				existingNode.parent = grandparent;
				grandparent.leftChild =  existingNode;
				
			}else{
				existingNode.parent = null;
			}
			
			parent.parent = existingNode;
			
			if(existingNode.rightChild != null){
				parent.rightChild = existingNode.rightChild;
				parent.leftChild = existingNode.rightChild;
			}else{
				parent.rightChild = null;
			}
			
			
			existingNode.leftChild = parent;
			
			paint(existingNode, existingNode.leftChild.color);// Invariant, should be black else problem
			paint(existingNode.leftChild, RBNodeColor.RED);
		}
		
	}
	
	private void inOrderTraverse(RBNode root) {
		if (root != null) {
			inOrderTraverse(root.leftChild);
			System.out.println("  Traversed " + root);
			inOrderTraverse(root.rightChild);
		}
	}

	public static void main(String[] args) {
		RBNode node1 = new RBNode(60);
		RBNode node2 = new RBNode(50);
		RBNode node3 = new RBNode(70);
		RBNode node4 = new RBNode(40);
		RBNode node5 = new RBNode(30);
		RBNode node6 = new RBNode(20);
		RBNode node7 = new RBNode(10);
		RBNode node8 = new RBNode(5);
//		RBNode node9 = new RBNode(55);
//		RBNode node10 = new RBNode(53);
//		RBNode node11 = new RBNode(51);

		RedBlackBSTTry rbTree = new RedBlackBSTTry();
		
		rbTree.insert(node1);
		System.out.println("\n------");
		
		rbTree.insert(node2);
		System.out.println("\n------");
		
		rbTree.insert(node3);
		System.out.println("\n------");

		rbTree.insert(node4);
		System.out.println("\n------");

		rbTree.insert(node5);
		System.out.println("\n------");

		rbTree.insert(node6);
		System.out.println("\n------");

		rbTree.insert(node7);
		System.out.println("\n------");
		
		rbTree.insert(node8);
		System.out.println("\n------");
		
//		rbTree.insert(node9);
//		System.out.println("\n------");
//		
//		rbTree.insert(node10);
//		System.out.println("\n------");
//		
//		rbTree.insert(node11);
//		System.out.println("\n------");
		
		
//		rbTree.inOrderTraverse(rbTree.ROOT);
		System.out.println(rbTree.ROOT.data);

	}

}

class RBNode {
	public Integer 		data;
	public RBNode 		parent;
	public RBNode 		leftChild;
	public RBNode 		rightChild;
	public RBNodeColor 	color;
	
	public void setParent(RBNode parent) {
		this.parent = parent;
	}

	public void setLeftChild(RBNode leftChild) {
		this.leftChild = leftChild;
		leftChild.parent = this;
	}

	public void setRightChild(RBNode rightChild) {
		this.rightChild = rightChild;
		rightChild.parent = this;
	}

	
	
	

	public RBNode(Integer data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		String s = "data: " + data.toString() + " color: " + color;
		
		if(parent!=null){
			 s += " [ parent: " + parent.data + " ] ";
		}
		if(leftChild != null){
			s += " [ leftChild: " + leftChild.data + " ] ";
		}
		if(rightChild != null){
			s += " [ rightChild: " + rightChild.data + " ] ";
		}
		return s;
	}

}

enum RBNodeColor {
	BLACK, RED;
}