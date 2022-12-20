package second;

import java.io.*;
import java.util.*;

public class CCC00S3 {

	static Map<String, LinkedList<String>> graph = new HashMap<>();
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int N = readInt();
		
		for (int i=0; i<N; i++) {
			String S = read();
			if (!graph.containsKey(S)) {
			    graph.put(S, new LinkedList<>());
			}
			
			String S2 = readLine();
			while (!S2.equals("</HTML>")) {
				for (int j=0; j<S2.length()-8; j++) {
					if (S2.substring(j, j+8).equals("<A HREF=")) {
//						int index = -1;
						int index = S2.indexOf("\">", j);
						
//						for (int k=j+9; k<S2.length(); k++) {
//							if (S2.charAt(k) == '"') {
//								index = k;
//								break;
//							}
//						}
//						System.out.println("W: " + w + ", index: " + index);
						
						System.out.println("Link from " + S + " to " + S2.substring(j+9, index));
						graph.get(S).add(S2.substring(j+9, index));
					}
				}
				
				S2 = readLine();
			}
		}
		
//		for (String S : graph.keySet()) {
//			for (String kids : graph.get(S)) {
//				System.out.println("Link from " + S + " to " + kids);
//			}
//		}
		
		while (true) {
			String S1 = readLine();
			if (S1.equals("The End")) {
				break;
			}
			String S2 = readLine();
			
			dfs(S1);
			
			if (set.contains(S2)) {
				System.out.println("Can surf from " + S1 + " to " + S2 + ".");
			}
			else {
				System.out.println("Can't surf from " + S1 + " to " + S2 + ".");
			}
			set = new HashSet<>();
		}
		
		
	}
	
	public static void dfs (String s) {
		set.add(s);
		LinkedList<String> cur = graph.get(s);
		
		if (cur == null) {
			return;
		}
		
		for (String kids : cur) {
			if (!set.contains(kids)) {
				dfs(kids);
			}
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
