package puzzleGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Node{
	public char lastMovment;
	public ArrayList <Integer> gameBoard;
	public int zeroPlace;
	public int depth;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Node(ArrayList input){
		gameBoard=new ArrayList<Integer>();
		gameBoard.addAll(input);
		zeroPlace = gameBoard.indexOf(0);	
		lastMovment='F';
		depth=0;
		}
	public Node(Node state){
		gameBoard=new ArrayList<Integer>();
		gameBoard.addAll(state.gameBoard);
		zeroPlace = state.zeroPlace;
	}
}
