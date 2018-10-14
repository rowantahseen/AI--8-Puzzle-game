package puzzleGame;

import java.util.ArrayList;
import java.util.Arrays;

import bfs.BFS;

public class TestGame {

	public static void main(String[] args) {
		/*
		 change test cases from array input of ArrayList
		 
		->	1,2,5,3,4,0,6,7,8	<-
		->	6,1,8,4,0,2,7,3,5	<-
		->	8,6,4,2,1,3,5,7,0	<-
		->	8,6,7,2,5,4,3,0,1	<-
		
		 */
		ArrayList <Integer>input = new ArrayList<Integer>(Arrays.asList(new Integer[]{6,1,8,4,0,2,7,3,5}));
		callBFS(input);

	}
	
	public static void callBFS(ArrayList <Integer> input){
		Long time=System.currentTimeMillis();
		BFS testBFS = new BFS(new ArrayList <Integer>(input));
		System.out.println("path_to_goal: "+testBFS.pathToGoal.toString());
		System.out.println("cost_of_path: "+testBFS.costOfPath);
		System.out.println("nodes_expanded: "+testBFS.nodesExpanded);
		System.out.println("search_depth: "+testBFS.searchDepth);
		testBFS.runningTime=((double)(System.currentTimeMillis()-time)/1000);
		System.out.println("running_time: "+testBFS.runningTime);
	}

}
