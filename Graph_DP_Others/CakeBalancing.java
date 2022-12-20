package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CakeBalancing {

	public static class State {
		int stCur, stOther;
		boolean r;
		
		public State (int stCur, int stOther, boolean r) {
			this.stCur = stCur;
			this.stOther = stOther;
			this.r = r;
		}
	}
	static int L, R, W;
	static int[] sumL, sumR, arL, arR;
	static int[][] dp;
	static ArrayList<Integer>[] paths;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		L = readInt();
		R = readInt();
		W = readInt();
		sumL = new int[1<<L];
		sumR = new int[1<<R];
		arL = new int[L];
		arR = new int[R];
		dp = new int[1<<L][1<<R];
		paths = new ArrayList[1<<Math.max(L, R)];
		
		for (int i=0; i<1<<Math.max(L, R); i++) {
			paths[i] = new ArrayList<>();
		}
		
		for (int i=0; i<L; i++) {
			arL[i] = readInt();
		}
		for (int i=0; i<R; i++) {
			arR[i] = readInt();
		}
		
		for (int i=0; i<(1<<L); i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			sumL[i] = getL(i);
		}
		for (int i=0; i<(1<<R); i++) {
			sumR[i] = getR(i);
		}
		
		// precompute all possible ways of going from state1 to state2 where state2 is just state1 with bits unset
		for (int i=0; i<(1<<Math.max(L, R)); i++) {
			for (int j=0; j<i; j++) {
				if ((i | j) == i) {
					paths[i].add(j);	//valid path -> unset some bits in j
				}
			}
		}
		
		dp[(1<<L) - 1][(1<<R) - 1] = 0;
		Queue<State> q = new LinkedList<>();
		
		q.add(new State((1<<L) - 1, (1<<R) - 1, false));
		q.add(new State((1<<L) - 1, (1<<R) - 1, true));
		
		while (!q.isEmpty()) {
			State cur = q.poll();
			if (cur.r) {
				int stCur = cur.stCur;
				int stOther = cur.stOther;
				
				for (int st : paths[stCur]) {
					if (dp[st][stOther] == Integer.MAX_VALUE && Math.abs(sumL[st] - sumR[stOther]) <= W) {
						dp[st][stOther] = dp[stCur][stOther] + 1;
						q.add(new State(st, stOther, false));
					}
				}
			}
			else {
				int stCur = cur.stOther;
				int stOther = cur.stCur;
				
				for (int st : paths[stCur]) {
					if (dp[stOther][st] == Integer.MAX_VALUE && Math.abs(sumL[stOther] - sumR[st]) <= W) {
						dp[stOther][st] = dp[stOther][stCur] + 1;
						q.add(new State(stOther, st, true));
					}
				}
			}
		}
		
		System.out.println(dp[0][0]);
		
	}
	
	public static int getL (int state) {
		int sum = 0;
		for (int i=0; i<L; i++) {
			if ((state & (1<<i)) > 0) {
				sum += arL[i];
			}
		}
		return sum;
	}
	
	public static int getR (int state) {
		int sum = 0;
		for (int i=0; i<R; i++) {
			if ((state & (1<<i)) > 0) {
				sum += arR[i];
			}
		}
		return sum;
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
	
}
