/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author Nevine
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import pkg1.EightPuzzleGame;
import pkg1.Node;

public class DFS extends EightPuzzleGame{
	private Node node;
	public DFS(ArrayList input){
		int temp=0;
		pathToGoal= new ArrayList<String>();
		node = new Node(input);
		game();
	}
	
	private int flag=0;
	Stack<Node>frontier;
	Stack<Node>expanded;
	private void game(){
		Node newChildNode=null;
		ArrayList<Integer> winingStete = new ArrayList<Integer>();
		winingStete.addAll(Arrays.asList(new Integer[]{0,1,2,3,4,5,6,7,8}));
		char[] movement;
		Node state=null;
		Stack frontier = new Stack();
		Queue<Node> expanded;
                expanded = new LinkedList<Node>();
		
		frontier.add(node);
		while(!frontier.isEmpty()){
			state = (Node) frontier.pop();
			expanded.add(state);
			if(checkGoal(state,winingStete)==true)
				return;	
			zeroIndex= state.zeroPlace;
			lastMov=state.lastMovment;
			movement=movementDirections();
			for(int i=movement.length-1;i>=0;i--){
				if(movement[i]=='U')
					newChildNode=replace(state,zeroIndex,zeroIndex-3,movement[i]);
				else if(movement[i]=='D')
					newChildNode=replace(state,zeroIndex,zeroIndex+3,movement[i]);
				else if(movement[i]=='L')
					newChildNode=replace(state,zeroIndex,zeroIndex-1,movement[i]);
				else if(movement[i]=='R')
					newChildNode=replace(state,zeroIndex,zeroIndex+1,movement[i]);
				if(!contains(expanded,newChildNode)&&!containsStack(frontier,newChildNode))
						frontier.add(newChildNode);
			}
			nodesExpanded++;
			
					pathToGoal.add(((Node)frontier.peek()).lastMovment+"");
			
		}
	
	}
}
