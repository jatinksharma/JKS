package com.jatin.graph;


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Copyright ( c) Richard Creamer 2008 - All Rights Reserved
////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Basic (undirected) Graph1 - Edge - Node1 classes that allow generation of random Graph1s
//No edges allowed to/from same Node1.
//No more than one edge allowed per Node1 pair.
//Node1s having degree == 0 allowed.
////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class GraphTest {
    public static void main(String[] args) {
        test1();
//		test2();
    }

    // //////////////////////
    private static void test1() {
        for (int Node1Count = 0; Node1Count < 5; ++Node1Count) {
            for (int edgeCount = -1; edgeCount <= Node1Count * 10; ++edgeCount) {
                try {
                    System.out
                            .println("\n----- Test case Node1Count: "
                                    + Node1Count + " edgeCount: " + edgeCount
                                    + " -----");
                    System.out.flush();
                    test(Node1Count, edgeCount, true);
                } catch (Exception e) {
                    System.out.println("Graph1 creation failed: "
                            + e.getMessage());
                }
            }
        }
        System.out.flush();
    }

    // //////////////////////
    private static void test2() {
        int Node1Count = 10000;
        int edgeCount = Node1Count * 10;
        System.out.println("\n----- Test case Node1Count: " + Node1Count
                + " edgeCount: " + edgeCount + " -----");
        test(Node1Count, edgeCount, false);
    }

    // //////////////////////
    private static void test(int Node1Count, int edgeCount, boolean dumpGraph1) {
        Graph1 rg = Graph1.createRandomGraph1(Node1Count, edgeCount);
        if (!dumpGraph1)
            System.out.print(rg.getGraph1Summary());
        // Dump degree historgram
        int maxDegree = rg.computeMaxDegree();
        for (int i = 0; i <= maxDegree; ++i) {
            int Node1CountWithDegree = rg.countNode1sWithDegree(i);
            System.out.println("Node1s with degree " + i + ": "
                    + Node1CountWithDegree);
        }
        // Test for self-looping Node1s
        System.out.println("Exists self-loops: " + rg.hasSelfLoops());
        if (dumpGraph1)
            System.out.print(rg.toStringVerbose());
    }
}

// ////////////////////////////////////////////////////////////////////////////

final class Graph1 {

    private SortedMap<String, Node1> Node1Map = null;
    private Map<String, Edge> edgeMap = null;

    public Graph1() {
        Node1Map = new TreeMap<String, Node1>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        edgeMap = new HashMap<String, Edge>();
    }

    // //////////////////////
    public static Graph1 createRandomGraph1(int Node1Count, int edgeCount) {
        if (Node1Count < 1 || edgeCount < 0)
            throw new IllegalArgumentException(
                    "Node1Count must be >= 1 and edgeCount must be >= 0!");
        Random rnGen = new Random(System.currentTimeMillis());
        int maxEdges = getMaxEdgesForGraph1(Node1Count);
        if (edgeCount > maxEdges)
            throw new IllegalArgumentException("Input edgeCount (" + edgeCount
                    + ") exceeds maximum possible edges for Graph1 with "
                    + Node1Count + " Node1s!");
        // Create empty Graph1 object
        Graph1 g = new Graph1();
        // Create temp array to hold Node1 keys - required for getRandomEdge()
        String[] Node1Keys = new String[Node1Count];
        // Create and add Node1List
        for (int i = 0; i < Node1Count; ++i) {
            String Node1Id = Integer.toString(g.getNode1Count());
            Node1Keys[i] = Node1Id;
            Node1 n = new Node1(Node1Id);
            g.addNode1(n); // Let list index be Node1's id
        }
        // Create and add edgeList
        for (int i = 0; i < edgeCount; ++i) {
            Edge e = Graph1.getRandomEdge(rnGen, g, Node1Keys);
            g.addEdge(e);
        }
        return g;
    }

    // //////////////////////
    public void addNode1(Node1 n) {
        if (n == null)
            throw new IllegalArgumentException("Argument must be non-null!");
        if (Node1Map.get(n.getId()) != null)
            throw new IllegalArgumentException(
                    "Attempt to add Node1 with duplicate id <" + n.getId() + ">");
        Node1Map.put(n.getId(), n);
    }

    // //////////////////////
    private static Edge getRandomEdge(Random rnGen, Graph1 g, String[] keys) {
        if (g.getNode1Count() < 2)
            throw new IllegalStateException(
                    "Attempt to add edge when < 2 Node1s are in Graph1!");
        if (keys == null || keys.length != g.getNode1Count())
            throw new IllegalArgumentException(
                    "keys argument null or wrong size!");
        Node1 n1 = null;
        Node1 n2 = null;
        Edge retEdge = null;
        while (true) {
            n1 = g.Node1Map.get(keys[rnGen.nextInt(g.getNode1Count())]);
            n2 = g.Node1Map.get(keys[rnGen.nextInt(g.getNode1Count())]);
            if (n1 == n2) // Skip if already have edge between these two Node1s
                continue;
            String id = Edge.computeDefaultEdgeId(n1, n2);
            if (g.edgeMap.get(id) != null)
                continue;
            retEdge = new Edge(n1, n2, id);
            break;
        }
        return retEdge;
    }

