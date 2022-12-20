package second;

import java.util.*;

public class DWITE07R14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int H = sc.nextInt();
		int S = sc.nextInt();
		int[] heights = new int[S+1];
		int[] dp = new int[H+1];
		
		for (int i=1; i<=S; i++) {
			heights[i] = sc.nextInt();
		}
		
		Arrays.fill(dp, 0x3f3f3f3f);
		dp[0] = 0;
		
		for (int i=1; i<=S; i++) {
			for (int j=H; j>=heights[i]; j--) {
				if(dp[j-heights[i]] != 0x3f3f3f3f) {
					dp[j] = Math.min(dp[j], dp[j-heights[i]]+1);
				}
			}
		}
		
		if (dp[H] == 0x3f3f3f3f) {
			System.out.println(0);
		}
		else {
			System.out.println(dp[H]);
		}
		
	}

}
