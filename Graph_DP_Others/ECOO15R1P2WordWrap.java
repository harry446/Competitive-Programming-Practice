package second;

import java.io.*;
import java.util.*;

public class ECOO15R1P2WordWrap {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        for(int i=0; i<10; i++) {
           int N = readInt();
           String[] S = readLine().split(" ");
           
           int curLength = 0;
           for (int j=0; j<S.length; j++) {
        	   if (curLength != 0) {
        		   curLength++;
        	   }
        	   
        	   if (S[j].length() + curLength > N && curLength == 0) {
        		   System.out.println(S[j].substring(0, N));
        		   S[j] = S[j].substring(N);
        		   j--;
        		   curLength = 0;
        		   continue;
        	   }
        	   
        	   if (S[j].length() + curLength > N) {
        		   System.out.println();
        		   j--;
        		   curLength = 0;
        		   continue;
        	   }
        	   
        	   if (curLength != 0) {
        		   System.out.print(" ");
        	   }
        	   System.out.print(S[j]);
        	   curLength += S[j].length();
           }
           
           System.out.println();
           System.out.println("=====");

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
