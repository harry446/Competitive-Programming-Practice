package second;

import java.io.*;
import java.util.*;

public class CCC02S4 {

	static class Pair {
		String name;
		int speed;
		
		public Pair (String name, int speed) {
			this.name = name;
			this.speed = speed;
		}
		
	}
	
	static int M, Q;
//	static Queue<Pair> q = new LinkedList<>();
	static int[] dp, list;
	static Pair[] people;
	
//	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		M = readInt();
		Q = readInt();
		
		people = new Pair[Q+1];
		list = new int[Q+1];
		dp = new int[Q+1];
		Arrays.fill(dp, 0x3f3f3f3f);
		
		for (int i=0; i<Q; i++) {
			people[i] = new Pair(read(), readInt());
		}
		
		dp[0] = 0;
		for (int i=0; i<=Q; i++) {
			int cur = Integer.MIN_VALUE;
			for (int j=1; j<=M; j++) {
//				if (j+i-1 >= Q) {
//					break;
//				}
//				System.out.println("i: " + i + ", j: " + j);
				cur = Math.max(cur, people[Math.min(i+j-1, Q-1)].speed);
				if (dp[i]+cur < dp[Math.min(i+j, Q)]) {
					dp[Math.min(i+j, Q)] = dp[i] + cur;
					list[Math.min(i+j, Q)] = j;
				}
			}
		}
		
//		for (int i=0; i<Q; i++) {
//			list[i] = new LinkedList<>();
//		}
		
//		for (int i=0; i<Q; i++) {
//			q.add(new Pair(read(), readInt()));
//		}
		
		
//		System.out.println("Total Time: " + find(q, 0));
		
//		for (int i=0; i<=Q; i++) {
//			System.out.print(list[i] + " ");
//		}
//		System.out.println();
		
		System.out.println("Total Time: " + dp[Q]);
		int[] line = new int[Q+1];
		int num = Q;
		int x = 1;
		while (true) {
			if (list[num] == 0) {
//				System.out.println(num);
				break;
			}
			line[x] = list[num];
			num -= list[num];	
			x++;
		}
		
//		for (int i=0; i<=Q; i++) {
//			System.out.print(line[i] + " ");
//		}
//		System.out.println(x);
		
		int count = 0;
		for (int i=x-1; i>=0; i--) {
			for (int j=0; j<line[i]; j++) {
				System.out.print(people[count].name + " ");
				count++;
			}
			System.out.println();
		}
//		for (int i=0; i<Q; i++) {
//			if (list[i] == null) {
//				continue;
//			}
//			for (String k : list[i]) {
//				System.out.print(k + " ");
//			}
//			System.out.println();
//		}
		
//		for (int i=1; i<=Q; i++) {
//			System.out.print(time[i] + " ");
//		}
		
	}
	
//	public static int find (Queue<Pair> queue, int count) {
//		
//		Queue<Pair> queueTemp = new LinkedList<>();
//		for (Pair temp : queue) {
//			queueTemp.add(temp);
//		}	
//		
//		if (queueTemp.size() == 0) {
//			return 0;
//		}
////		if (queueTemp.size() == 1) {
////			Pair temp = queueTemp.poll();
//////			System.out.println("YES " + temp.name);
////			return temp.speed;
////		}
//		
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
//		
//		LinkedList<String> removed = new LinkedList<>();
//		int size = queueTemp.size();
//		for (int i=1; i<=Math.min(M, size); i++) {
////			System.out.println("i: " + i);
//			Pair temp = queueTemp.poll();
//			removed.add(temp.name);
//			max = Math.max(max, temp.speed);
////			System.out.println("max: " + max + ", queueTemp size: " + queueTemp.size());
////			for (Pair l : queueTemp) {
////				System.out.println(l.name + ": " + l.speed);
////			}
//			int speed = find(queueTemp, count+i) + max;
//
//			System.out.println("count:" + count + ", i: " + i + ", time[count+1]: " + time[count+1] + ", speed: " + speed);
//			if (time[count+1] > speed) {
////				min = speed;
//				time[count+1] = speed;
//				list[count+i] = i;
//				
//				System.out.println("i2: " + i + ", count+1: " + (count+1) + ", min: " + time[count+1]);
//				System.out.println("list: ");
//				for (int k=1; k<=Q; k++) {
//					System.out.print(list[k] + " ");
//				}
//				System.out.println();
//				
////				list[depth] = removed;
////				list[depth].add(temp.name);
////				System.out.println("Depth: " + depth);
////				for (String S : list[depth]) {
////					System.out.print(S + " ");
////				}
////				System.out.println();
////				for (int j=0; j<list[depth].size()-i; j++) {
////					list[depth].remove(j);
////				}
////				for (String S : list[depth]) {
////					System.out.print(S + " ");
////				}
////				System.out.println();
//			}
//			min = Math.min(min, speed);
//			for (int j=1; j<=Q; j++) {
//				System.out.print(time[j] + " ");
//			}
//			System.out.println();
////			min = Math.min(min, find(queueTemp)+max);
////			System.out.println("min: " + min);
//		}
////		System.out.println("Fmin: " + min);
//		
//		
//		System.out.println("return min: " + min);
//		return min;
//	}

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
