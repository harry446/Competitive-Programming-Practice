package second;

import java.io.*;
import java.util.*;

public class CCO15P4 {

	static class Pair {
		int f, s;
		
		public Pair (int f, int s) {
			this.f = f;
			this.s = s;
		}
	}
	
	static char[][] grid;
	static int[][] inDegree;
	static ArrayList<Pair>[][] adj;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		Reader sc = new Reader();
//		int R = sc.nextInt();
//		int C = sc.nextInt();
		
		int R = readInt();
		int C = readInt();
		grid = new char[R][C];
		inDegree = new int[R][C];
		adj = new ArrayList[R][C];
		Queue<Pair> q = new LinkedList<>();
		
//		sc.readLine();
		
		for (int i=0; i<R; i++) {
//			grid[i] = sc.readLine().toCharArray();
			grid[i] = read().toCharArray();
			Arrays.fill(inDegree[i], -1);
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				adj[i][j] = new ArrayList<>();
			}
		}
		
		//construct inDegree and Adjacency List
		for (int row=0; row<R; row++) {
			for (int col=0; col<C; col++) {
				if (grid[row][col] == '.') {
					continue;
				}
				
				inDegree[row][col] = 0;
				if (grid[row][col] == 'N') {
					for (int i=row-1; i>=0; i--) {
						if (grid[i][col] != '.') {
							adj[i][col].add(new Pair(row, col)); 
							inDegree[row][col]++;
						}
						else if (grid[i][col] == 'N') {
							break;
						}
					}
				}
				else if (grid[row][col] == 'S') {
					for (int i=row+1; i<R; i++) {
						if (grid[i][col] != '.') {
							adj[i][col].add(new Pair(row, col)); 
							inDegree[row][col]++;
						}
						else if (grid[i][col] == 'S') {
							break;
						}
					}
				}
				else if (grid[row][col] == 'E') {
					for (int i=col+1; i<C; i++) {
						if (grid[row][i] != '.') {
							adj[row][i].add(new Pair(row, col)); 
							inDegree[row][col]++;
						}
						else if (grid[i][col] == 'E') {
							break;
						}
					}
				}
				else {
					for (int i=col-1; i>=0; i--) {
						if (grid[row][i] != '.') {
							adj[row][i].add(new Pair(row, col)); 
							inDegree[row][col]++;
						}
						else if (grid[i][col] == 'W') {
							break;
						}
					}
				}
				
				if (inDegree[row][col] == 0) {
					q.add(new Pair(row, col));
				}
				
			}
		}
		
//		for (int i=0; i<R; i++) {
//			for (int j=0; j<C; j++) {
//				if (inDegree[i][j] == 0) {
//					q.add(new Pair(i, j));
//				}
//			}
//		}
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			System.out.println("(" + cur.f + "," + cur.s + ")");
			for (Pair kids : adj[cur.f][cur.s]) {
				inDegree[kids.f][kids.s]--;
				if (inDegree[kids.f][kids.s] == 0) {
					q.add(kids);
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
	
	
//	static class Reader { 
//        final private int BUFFER_SIZE = 1 << 16; 
//        private DataInputStream din; 
//        private byte[] buffer; 
//        private int bufferPointer, bytesRead; 
//  
//        public Reader() { 
//            din = new DataInputStream(System.in); 
//            buffer = new byte[BUFFER_SIZE]; 
//            bufferPointer = bytesRead = 0; 
//        } 
//  
//        public Reader(String file_name) throws IOException { 
//            din = new DataInputStream(new FileInputStream(file_name)); 
//            buffer = new byte[BUFFER_SIZE]; 
//            bufferPointer = bytesRead = 0; 
//        } 
//  
//        public String readLine() throws IOException { 
//            byte[] buf = new byte[64]; // line length 
//            int cnt = 0, c; 
//            while ((c = read()) != -1) { 
//                if (c == '\n') {
//                	break; 
//                } 
//                buf[cnt++] = (byte) c; 
//            } 
//            return new String(buf, 0, cnt); 
//        } 
//  
//        public int nextInt() throws IOException { 
//            int ret = 0; 
//            byte c = read(); 
//            while (c <= ' ') {
//            	c = read(); 
//            }
//                
//            boolean neg = (c == '-'); 
//            if (neg) {
//            	c = read(); 
//            }
//                
//            do { 
//                ret = ret * 10 + c - '0'; 
//            }  
//            while ((c = read()) >= '0' && c <= '9'); 
//  
//            if (neg) {
//            	return -ret; 
//            }
//            
//            return ret; 
//        } 
//  
//        public long nextLong() throws IOException { 
//            long ret = 0; 
//            byte c = read(); 
//            while (c <= ' ') {
//            	c = read(); 
//            }   
//            boolean neg = (c == '-'); 
//            if (neg) {
//            	c = read(); 
//            } 
//            do { 
//                ret = ret * 10 + c - '0'; 
//            } 
//            while ((c = read()) >= '0' && c <= '9'); 
//            if (neg) {
//            	return -ret; 
//            }  
//            return ret; 
//        } 
//  
//        public double nextDouble() throws IOException 
//        { 
//            double ret = 0, div = 1; 
//            byte c = read(); 
//            while (c <= ' ') {
//            	c = read(); 
//            }
//            boolean neg = (c == '-'); 
//            if (neg) {
//            	c = read(); 
//            }
//
//            do { 
//                ret = ret * 10 + c - '0'; 
//            } 
//            while ((c = read()) >= '0' && c <= '9'); 
//  
//            if (c == '.') { 
//                while ((c = read()) >= '0' && c <= '9') { 
//                    ret += (c - '0') / (div *= 10); 
//                } 
//            } 
//  
//            if (neg) {
//            	return -ret; 
//            }  
//            return ret; 
//        } 
//  
//        private void fillBuffer() throws IOException { 
//            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
//            if (bytesRead == -1) {
//            	buffer[0] = -1; 
//            }
//        } 
//  
//        private byte read() throws IOException { 
//            if (bufferPointer == bytesRead) {
//            	fillBuffer(); 
//            }
//            return buffer[bufferPointer++]; 
//        } 
//  
//        public void close() throws IOException { 
//            if (din == null) {
//            	return; 
//            } 
//            din.close(); 
//        } 
//    }
}