    // //////////////////////
    public void addEdge(Edge e) {
        if (edgeMap.get(e.getId()) != null)
            throw new IllegalStateException(
                    "Attemp to add edge wiith duplicate id <" + e.getId() + ">");
        edgeMap.put(e.getId(), e);
        e.getN1().incrementDegree();
        e.getN2().incrementDegree();
    }

    // //////////////////////
    public int getNode1Count() {
        return Node1Map.size();
    }

    // //////////////////////
    public int getEdgeCount() {
        return edgeMap.size();
    }

    // //////////////////////
    public int countNode1sWithDegree(int degree) {
        int sum = 0;
        for (Node1 n : Node1Map.values())
            if (n.getDegree() == degree)
                ++sum;
        return sum;
    }

    // //////////////////////
    public int computeMaxDegree() {
        int maxDegree = 0;
        for (Node1 n : Node1Map.values()) {
            if (maxDegree < n.getDegree())
                maxDegree = n.getDegree();
        }
        return maxDegree;
    }

    // //////////////////////
    public String getGraph1Summary() {
        StringBuffer sb = new StringBuffer();
        sb.append("Graph1 Object Summary:\n");
        sb.append("\tNode1 Count: " + getNode1Count() + "\n");
        sb.append("\tEdge Count: " + getEdgeCount() + "\n");
        return sb.toString();
    }

    // //////////////////////
    public String toStringVerbose() {
        StringBuffer sb = new StringBuffer();
        sb.append("Graph1 Object Dump:\n");
        sb.append("\tNode1 Count: " + getNode1Count() + "\n");
        sb.append("\tEdge Count: " + getEdgeCount() + "\n");
        sb.append("\tNode1s: \n");
        int Node1Index = 0;
        for (Node1 n : Node1Map.values())
            sb.append("\t\tNode1[ " + Node1Index++ + " ]: " + n.toString() + "\n");
        sb.append("\tEdges: \n");
        int edgeIndex = 0;
        for (Edge e : edgeMap.values())
            sb.append("\t\tEdge[ " + edgeIndex++ + " ]: " + e.toString() + "\n");
        return sb.toString();
    }

    // //////////////////////
    public static int getMaxEdgesForGraph1(int Node1Count) {
        if (Node1Count < 0)
            throw new IllegalArgumentException("Node1Count must be >= 0!");
        if (Node1Count == 0)
            return 0;
        int n = Node1Count - 1;
        // Use math formula sum of first n integers where n here is Node1Count -
        // 1
        int maxEdges = (n * n + n) / 2;
        return maxEdges;
    }

    // //////////////////////
    public boolean hasSelfLoops() {
        for (Edge e : edgeMap.values())
            if (e.getN1() == e.getN2())
                return true;
        return false;
    }
}

// ////////////////////////////////////////////////////////////////////////////

final class Node1 implements Comparable<Node1> {

    private final String id;
    private int degree = 0;

    private Node1() {
        id = null;
    }

    // //////////////////////
    public Node1(String id) {
        this.id = id;
    }

    // //////////////////////
    public String getId() {
        return id;
    }

    // //////////////////////
    public synchronized int getDegree() {
        return degree;
    }

    // //////////////////////
    public int compareTo(Node1 n) {
        return getId().compareTo(n.getId());
    }

    // //////////////////////
    public synchronized void incrementDegree() {
        ++degree;
    }

    // //////////////////////
    @Override
    public synchronized String toString() {
        return "Node1: id: " + id + " degree: " + degree;
    }
}

// ////////////////////////////////////////////////////////////////////////////

final class Edge {
    private final Node1 n1;
    private final Node1 n2;
    private final String id;

    private Edge() {
        n1 = n2 = null;
        id = null;
    }

    // //////////////////////
    public Edge(Node1 n1, Node1 n2, String id) {
        if (n1 == null || n2 == null)
            throw new IllegalArgumentException("Node1s must not be null!");
        if (n1 == n2)
            throw new IllegalArgumentException(
                    "Argument Node1s must not be the same Node1!");
        this.n1 = n1;
        this.n2 = n2;
        this.id = (id == null) ? computeDefaultEdgeId(n1, n2) : id;
    }

    // //////////////////////
    public String getId() {
        return id;
    }

    // //////////////////////
    public static String computeDefaultEdgeId(Node1 n1, Node1 n2) {
        if (n1 == null || n2 == null)
            throw new IllegalArgumentException("Arguments must not be null!");
        if (n1 == n2)
            throw new IllegalArgumentException(
                    "Argument Node1s must be for different Node1s!");
        if (n1.compareTo(n2) < 0)
            return n1.getId() + ":" + n2.getId();
        else
            return n2.getId() + ":" + n1.getId();
    }

    // //////////////////////
    public Node1 getN1() {
        return n1;
    }

    // //////////////////////
    public Node1 getN2() {
        return n2;
    }

    // //////////////////////
    @Override
    public String toString() {
        return "Edge id: " + id + " n1: " + n1.getId() + " n2: " + n2.getId();
    }
}
