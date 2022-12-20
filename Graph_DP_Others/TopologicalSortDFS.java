package second;

import java.util.*;

public class TopologicalSortDFS {

	static int n;
	static ArrayList<Integer> adj[];
	static boolean visited[];
	static ArrayList<Integer> ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Given with a directed graph with n vertices and m edges. You have the number of vertices so
		//that ever edge leads from the vertex with a smaller number assigned to the vertex with a large one.
		
		//A permutation of the vertices (topological ordering) --> corresponds to the graph.
		
		//***
		//Assume that the graph is acyclic (no loop) (If there is a loop it wont work)
		Scanner sc = new Scanner (System.in);
		
		n = sc.nextInt();
		adj = new ArrayList[n+1];			//Store adjacent kids
		visited = new boolean[n+1];			//Visited array
		ans = new ArrayList<>();			//Store answer (need to reverse it at the end)
		
		//input
		
		
	}

	public static void topoSort () {
		for (int i=1; i<=n; i++) {
			if (!visited[i]) {		//loops through all unreachable nodes (or basically the branches with no prerequisites)
				dfs(i);
			}
		}
	}
	
	//runs dfs
	public static void dfs (int n) {
		visited[n] = true;
		for (int v : adj[n]) {
			if (!visited[v]) {
				dfs(v);
			}
		}
		
		ans.add(n);		//AFTER finishing all the kids, add the node to the answer (it will be in reverse order)
	}
}
