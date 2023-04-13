package hw_1_q1_224;

import java.util.Scanner;
import java.util.Vector;



public class Main {

	
	public static void main(String[] args)
	{
		Graph v = new Graph();			// Creating graph
		
		v.createGraph();
	
		
		Vector<Integer> stack = new Vector<Integer>();				
		
		
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		String[] inputNumbers= input.split(" ");
		int [] givenValues= new int[4];
		for(int i=0; i<4;i++) {												// ********************************
			givenValues[i]=Integer.parseInt(inputNumbers[i]);				// Here I am taking the input from the user
		}																	// (First line only)
		for(int k =0; k< givenValues[1];k++) {								// ********************************
			String edges= keyboard.nextLine();
			String [] edgesArray = edges.split(" ");						// in this for loop I am creating the edges 
			int [] addingEdges= new int[2];									// between vertices
			addingEdges[0]=Integer.parseInt(edgesArray[0]);					// By using split and parseInt I am converting
			addingEdges[1]=Integer.parseInt(edgesArray[1]);					// String input to integer value
			v.addEdge(addingEdges[0], addingEdges[1]);
		}																	// ********************************
		String road= keyboard.nextLine();
		String [] roadArray=road.split(" ");				
		int beggining = Integer.parseInt(roadArray[0]);						// Here I am doing same thing for
		int ending = Integer.parseInt(roadArray[1]);						// starting and ending points
		
		// Function Call
		v.DFSCall(beggining, ending, givenValues[0], stack, givenValues[3], givenValues[2]);	// Calling the function
	}																							// that is going to run the program
	
	
	
	


}
