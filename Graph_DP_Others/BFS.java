package second;

import java.util.LinkedList;
import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		LinkedList<Integer> endPage = new LinkedList<Integer>();
		boolean [][] A = new boolean [N][N];              //relationship between pages
		LinkedList<Integer> pages = new LinkedList<Integer>();
		boolean visited[] = new boolean [N];
		
		
		for (int i=0; i<N; i++){
			int n = SC.nextInt();     //now many options(go to next page)
			if (n==0){
				endPage.add(i);
			}
			else {
				for (int j=0; j<n; j++){
					int nextPage = SC.nextInt();
					A[i][nextPage-1] = true;
				}
			}
		}
		
		int[] step = new int [N];
		for (int i=0; i<N; i++){
			step[i] = Integer.MAX_VALUE;
		}
		step[0] = 1;
		pages.add(0);             //Add the first page to the queue
		int minPath = Integer.MAX_VALUE;
		visited[0] = true;
	
		while(!pages.isEmpty()){ //BFS ends when queue is empty
			int p = pages.poll();     //red one page from queue
			
			//get p's neighbors
			for (int i=0; i<N; i++){
				if (A[p][i]==true){
					if (step[i]>step[p]+1){   //only visit when the page is unvisited
						step[i] = step[p] + 1;
						visited[i] = true;
						if (endPage.contains(i)){  //if endPage then end this path
							if (minPath>step[i]){
								minPath = step[i];
							}
						}
						else {
							pages.add(i);
						}
					}
				}
			}
		}
		
		boolean flag = true;
		for (int i=0; i<N; i++){
			if (visited[i]==false){
				flag = false;
				break;
			}
		}
		
		if (flag){
			System.out.println("Y");
		}
		else {
			System.out.println("N");
		}
		System.out.println(minPath);
		
		
		
		
		
		
		
	}
}


