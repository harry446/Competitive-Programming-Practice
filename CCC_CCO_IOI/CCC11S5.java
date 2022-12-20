package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC11S5 {

	static int K;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		K = readInt();
		int a = 0;
		boolean[] vis = new boolean[1<<K];
		
		for (int i=0; i<K; i++) {
			a |= (readInt()<<i);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		int dist = 0;
		vis[a] = true;
		
		while (!q.isEmpty()) {
			
			int size = q.size();
				
			while (size-- > 0) {
				int cur = q.poll();
			
				if (cur == 0) {
					System.out.println(dist);
					return;
				}
			
				for (int i=0; i<K; i++) {
					if ((cur & (1<<i)) == 0) {
						int v = process(cur | 1<<i);
					
						if (!vis[v]) {
							vis[v] = true;
							q.add(v);
						}
					
					}
				}
			}
			
			dist++;
		}
		
		System.out.println(dist);
		
	}
	
	public static int process (int n) {
		int count = 0;
		
		for (int i=0; i<=K; i++) {
			if ((n & (1<<i)) > 0) {	
				count++;
				continue;
			}
			else if (count >= 4) {
				int mask = ((1<<count) - 1) << (i-count);
				n ^= mask;
				return n;
			}
			count = 0;
		}
		return n;
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
