package second;

import java.io.*;
import java.util.*;

public class CCC09S3 {

	@SuppressWarnings("unchecked")
	static LinkedList<Integer>[] graph = new LinkedList[51];
	static boolean[] visited = new boolean[51];
	static int[] dist = new int[51];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=1; i<=50; i++) {
			graph[i] = new LinkedList<>();
		}
		
		graph[1].add(6);
		graph[2].add(6);
		graph[3].add(4);
		graph[3].add(5);
		graph[3].add(6);
		graph[3].add(15);
		graph[4].add(3);
		graph[4].add(5);
		graph[4].add(6);
		graph[5].add(3);
		graph[5].add(4);
		graph[5].add(6);
		graph[6].add(1);
		graph[6].add(2);
		graph[6].add(3);
		graph[6].add(4);
		graph[6].add(5);
		graph[6].add(7);
		graph[7].add(6);
		graph[7].add(8);
		graph[8].add(7);
		graph[8].add(9);
		graph[9].add(8);
		graph[9].add(10);
		graph[9].add(12);
		graph[10].add(9);
		graph[10].add(11);
		graph[11].add(10);
		graph[11].add(12);
		graph[12].add(9);
		graph[12].add(11);
		graph[12].add(13);
		graph[13].add(12);
		graph[13].add(14);
		graph[13].add(15);
		graph[14].add(13);
		graph[15].add(3);
		graph[15].add(13);
		
		graph[16].add(17);
		graph[16].add(18);
		graph[17].add(16);
		graph[17].add(18);
		graph[18].add(16);
		graph[18].add(17);
		
		while (true) {
			String S = read();
			
			if (S.equals("q")) {
				break;
			}
			
			
			if (S.equals("i")) {
				int x = readInt();
				int y = readInt();
				
				if (graph[x].contains(y)) {
					continue;
				}
				
				graph[x].add(y);
				graph[y].add(x);
			}
			else if (S.equals("d")) {
				int x = readInt();
				int y = readInt();
				
				graph[x].remove(new Integer(y));
				graph[y].remove(new Integer(x));
			}
			else if (S.equals("n")) {
				int x = readInt();
				System.out.println(graph[x].size());
			}
			else if (S.equals("f")) {
				int x = readInt();
				bfs(x);
				
				int count = 0;
				for (int i=1; i<=50; i++) {
					if (dist[i] == 2) {
						count++;
					}
				}
				
				System.out.println(count);
			}
			else {
				int x = readInt();
				int y = readInt();
				bfs(x);
				
				if (!visited[y]) {
					System.out.println("Not connected");
				}
				else {
					System.out.println(dist[y]);
				}
			}
		}
		
	}
	
	public static void bfs (int s) {
		dist = new int[51];
		visited = new boolean[51];
		Queue<Integer> q = new LinkedList<>();
		dist[s] = 0;
		visited[s] = true;
		q.add(s);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int kids : graph[cur]) {
				if (!visited[kids]) {
					q.add(kids);
					visited[kids] = true;
					dist[kids] = dist[cur]+1;
				}
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
}
