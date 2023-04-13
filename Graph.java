package hw_1_q1_224;
import java.util.*;
public class Graph {
	static Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();	// Here I am creating ajacency list
	
	
	static void addEdge(int x, int y){ 			// This method connects the vertices each other in the graph
		v.get(x).add(y);
		v.get(y).add(x);
	}											// *********************************************************
	
	static void createGraph() {					// This method creates the graph with a great number so we are fine
		for(int i = 0; i < 100; i++)
		{
			v.add(new Vector<Integer>());
		}
	}											// *********************************************************
	
	
	static void printPath(Vector<Integer> stack)			// This method prints the path that is asked
	{
		
		for(int i = 0; i < stack.size() - 1; i++)
		{
			System.out.print(stack.get(i) + "  ");
		}
		System.out.println(stack.get(stack.size() - 1));
	}														// *********************************************
	
	
	// in DFS method there are some additional parameters to find the total time
	// and total airports that are visited
	static void DFS(boolean vis[], int x, int y, Vector<Integer> stack, int roadTime, int loadingTime)// DFS of graph recursively from 
	{																								  // a given vertex x to y.
		stack.add(x);
		if (x == y)			// if we reach the vertex that is asked, it prints the path and makes the necessary calculations
		{
			System.out.println(stack.size());
			printPath(stack);
			System.out.println(((stack.size()-1)*roadTime +((2*loadingTime-roadTime)*(stack.size()-2)) ));
			return;
		}
		vis[x] = true;
	
			
		if (v.get(x).size() > 0)
		{
			for(int j = 0; j < v.get(x).size(); j++)
			{
			
				
				if (vis[v.get(x).get(j)] == false)			// if the node is not visited recursively call itself
				{
					DFS(vis, v.get(x).get(j), y, stack, roadTime, loadingTime);
				}
			}
		}
		
		stack.remove(stack.size() - 1);
	}
	

	static void DFSCall(int x, int y, int n,									// The actual method that is called in main
						Vector<Integer> stack, int roadTime, int loadingTime)
	{
	
		// visited array
		boolean vis[] = new boolean[n + 1];
		Arrays.fill(vis, false);
		DFS(vis, x, y, stack, roadTime,  loadingTime);
	}
	
	
}
