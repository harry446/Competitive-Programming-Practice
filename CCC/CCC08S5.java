package second;

import java.io.*;
import java.util.*;

public class CCC08S5 {

	public static class Moves {
		int a, b, c, d;
		
		public Moves (int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}
	
	static int[][] choices = new int[5][4];
	static int[] particles = new int[4];
	static Map<String, Integer> dp = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int N = readInt();
		choices[0][0] = 2;
		choices[0][1] = 1;
		choices[0][2] = 0;
		choices[0][3] = 2;
		choices[1][0] = 1;
		choices[1][1] = 1;
		choices[1][2] = 1;
		choices[1][3] = 1;
		choices[2][0] = 0;
		choices[2][1] = 0;
		choices[2][2] = 2;
		choices[2][3] = 1;
		choices[3][0] = 0;
		choices[3][1] = 3;
		choices[3][2] = 0;
		choices[3][3] = 0;
		choices[4][0] = 1;
		choices[4][1] = 0;
		choices[4][2] = 0;
		choices[4][3] = 1;
		
		for (int i=0; i<N; i++) {
			int A = readInt();
			int B = readInt();
			int C = readInt();
			int D = readInt();
			
			particles[0] = A;
			particles[1] = B;
			particles[2] = C;
			particles[3] = D;
			
			dp = new HashMap<>();
			
			int score = miniMax(particles, true);

			if (score == -1) {
				System.out.println("Roland");
			}
			else {
				System.out.println("Patrick");
			}
		}
	}
	
	public static int miniMax (int[] particles, boolean maximizingPlayer) {
		
		if (isTerminalPoint(particles)) {
			if (maximizingPlayer) {
				return -1;
			}
			return 1;
		}
		
		String key = "";
		if (maximizingPlayer) {
			key = "T" + particles[0] + "," + particles[1] + "," + particles[2] + "," + particles[3];
		}
		else {
			key = "F" + particles[0] + "," + particles[1] + "," + particles[2] + "," + particles[3];
		}
		
		if (dp.containsKey(key)) {
			return dp.get(key);
		}
		
		Queue<Moves> queue = availableMoves(particles);	
		
		if (maximizingPlayer) {
			int value = Integer.MIN_VALUE+1;
			
			int index = queue.size();
			for (int i=0; i<index; i++) {
				Moves temp = queue.poll();
				
				int[] particlesCopy = new int[4];
				for (int j=0; j<4; j++) {
					particlesCopy[j] = particles[j];
				}
				
				particlesCopy[0] -= temp.a;
				particlesCopy[1] -= temp.b;
				particlesCopy[2] -= temp.c;
				particlesCopy[3] -= temp.d;
				
				int nodeValue = miniMax(particlesCopy, false);
				
				value = Math.max(value, nodeValue);
				
//				alpha = Math.max(value, alpha);
//				if (value >= beta) {
//					break;
//				}
			}
			
			String S = "T" + particles[0] + "," + particles[1] + "," + particles[2] + "," + particles[3];
			dp.put(S, value);
			
			return value;
		}
		else {
			int value = Integer.MAX_VALUE-1;
			
			int index = queue.size();
			for (int i=0; i<index; i++) {
				Moves temp = queue.poll();
				
				int[] particlesCopy = new int[4];
				for (int j=0; j<4; j++) {
					particlesCopy[j] = particles[j];
				}
				
				particlesCopy[0] -= temp.a;
				particlesCopy[1] -= temp.b;
				particlesCopy[2] -= temp.c;
				particlesCopy[3] -= temp.d;
				
				int nodeValue = miniMax(particlesCopy, true);
				
				value = Math.min(value, nodeValue);
				
//				beta = Math.min(value, beta);
//				if (value <= alpha) {
//					break;
//				}
			}
			
			String S = "F" + particles[0] + "," + particles[1] + "," + particles[2] + "," + particles[3];
			dp.put(S, value);
			
			return value;
		}
		
		
	}

	
	public static boolean isTerminalPoint(int[] particles) {
		for (int i=0; i<5; i++) {
			if (particles[0] >= choices[i][0] && particles[1] >= choices[i][1] && particles[2] >= choices[i][2] && particles[3] >= choices[i][3]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static Queue<Moves> availableMoves(int[] particles) {
		Queue<Moves> moves = new LinkedList<>();
		
		for (int i=0; i<5; i++) {
			if (particles[0] >= choices[i][0] && particles[1] >= choices[i][1] && particles[2] >= choices[i][2] && particles[3] >= choices[i][3]) {
				moves.add(new Moves(choices[i][0], choices[i][1], choices[i][2], choices[i][3]));
			}
		}
		
		return moves;
	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
 
	static String read() {
		while (st == null || !st.hasMoreTokens()) {
			try { st = new StringTokenizer(br.readLine()); 
			} catch (IOException e) {}
		}
		return st.nextToken();
	}
	static int readInt() {
		return Integer.parseInt(read());
	}
	static long readLong() {
		return Long.parseLong(read());
	}
	static double readDouble() {
		return Double.parseDouble(read());
	}
}
