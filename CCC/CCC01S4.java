package second;

import java.util.*;

public class CCC01S4 {

	public static class Pair {
		int x, y;
		
		public Pair (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		Pair[] nums = new Pair[n];

		for (int i=0; i<n; i++) {
			nums[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		
		double min = -1.0;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				for (int k=j+1; k<n; k++) {
					 double a = Math.sqrt(Math.pow(nums[i].x - nums[j].x, 2) + Math.pow(nums[i].y - nums[j].y, 2));
					 double b = Math.sqrt(Math.pow(nums[j].x - nums[k].x, 2) + Math.pow(nums[j].y - nums[k].y, 2));
					 double c = Math.sqrt(Math.pow(nums[k].x - nums[i].x, 2) + Math.pow(nums[k].y - nums[i].y, 2));
					 double s = (a+b+c) / 2;
					 
					 double dist = 0;
					 if (s == 0 || a*a+b*b-c*c < 0 || b*b+c*c-a*a < 0 || c*c+a*a-b*b < 0) {
						dist = Math.max(Math.max(a, b), c);
					 }
					 else {
					 	dist = (a*b*c) / (2*Math.sqrt(s*(s-a)*(s-b)*(s-c)));
					 }
					 min = Math.max(min, dist);
				}
			}
		}
		    
			
			
		System.out.printf("%.2f", min);
		
	}

}
