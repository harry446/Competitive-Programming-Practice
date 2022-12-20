package second;

import java.util.*;

public class HackerEarthPrintingPatterns {
	
	public static class Pair {
		int ROW, COL;
		public Pair (int r1, int c1) {
			ROW = r1;
			COL = c1;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int r = SC.nextInt();
		int c = SC.nextInt();
		int CR = SC.nextInt();
		int CC = SC.nextInt();
		
		int[][] graph = new int[r][c];
		boolean[][] visited = new boolean[r][c];
		LinkedList<Pair> queue = new LinkedList<>();
		
		graph[CR][CC] = 0;
		visited[CR][CC] = true;
		queue.add(new Pair(CR, CC));
		
		while (!queue.isEmpty()) {
			Pair temp = queue.pop();
			int R = temp.ROW;
			int C = temp.COL;

			//Top -> r-1
			if (R-1 >= 0 && !visited[R-1][C]) {
				graph[R-1][C] = graph[R][C]+1;
				queue.add(new Pair(R-1, C));
				visited[R-1][C] = true;
			}
			//Top Right -> r-1 c+1
			if (R-1 >= 0 && C+1 < c && !visited[R-1][C+1]) {
				graph[R-1][C+1] = graph[R][C]+1;
				queue.add(new Pair(R-1, C+1));
				visited[R-1][C+1] = true;
			}
			//Right -> c+1
			if (C+1 < c && !visited[R][C+1]) {
				graph[R][C+1] = graph[R][C]+1;
				queue.add(new Pair(R, C+1));
				visited[R][C+1] = true;
			}
			//Bottom Right -> r+1 c+1
			if (R+1 < r && C+1 < c && !visited[R+1][C+1]) {
				graph[R+1][C+1] = graph[R][C]+1;
				queue.add(new Pair(R+1, C+1));
				visited[R+1][C+1] = true;
			}
			//Bottom -> r+1
			if (R+1 < r && !visited[R+1][C]) {
				graph[R+1][C] = graph[R][C]+1;
				queue.add(new Pair(R+1, C));
				visited[R+1][C] = true;
			}
			//Bottom Left -> r+1 c-1
			if (R+1 < r && C-1 >= 0 && !visited[R+1][C-1]) {
				graph[R+1][C-1] = graph[R][C]+1;
				queue.add(new Pair(R+1, C-1));
				visited[R+1][C-1] = true;
			}
			//Left -> c-1
			if (C-1 >= 0 && !visited[R][C-1]) {
				graph[R][C-1] = graph[R][C]+1;
				queue.add(new Pair(R, C-1));
				visited[R][C-1] = true;
			}
			//Top Left -> r-1 c-1
			if (R-1 >= 0 && C-1 >= 0 && !visited[R-1][C-1]) {
				graph[R-1][C-1] = graph[R][C]+1;
				queue.add(new Pair(R-1, C-1));
				visited[R-1][C-1] = true;
			}
		}
		
		for (int row=0; row<r; row++) {
			for (int col=0; col<c; col++) {
				System.out.print(graph[row][col] + " ");
			}
			System.out.println();
		}
	}

}
