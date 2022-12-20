package second;

import java.io.*;
import java.util.*;

public class CCC05S4 {
	
	static Map<String, Integer> rank;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int L = readInt();
		
		for (int k=0; k<L; k++) {
			int N = readInt();
			rank = new HashMap<>();
			//rank.put("Home", 0);
			int preRank = 0;
			String[] name = new String[N];
			
			for (int j=0; j<N; j++) {
				name[j] = read();
			}
			String base = name[N-1];
			rank.put(base, 0);
			
			for (int j=0; j<N; j++) {
				String curName = name[j];
				if (rank.containsKey(curName)) {
					preRank = rank.get(curName);
					continue;
				}
				
				int curRank = preRank + 1;
				
				rank.put(curName, curRank);
				preRank = curRank;
			}
			
			int max = -1;
			for (String names : rank.keySet()) {
				max = Math.max(max, rank.get(names));
			}
			//System.out.println(max);
			
			int ans = (N-max*2)*10;
			if (ans < 0) {
				ans = 0;
			}
			System.out.println(ans);
		}
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
