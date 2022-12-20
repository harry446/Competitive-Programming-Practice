package second;

import java.util.*;

public class CCO12P1 {

	static int W, D, V, t;
	static boolean flag;
	static int[] digits;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		W = sc.nextInt();
		D = sc.nextInt();
		digits = new int[D];
		
		for (int i=0; i<D; i++) {
			digits[i] = sc.nextInt();
		}
		
		V = sc.nextInt();
		for (int i=0; i<V; i++) {
			t = sc.nextInt();
			flag = false;
			
			for (int j=0; j<D; j++) {
				if (find(digits[j], 0)) {
					System.out.println("Y");
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				System.out.println("N");
			}
			
		}
	}

	public static boolean find (int n, int count) {
		if (count == W && n == t) {
			return true;
		}

		if (n > t || count > W) {
			return false;
		}

		for (int i=0; i<D; i++) {
			if (n != 0 && find(n*digits[i], count+1)) {
				return true;
			}
			if (find(n+digits[i], count+1)) {
				return true;
			}
		}
		return false;
	}
}
