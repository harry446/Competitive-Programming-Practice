package second;

import java.util.*;

public class HackerEarthPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int n = SC.nextInt();
		boolean[] visited = new boolean[n+1];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i=1; i<=n; i++) {
			map.put(i, SC.nextInt());
		}
		
		int count = 0;
		
		for (int i=1; i<=n; i++) {
			int next;
			
			if (!visited[i]) {
				visited[i] = true;
				
				if (i == map.get(i)) {
					continue;
				}
				else {
					int c = map.get(i);
				
				while (!visited[c]) {
					visited[c] = true;
					next = map.get(c);
					c = next;
					++count;
				}
				}
				
				
			}
		}
		
		System.out.println(count);
	}

}
