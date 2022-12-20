package second;

import java.util.LinkedList;
import java.util.Scanner;

public class MonkAndTheIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int T = SC.nextInt();


		for (int i=0; i<T; i++){
			int N = SC.nextInt();
			boolean [][] A = new boolean [N][N];


			int M = SC.nextInt();

			for (int j=0; j<M; j++){
				int X = SC.nextInt()-1;
				int Y = SC.nextInt()-1;
				A[X][Y] = true;
				A[Y][X] = true;
			}

			int [] step = new int [N];
			for (int j=0; j<N; j++) {
				step[j] = Integer.MAX_VALUE;
			}
			//start BFS
			LinkedList<Integer> queue = new LinkedList<Integer>();

			int b = 0;
			int e = N-1;
			queue.add(b);
			step[b] = 0;

			while(!queue.isEmpty()){
				int n = queue.poll();
				for (int j=0; j<N; j++){
					if (A[n][j]){
						if (step[j]>step[n]+1){
							step[j] = step[n]+1;
							queue.add(j);
						}
					}
				}
			}
			
			System.out.println(step[e]);

		}




	}

}
