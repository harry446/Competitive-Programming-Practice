package second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DMOJMarchContest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
//		//p0
//		int a = SC.nextInt();
//		int b = SC.nextInt();
//		int c = SC.nextInt();
//		
//		if (a+b>c && a+c>b && b+c>a) {
//			System.out.println("yes");
//			return;
//		}
//		System.out.println("no");
		
//		//p1
//		double x1 = SC.nextInt();
//		int y1 = SC.nextInt();
//		int x2 = SC.nextInt();
//		int y2 = SC.nextInt();
//		int X1 = SC.nextInt();
//		int Y1 = SC.nextInt();
//		int X2 = SC.nextInt();
//		int Y2 = SC.nextInt();
//		
//		if (x2-x1 == 0 && X2-X1 == 0) {
//			if (x2 == X2 && x1 == X1) {
//				System.out.println("coincident");
//			}
//			else {
//				System.out.println("parallel");
//			}
//			return;
//		}
//		
//		if (x2-x1 == 0) {
//			double M = (Y2-Y1)/(X2-X1) + 0.0;
//			double B = Y1 - M*X1 + 0.0;
//			System.out.print((double)(Math.round(x1*1000000)/1000000) + " ");
//			System.out.println(df2.format((double)x1));
//			System.out.println((double)(Math.round((M*x1 + B)*1000000)/1000000) + " ");
//			return;
//		}
//		
//		if (X2-X1 == 0) {
//			double m = (y2-y1)/(x2-x1) + 0.0; 
//			double b = y1 - m*x1 + 0.0;
//			System.out.print((double)(Math.round(X1*1000000)/1000000) + " ");
//			System.out.println(df2.format(X1));
//			System.out.println((double)(Math.round((m*X1 + b)*1000000)/1000000) + " ");
//			return;
//		}
//		
//		double m = (y2-y1)/(x2-x1) + 0.0; 
//		double M = (Y2-Y1)/(X2-X1) + 0.0;
//		double b = y1 - m*x1 + 0.0;
//		double B = Y1 - M*X1 + 0.0;
//		
////		System.out.println(m + "m");
////		System.out.println(M + "M");
////		System.out.println(b + "b");
////		System.out.println(B + "B");
//		
//		if (m == M && b == B) {
//			System.out.println("coincident");
//		}
//		else if (m == M) {
//			System.out.println("parallel");
//		}
//		else {
//			double ans = (double)(Math.round((B-b)/(m-M)*1000000))/1000000;
//			double Ans = (B-b)/(m-M);
//			System.out.print(ans + " ");
//			System.out.print((double)(Math.round((Ans*x1+b)*1000000))/1000000);
//		}
		
		
//		//p2
//		int a = SC.nextInt();
//		int b = SC.nextInt();
//		
//		for (int i=2; i<b; i++) {
//			b = b*i;
//		}
//		
//		
		
		//p3
		
//		String[] Re = br.readLine().split(" ");
//		int S = Integer.parseInt(Re[0]);
//		int M = Integer.parseInt(Re[1]);
//		String num = br.readLine();
//		
//		for (int i=0; i<M; i++) {
//			String[] re = br.readLine().split(" ");
//			int l = Integer.parseInt(re[0]);
//			int r = Integer.parseInt(re[1]);
//			
//			String newNum = "";
//			int total = 0;
//			
//			
//			for (int j=0; j<num.length(); j++) {
//				if (j+1 >= l && j+1 <= r) {
//					newNum += 1;
//					continue;
//				}
//				newNum += num.charAt(j);
//			}
//			num = newNum;
//			
//			for (int j=0; j<num.length(); j++) {
//				if (newNum.charAt(j) != '0') {
//					total += modulo(1, num.length()-j-1);
//				}
//			}
//			System.out.println(total);
//			
//		}
//		br.close();
//		
//	}
//	
//	public static int modulo(int total, int n) {
//		int mod = 1000000007;
//		
//		if (n == 0) {
//			return total;
//		}
//		total = ((total%mod) * 2)%mod;
//		return modulo(total, n-1);
//		
		
		int input = SC.nextInt();
		int Previous = input;
		
		int count = 0;
		while (input != 0) {
			input = SC.nextInt();
			
			if (Previous == input) {
				count++;
			}
			
			Previous = input;
		}
		
		System.out.println(count);
		
	}

}
