package second;

import java.util.Scanner;

public class CCC04J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] adj = new String[n];
		String[] noun = new String[m];
		
		for (int i=0; i<n; i++) {
			adj[i] = sc.next();
		}
		for (int i=0; i<m; i++) {
			noun[i] = sc.next();
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				System.out.println(adj[i] + " as " + noun[j]);
			}
		}
		
	}

}
