package second;

import java.util.BitSet;
import java.util.Scanner;

public class TLE16Contest1P4MicrowavesAgain {

	static int[] microCount;
	static int[][] dist;
	static boolean[][] use;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		microCount = new int[N+1];
		dist = new int[N+1][N+1];
		
		for (int i=0; i<N+1; i++) {
			for (int j=0; j<N+1; j++) {
				dist[i][j] = 0x3f3f3f3f;
			}
		}
		
		for (int i=1; i<=N; i++) {
			microCount[i] = sc.nextInt();
			dist[i][i] = 0;
		}
		
		for (int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			dist[u][v] = dist[v][u] = w;
		}
		
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		use = new boolean[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (dist[i][j] <= K) {
					use[i][j] = true;
				}
			}
		}
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			for (int j=i+1; j<=N; j++) {
				for (int k=j+1; k<=N; k++) {
					boolean[] cur = new boolean[N+1];
					for (int t=1; t<=N; t++) {
						cur[t] = (use[i][t] | use[j][t] | use[k][t]);
					}
					int sum = 0;
					for (int t=1; t<=N; t++) {
						if (cur[t]) {
							sum += microCount[t];
						}
					}
					answer = Math.max(answer, sum);
				}
			}
		}
		
		System.out.println(answer);
	}

}
