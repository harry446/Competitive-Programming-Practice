package second;

import java.io.*;
import java.util.*;

public class MinimumSpanningTree {

	static class Edge implements Comparable<Edge> {
		int n1, n2, w;
	
		public Edge (int n1, int n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		
		public int compareTo (Edge other) {
			return w - other.w;
		}
	}
	
	static ArrayList<Edge> edges;
	static int[] par;
	static int[] rank;
	
	
	static final int infinity = 0x3f3f3f3f;
	static final long linfinity = 0x3f3f3f3f3f3f3f3fL;
	static final int MOD = 1000000007;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		par = new int[N+1];
		rank = new int[N+1];
		edges = new ArrayList<>();
		
		for (int i=1; i<=N; i++) {
			makeSet(i);
		}
		
		for (int i=1; i<=M; i++) {
			int u = readInt();
			int v = readInt();
			int w = i;
			edges.add(new Edge(u, v, w));
		}
		
		Collections.sort(edges);
		
		ArrayList<Integer> ans = new ArrayList<>();
		for (Edge e : edges) {
			int n1 = e.n1;
			int n2 = e.n2;
			int w = e.w;
			
			if (union(n1, n2)) {
				ans.add(w);
			}
		}
		
		if (ans.size() == N-1) {
			for (int i : ans) {
				System.out.println(i);
			}
		}
		else {
			System.out.println("Disconnected Graph");
		}
	}
	
	public static void makeSet (int n) {
		par[n] = n;
		rank[n] = 1;
	}
	
	public static int find (int n) {
		if (par[n] == n) {
			return n;
		}
		return par[n] = find(par[n]);
	}
	
	public static boolean union (int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			if (rank[a] < rank[b]) {
				par[a] = b;
			}
			else {
				if (rank[a] == rank[b]) {
					rank[a]++;
				}
				par[b] = a;
			}
			return true;
		}
		return false;
	}
	
	
	//-------------------------
	public static long fastPow (int a, int b) {
		if (b == 0) {
			return 1;
		}
		
		long t = fastPow(a, b/2) % 10;
		if (b%2 == 1) {
			return (t*t*a%10) % 10;	//extra 1 a because of rounding
		}
		else {
			return (t*t) % 10;
		}
	}
	//-------------------------
	
	//-------------------------
	public static long fastMul (int a, int b) {
		if (b == 2) {
			return 2*a;
		}
		if (b == 1) {
			return a;
		}
			
		long t = fastMul(a, b/2) % 10;
		if (b%2 == 1) {
			return (t+t+a%10) % 10;	//extra 1 a because of rounding
		}
		else {
			return (t+t) % 10;
		}
	}
	//-------------------------
	
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

	
	
	
	
	static class Reader { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) { 
                if (c == '\n') {
                	break; 
                } 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') {
            	c = read(); 
            }
                
            boolean neg = (c == '-'); 
            if (neg) {
            	c = read(); 
            }
                
            do { 
                ret = ret * 10 + c - '0'; 
            }  
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) {
            	return -ret; 
            }
            
            return ret; 
        } 
  
        public long nextLong() throws IOException { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') {
            	c = read(); 
            }   
            boolean neg = (c == '-'); 
            if (neg) {
            	c = read(); 
            } 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) {
            	return -ret; 
            }  
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') {
            	c = read(); 
            }
            boolean neg = (c == '-'); 
            if (neg) {
            	c = read(); 
            }

            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') { 
                while ((c = read()) >= '0' && c <= '9') { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) {
            	return -ret; 
            }  
            return ret; 
        } 
  
        private void fillBuffer() throws IOException { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) {
            	buffer[0] = -1; 
            }
        } 
  
        private byte read() throws IOException { 
            if (bufferPointer == bytesRead) {
            	fillBuffer(); 
            }
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException { 
            if (din == null) {
            	return; 
            } 
            din.close(); 
        } 
    }
	
	
}
