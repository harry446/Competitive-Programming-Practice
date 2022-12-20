package second;

import java.io.*;
import java.util.*;

public class CCC02S4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int m = readInt();
		int n = readInt();
		String[] name = new String[n];
		int[] time = new int[n];
		
		for (int i=0; i<n; i++) {
			name[i] = read();
			time[i] = readInt();
		}
		
		// determine the best times
		int [] best = new int [n + 1];
		int [] group = new int [n + 1];
		for (int i = 0 ; i < n + 1 ; i++)
		{
		    best [i] = 1000000;
		    group [i] = -1;
		}
		best [0] = 0;
		group [0] = 0;
		for (int i = 0 ; i < n + 1 ; i++)
		{
		    int cur = 0;
		    for (int j = 1 ; j <= m && i + j - 1 < n ; j++)
		    {
		    	System.out.println("i: " + i + ", j: " + j);
		    	cur = Math.max (cur, time [i + j - 1]);
		    	if (best [i] + cur < best [i + j])
		    	{
		    		best [i + j] = best [i] + cur;
		    		group [i + j] = j;
		    	}
		    }
		}

		for (int i=0; i<=n; i++) {
			System.out.print(group[i] + " ");
		}
		System.out.println();
		
		System.out.println ("Total Time: " + best [n]);

		// to get the groups, work backward thru group creating
		// the dividing lines. Then use those lines (in reverse order)
		// to print the solution.
		int [] lines = new int [n + 1];
		int k = n;
		int x = 0;
		while (group [k] != 0) {
		    lines [x++] = group [k];
		    k = k - group [k];
		}
		
		for (int i=0; i<=n; i++) {
			System.out.print(lines[i] + " ");
		}
		System.out.println();
		int z = 0;
		for (int i = x - 1 ; i >= 0 ; i--) {
		    for (int j = 0 ; j < lines [i] ; j++) {
		    	System.out.print (name [z++] + " ");
		    }
		    System.out.println ();
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
