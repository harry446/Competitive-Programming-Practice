package second;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CCC13J5S3 {

	static int[] points = new int[4];
	static int[][] games = new int[2][6];
	static Set<String> gamesPlayed = new HashSet<String>();
	static int won = 0;
	static int T;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		T = sc.nextInt();
		int G = sc.nextInt();
		
		int col = 0;
		for (int i=1; i<4; i++) {
			for (int k=i+1; k<=4; k++) {
				games[0][col] = i;
				games[1][col] = k;
				col++;
			}
		}
		
		for (int i=0; i<G; i++) {
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			int SA = sc.nextInt();
			int SB = sc.nextInt();
			
			gamesPlayed.add(A + "#" + B);
			
			if (SA > SB) {
				points[A] += 3;
			}
			else if (SA < SB) {
				points[B] += 3;
			}
			else {
				points[A] += 1;
				points[B] += 1;
			}
		}
		
//		System.out.print("INITIAL: ");
//		for (int i=0; i<4; i++) {
//			System.out.print(points[i] + " ");
//		}
//		System.out.println();
		
		
		backtrack(0);
		
		System.out.println(won);
		
		
	}
	
	public static boolean winner() {
		for (int i=0; i<4; i++) {
			if (i == T-1) {
				continue;
			}
			
			if (points[i] >= points[T-1]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void backtrack (int k) {
		if (k >= 6) {
			if (winner()) {
//				for (int i=0; i<4; i++) {
//					System.out.print(points[i] + " ");
//				}
//				System.out.println();
//				
				won++;
			}
			return;
		}
		
		int team1 = games[0][k]-1;
		int team2 = games[1][k]-1;
		
		if (gamesPlayed.contains(team1 + "#" + team2)) {
			backtrack(k+1);
			return;
		}
		
		points[team1] += 3;
		backtrack(k+1);
		
		points[team1] -= 3;
		points[team2] += 3;
		backtrack(k+1);
		
		points[team2] -= 3;
		points[team1] += 1;
		points[team2] += 1;
		backtrack(k+1);
		
		points[team1] -= 1;
		points[team2] -= 1;
		
		return;
	}

}
