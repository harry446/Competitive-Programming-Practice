package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCO00P1 {

//	static ArrayList<Integer>[] adj, sets;
	static int[] adj, sets;
	static boolean[] visited, input;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
//		adj = new ArrayList[26];
//		sets = new ArrayList[26];
		adj = new int[26];
		sets = new int[26];
		input = new boolean[26];
		
//		for (int i=0; i<26; i++) {
//			adj[i] = new ArrayList<>();
//			sets[i] = new ArrayList<>();
//		}
		
		for (int i=0; i<N; i++) {
			int a = read().charAt(0) - 'A';
			read();
			int b = read().charAt(0);
			
			input[a] = true;
			
			if (b < 'a') {
//				adj[a].add(b-'A');
				adj[a] |= 1<<(b-'A');
				input[b-'A'] = true;
			}
			else {
				sets[a] |= 1<<(b-'a');
//				sets[a].add(b-'a');
			}
			
//			if (b < 'a') {
//				adj[a].add(b-'A');
//				input[b-'A'] = true;
//			}
//			else {
//				sets[a].add(b-'a');
//			}
		}
		
		for (int i=0; i<26; i++) {
			if (!input[i]) {
				continue;
			}

			visited = new boolean[26];
			int ans = dfs(i, 0);

			ArrayList<Character> temp = new ArrayList<>();
			for (int j=0; j<26; j++) {
				if ((ans & (1<<j)) > 0) {
					temp.add((char)(j + 'a'));
				}
			}
			
			System.out.println((char)(i + 'A') + " = " + temp.toString().replace("[", "{").replace("]", "}").replace(" ", ""));
		}
	}

	public static int dfs (int s, int ans) {
		visited[s] = true;
//		ArrayList<Integer> cur = adj[s];
		
//		for (int k : sets[s]) {
//			ans |= 1<<(k);
//		}
		
		for (int i=0; i<26; i++) {
			if ((sets[s] & (1<<i)) > 0) {
				ans |= 1<<i;
			}
		}
		
		for (int i=0; i<26; i++) {
			if ((adj[s] & (1<<i)) > 0 && !visited[i]) {
				ans = dfs(i, ans);
			}
		}
//		for (int kids : cur) {
//			if (!visited[kids]) {
//				ans = dfs(kids, ans);
//			}
//		}
		
		return ans;
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
