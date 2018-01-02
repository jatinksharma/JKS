package com.jatin.tree;

/*************************************************************************
 *  Compilation:  javac ThreeNode.java
 *
 *************************************************************************/

public class AncestorTree { 
	
    private AncestorTree parent;        // parent
    private AncestorTree left, right;   // two children
    private String value;            // name of node

    // create a leaf node
    public AncestorTree(String value) {
        this.value = value;
    }

    // create and return a new internal centroid node that is the parent of p and q
    public AncestorTree(String value, AncestorTree x, AncestorTree y) {
        if (x.parent != null || y.parent != null)
            throw new RuntimeException("Illegal join operation");
        this.value = value;
        this.left  = x;
        this.right = y;
        x.parent = this;
        y.parent = this;
    }


    // print all leaves in subtree rooted at this node
    public void showLeaves() {
        if (left == null && right == null) System.out.println(this);
        else {
            left.showLeaves();
            right.showLeaves();
        }
    }

    // depth in tree
    public int depth() {
        int depth = 0;
        for (AncestorTree x = this; x.parent != null; x = x.parent)
            depth++;
        return depth;
    }

    // return root of tree
    public AncestorTree root() {
        AncestorTree x = this;
        while (x.parent != null)
            x = x.parent;
        return x;
    }


    // return least common ancestor of p and q, or null if p and q in different components
    public AncestorTree lca(AncestorTree y) {
        AncestorTree x = this;
        int xdepth = x.depth();
        int ydepth = y.depth();
        if (xdepth < ydepth) {
            for (int i = 0; i < ydepth - xdepth; i++) y = y.parent;
        }
        else {
            for (int i = 0; i < xdepth - ydepth; i++) x = x.parent;
        }
        while (x != y) {
            x = x.parent;
            y = y.parent;
        }
        return x;
    }


    // return string representation 
    public String toString() {
       return value;
    }


    /*
				| ZZZZ |
		| DDDDD |		| YYYYY |
					|AAAAA|		|XXXXX|
							|BBBBB|	|CCCCC|
			
     */
    public static void main(String[] args) {
        AncestorTree a = new AncestorTree("AAAAA");
        AncestorTree b = new AncestorTree("BBBBB");
        AncestorTree c = new AncestorTree("CCCCC");
        AncestorTree d = new AncestorTree("DDDDD");


        AncestorTree x = new AncestorTree("XXXXX", b, c);
        AncestorTree y = new AncestorTree("YYYYY", a, x);
        AncestorTree z = new AncestorTree("ZZZZZ", d, y);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
        
        System.out.println("\nRoot is " + x.root());

        System.out.println("\nlca(a, b) = " + a.lca(b));
        System.out.println("lca(c, d) = " + c.lca(d));
        System.out.println("lca(b, c) = " + b.lca(c));
        System.out.println("lca(b, d) = " + b.lca(d));

        System.out.println("Cluster containing b and c");
        b.lca(c).showLeaves();

        System.out.println("Cluster containing a and b");
        a.lca(b).showLeaves();

        System.out.println("Cluster containing d and b");
        d.lca(b).showLeaves();

    }
}