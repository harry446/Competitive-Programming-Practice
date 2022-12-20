package second;

import java.io.*;
import java.util.*;

public class HackerEarthDiskTower {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int next = N;
		for (int i=0; i<N; i++) {
			int d = Integer.parseInt(st.nextToken());
			pq.add(d);
			while (!pq.isEmpty() && pq.peek() == next) {
				System.out.print(pq.poll() + " ");
				next--;
			}
			System.out.println();
		}

		
		
		
	}

}
