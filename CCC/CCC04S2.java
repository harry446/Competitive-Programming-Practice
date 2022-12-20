package second;

import java.io.*;
import java.util.*;

public class CCC04S2 {

	public static class Pair implements Comparable<Pair>{
		int score, name;
		
		public Pair (int score, int name) {
			this.score = score;
			this.name = name;
		}

		public int compareTo(Pair o) {
			if (score > o.score) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = readInt();
		int k = readInt();
		
		int[] score = new int[n];
		int[] history = new int[n];
		Arrays.fill(history, Integer.MIN_VALUE);
		
		for (int i=0; i<k; i++) {
			for (int j=0; j<n; j++) {
				score[j] += readInt();
			}
			
			for (int j=0; j<n; j++) {
				int count = 1;
				for (int l=0; l<n; l++) {
					if (score[l] > score[j]) {
						count++;
					}
				}
				history[j] = Math.max(history[j], count);
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			max = Math.max(max, score[i]);
		}
		
		for (int i=0; i<n; i++) {
			if (score[i] == max) {
				System.out.println("Yodeller " + (i+1) + " is the TopYodeller: score " + score[i] + ", worst rank " + history[i]);
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
