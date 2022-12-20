package second;

import java.io.*;
import java.util.*;

public class CCC07J5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A = readInt();
		int B = readInt();
		int N = readInt();
		ArrayList<Integer> motels = new ArrayList<>();
		motels.add(0);
		motels.add(990);
		motels.add(1010);
		motels.add(1970);
		motels.add(2030);
		motels.add(2940);
		motels.add(3060);
		motels.add(3930);
		motels.add(4060);
		motels.add(4970);
		motels.add(5030);
		motels.add(5990);
		motels.add(6010);
		motels.add(7000);
		
		for (int i=0; i<N; i++) {
			motels.add(readInt());
		}
		Collections.sort(motels);
		
		long[] dp = new long[motels.size()];
		
		dp[0] = 1;
		for (int i=0; i<motels.size(); i++) {
			for (int j=0; j<i; j++) {
				if (motels.get(i)-motels.get(j) >= A && motels.get(i)-motels.get(j) <= B) {
					dp[i] += dp[j];
				}
			}
		}
		
		System.out.println(dp[motels.size()-1]);
		
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

}
