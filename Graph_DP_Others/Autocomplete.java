package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Autocomplete {

//	public static class Node {
//		Node[] ch;
//		public Node () {
//			ch = new Node[26];
//		}
//	}
	
	public static class Node {
		Map<Character, Node> map;
		public Node () {
			map = new HashMap<>();
		}
	}
	
	static int T, N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		T = readInt();
		int temp = T;
		while (T-- > 0) {
			N = readInt();
			Node root = new Node();
			int ans = 0;
			
			for (int i=0; i<N; i++) {
				String S = read();
				ans += insert(root, S);
			}
			System.out.printf("Case #%d: %d\n", temp-T, ans);
		}
		
		
	}
	
	public static int insert (Node root, String S) {
		Node cur = root;
		boolean prefix = true;
		int count = 0;
		
		for (int i=0; i<S.length(); i++) {
//			int c = S.charAt(i) - 'a';
			char c = S.charAt(i);
			if (prefix) {	//if current word already exist
				count++;
			}
			
//			if (cur.ch[c] == null) {
//				cur.ch[c] = new Node();
//				prefix = false;
//			}
//			cur = cur.ch[c];
			
			if (cur.map.get(c) == null) {
				cur.map.put(c, new Node());
				prefix = false;
			}
			cur = cur.map.get(c);
		}
		return count;
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
