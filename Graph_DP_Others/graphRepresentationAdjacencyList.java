package second;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class graphRepresentationAdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		Map<Integer, LinkedList<Integer> > graph = new HashMap<>();
		int n = SC.nextInt();
		int e = SC.nextInt();
		
		for(int k=0; k<e; k++){
			int x = SC.nextInt();
			int y = SC.nextInt();
			if( !graph.containsKey(x) ){
				
				graph.put(x, new LinkedList<Integer>());
			}	
			graph.get(x).add(y);
			if( !graph.containsKey(y) ){
				
				graph.put(y, new LinkedList<Integer>());
			}	
			graph.get(y).add(x);

		} 

		//the graph (adjacency list) was created!

	}

}
