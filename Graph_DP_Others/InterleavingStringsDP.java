package second;

import java.util.Scanner;

public class InterleavingStringsDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();
		
		boolean[][] dp = new boolean[A.length()+1][B.length()+1];	//let dp[i][j] = is a pref. of C of len. i+j, an interleaving for A(0, i) and B(0, j)
		dp[0][0] = true;
		
		for (int i=0; i<=A.length(); i++) {
			for (int j=0; j<=B.length(); j++) {
				if (i>0 && A.charAt(i-1) == C.charAt(i+j-1) && dp[i-1][j]) {
					dp[i][j] = true;
				}
				else if (j>0 && B.charAt(j-1) == C.charAt(i+j-1) && dp[i][j-1]) {
					dp[i][j] = true;
				}
			}
		}
		
		for (int i=0; i<=A.length(); i++) {
			for (int j=0; j<=B.length(); j++) {
				System.out.print(dp[i][j] ? "1 ":"0 ");
			}
			System.out.println();
		}
		System.out.println(dp[A.length()][B.length()]);
	}

}
