package second;

import java.util.*;

public class CCC01S4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		double a, b, c, s, d, ans;
		double[] x, y;
		int n;
		x = new double [10];
		y = new double [10];
		
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			x[i] = sc.nextDouble();
			y[i] = sc.nextDouble();
		}
		
		ans = 0;
		for (int i = 0 ; i < n ; i++)
		    for (int j = i + 1 ; j < n ; j++)
			for (int k = j + 1 ; k < n ; k++)
			{
			    a = Math.sqrt ((x [i] - x [j]) * (x [i] - x [j]) + (y [i] - y [j]) * (y [i] - y [j]));
			    b = Math.sqrt ((x [j] - x [k]) * (x [j] - x [k]) + (y [j] - y [k]) * (y [j] - y [k]));
			    c = Math.sqrt ((x [k] - x [i]) * (x [k] - x [i]) + (y [k] - y [i]) * (y [k] - y [i]));
			    s = (a + b + c) / 2;
			    
			    System.out.println("a: " + a + ", b: " + b + ", c: " + c + ", s: " + s);
			    
			    d = 0;
			    // check for division by zero or obtuse triangle
			    if ((s == 0) || (a * a + b * b - c * c < 0) || (b * b + c * c - a * a < 0) || (c * c + a * a - b * b < 0))
			    {
			    	System.out.println("YESS");
			    	if (a > d)
			    		d = a;
			    	if (b > d)
			    		d = b;
			    	if (c > d)
			    		d = c;
			    	System.out.println(d);
			    }
			    else
				d = 2 * (a * b * c) / (4 * Math.sqrt (s * (s - a) * (s - b) * (s - c)));
			    if (d > ans)
				ans = d;
			}
		
		System.out.printf("%.2f", ans);
	}

}
