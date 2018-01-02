package com.jatin.graph.boggle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* 
 * BOARD_MAP
 * <a: (1,1),(2,1)>
 * <b: (1,2)>
 * <c: (1,3)>
 * <d: (1,4)>
 * <e: (2,2),(4,1),(4,2)>
 * <x: (2,3),(2,4)>
 * <m: (3,1)>
 * <l: (3,2),(3,3)>
 * <h: (3,4)>
 * <p: (4,3)>
 * <y: (4,4)>
 * 
 * find("alex")
 * 
 * for every 2 characters, get the positions and put in List1, List2, List3, List4
 *  - run for 1st of List1, List2, List3, List4 - IF neighbors
 *  
 * 
 */
public class Boggle2 {

	static Map<String, List<Cell>> BOARD_MAP = new HashMap<String, List<Cell>>();
	
	static String[][] BOARD = 
							{
								{"a", "b", "c", "d"}, 
								{"a", "e", "x", "x"},
								{"m", "l", "l", "h"},
								{"e", "e", "p", "y"}
							};
	
	public Boggle2() {
		convertMatrixToMultiMap();
	}
	
	public static void main(String[] args) {
		Boggle2 boggle = new Boggle2();
		boggle.find("alex");
	}
	
	public boolean find(String word){
		boolean found = false;
		
		List<List<Cell>> lstOfEveryLetterOccurences = new ArrayList<List<Cell>>();
		for(int i=0; i< word.length(); i++){
			String letter = Character.toString(word.charAt(i));
			List<Cell> lstOfALetterOccurences = BOARD_MAP.get(letter);
			lstOfEveryLetterOccurences.add(i, lstOfALetterOccurences);
		}
		
		System.out.println(lstOfEveryLetterOccurences);
		
		// for every letter in the word, check if i+1 in
		
		return found;
	}
	
	/*public boolean find(String s, List<Cell> cellsWithLetter){
		boolean found = false;
		if(s == null){
			return true;
		}
		
		if(null == cellsWithLetter){
			cellsWithLetter = BOARD_MAP.get(Character.toString(s.charAt(0)));
		}
		for(Cell c : cellsWithLetter){
			List<Cell> lstNeighbors = findWhichNeighborContains(c , Character.toString(s.charAt(1)));
			if(lstNeighbors == null || lstNeighbors.isEmpty()){
				found = true;
			}else{
				found = false;
			}
			return found && find(s.substring(1), lstNeighbors);
		}
		return found;
		
	}
	
	private List<Cell> findWhichNeighborContains(Cell currNode, String nextLetter){
		List<Cell> lstNeighbors = new ArrayList<Cell>();
		List<Cell> lstnextLetterPositions = BOARD_MAP.get(nextLetter);
		for(Cell c: lstnextLetterPositions){
			//check if neighbor of currNode
			if( (Math.abs(c.x - currNode.x) == 1 ) && (Math.abs(c.y - currNode.y) == 1 ) ){
				lstNeighbors.add(c);
			}
		}
		return lstNeighbors;
	}*/
	
	private static void convertMatrixToMultiMap() {
		for(int i=0; i< BOARD.length ; i++){
			for(int j =0 ; j< BOARD.length ; j++){
				if(BOARD_MAP.containsKey(BOARD[i][j])){
					Cell c = new Cell(i, j, BOARD[i][j]);
					BOARD_MAP.get(BOARD[i][j]).add(c);
				}else{
					List<Cell> lst = new ArrayList<Cell>();
					Cell c = new Cell(i, j, BOARD[i][j]);
					lst.add(c);
					BOARD_MAP.put(BOARD[i][j], lst);
				}
			}
		}
		
		System.out.println(BOARD_MAP);
		
	}
	
}

class Cell{
	public int x;
	public int y;
	public String data;
	public Cell(int x, int y, String data) {
		this.x = x;
		this.y = y;
		this.data = data;
	}
	
	@Override
	public String toString() {
		
//		return "(x:" + x + ",y:" + y + ")";
		return "(" + x + "," + y + ")";
	}
	
	
}