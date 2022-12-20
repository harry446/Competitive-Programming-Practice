package second;

import java.util.Scanner;

public class RGPC18P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int N = SC.nextInt();
		double S = SC.nextDouble();
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		double e = 0;
		double f = 0;
		double F = 0;

		for (int i=0; i<N; i++){
			int I = SC.nextInt();
			if (Math.abs(I) <= 50){
				a++;
				f++;
			}
			else if (Math.abs(I) >= 51 && Math.abs(I) <= 100){
				b++;
				f++;
			}
			else if (Math.abs(I) >= 101 && Math.abs(I) <= 150){
				c++;
				f++;
			}
			else if (Math.abs(I) >= 151 && Math.abs(I) <= 200){
				d++;
				f++;
			}
			else if (Math.abs(I) > 200){
				e++;
				f = 0;
			}
			
			if (f>F){
				F = f;
			}
		}
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
//		System.out.println(e);
//		System.out.println(F);
		double total = 1.5*a+b+c+0.5*d-e+0.5*F;
		double increase = total - S;
		System.out.println(increase);
	}
}
