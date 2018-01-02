package com.jatin.tree;

import java.util.ArrayList;
import java.util.HashMap;



/*
11: i
 8: ippi
 5: issippi
 2: ississippi
 1: mississippi
10: pi
 9: ppi
 7: sippi
 4: sissippi
 6: ssippi
 3: ssissippi

     |(1:mississippi)|leaf
tree:|
	 |
	 |
	 |
     |             |(6:ssippi)|leaf
     |     |(3:ssi)|
     |     |       |(9:ppi)|leaf
     |(2:i)|
     |     |
     |     |(9:ppi)|leaf
     |
     |
     |
     |
     |     |      |(6:ssippi)|leaf
     |     |(4:si)|
     |     |      |(9:ppi)|leaf
     |(3:s)|
     |     |     |(6:ssippi)|leaf
     |     |(5:i)|
     |     |     |(9:ppi)|leaf
     |
     |
     |
     |
     |     |(10:pi)|leaf
     |(9:p)|
     |     |(11:i)|leaf
7 branching nodes
 */

public class SuffixTree {
	SuffixTreeNode root = new SuffixTreeNode();

	public static void main(String[] args) {

		String testString = "mississippi";
		SuffixTree tree = new SuffixTree(testString);

		String[] stringList = { "is", "sip", "hi", "sis" };

		for (String s : stringList) {
			ArrayList<Integer> list = tree.getIndexes(s);
			if (list != null) {
				System.out.println(s + ": " + list.toString());
			}
		}

	}

	public SuffixTree(String s) {
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			root.insertString(suffix, i);
		}
	}

	public ArrayList<Integer> getIndexes(String s) {
		return root.getIndexes(s);
	}
}

class SuffixTreeNode {
	
	char value;
	HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
	ArrayList<Integer> indexes = new ArrayList<Integer>();
	
	public void insertString(String s, int index) {
		indexes.add(index);
		if (s != null && s.length() > 0) {
			value = s.charAt(0);
			SuffixTreeNode child = null;
			if (children.containsKey(value)) {
				child = children.get(value);
			} else {
				child = new SuffixTreeNode();
				children.put(value, child);
			}
			String remainder = s.substring(1);
			child.insertString(remainder, index);
		}
	}

	public ArrayList<Integer> getIndexes(String s) {
		if (s == null || s.length() == 0) {
			return indexes;
		} else {
			char first = s.charAt(0);
			if (children.containsKey(first)) {
				String remainder = s.substring(1);
				return children.get(first).getIndexes(remainder);
			}
		}
		return null;
	}
}
