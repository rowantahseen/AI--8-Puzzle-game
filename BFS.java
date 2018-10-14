package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import puzzleGame.EightPuzzleGame;
import puzzleGame.Node;

public class BFS extends EightPuzzleGame{
	private Node node;
	public BFS(ArrayList input){
		int temp=0;
		pathToGoal= new ArrayList<String>();
		node = new Node(input);
		game();
	}
	
	private int flag=0;
	Queue<Node>frontier;
	Queue<Node>expanded;
	private void game(){
		Node newChildNode=null;
		ArrayList<Integer> winingStete = new ArrayList<Integer>();
		winingStete.addAll(Arrays.asList(new Integer[]{0,1,2,3,4,5,6,7,8}));
		char[] movement;
		Node state=null;
		frontier = new LinkedList<Node>();
		expanded = new LinkedList<Node>();
		
		frontier.add(node);
		while(!frontier.isEmpty()){
			state = frontier.poll();
			expanded.add(state);
			if(checkGoal(state,winingStete)==true)
				return;	
			zeroIndex= state.zeroPlace;
			lastMov=state.lastMovment;
			movement=movementDirections();
			for(int i=0;i<movement.length;i++){
				if(movement[i]=='U')
					newChildNode=replace(state,zeroIndex,zeroIndex-3,movement[i]);
				else if(movement[i]=='D')
					newChildNode=replace(state,zeroIndex,zeroIndex+3,movement[i]);
				else if(movement[i]=='L')
					newChildNode=replace(state,zeroIndex,zeroIndex-1,movement[i]);
				else if(movement[i]=='R')
					newChildNode=replace(state,zeroIndex,zeroIndex+1,movement[i]);
				if(!contains(expanded,newChildNode)&&!contains(frontier,newChildNode))
						frontier.add(newChildNode);
			}
			nodesExpanded++;
			if(frontier.peek().depth>state.depth){
				if(flag==0){
					pathToGoal.add(frontier.peek().lastMovment+"");
					flag=1;
				}
				else
					pathToGoal.add(state.lastMovment+"");
			}
		}
	
	}
}
