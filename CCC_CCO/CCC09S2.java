package second;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CCC09S2 {

	static int R, L;
	static int[][] map, tempMap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		R = sc.nextInt();
		L = sc.nextInt();
		Set<String> lights = new HashSet<>();
		map = new int[R][L];
		tempMap = new int[R][L];
		
		for (int row=0; row<R; row++) {
			for (int col=0; col<L; col++) {
				map[row][col] = sc.nextInt();
				tempMap[row][col] = map[row][col];
			}
		}
		lights.add(encode());
		
		
		for (int i=1; i<R; i++) {
			push(i);
			lights.add(encode());
//			System.out.println(lights + "set");
		}
		
		System.out.println(lights.size());
	}
	
	public static String encode () {
		String S = "";
		
		for (int i=0; i<L; i++) {
			S += tempMap[R-1][i];
		}
		
		return S;
	}
	
	
	public static void push (int k) {
		
		for (int row=k-1; row<R; row++) {
			for (int col=0; col<L; col++) {
//				System.out.print("L ");
				tempMap[row][col] = map[row][col];
			}
//			System.out.println();
		}
		
//		System.out.println("tempMap");
//		for (int row=0; row<R; row++) {
//			for (int col=0; col<L; col++) {
//				System.out.print(tempMap[row][col] + " ");
//			}
//			System.out.println();
//		}
		
//		System.out.println("start: " + k);
		for (int i=k; i<R; i++) {
			for (int j=0; j<L; j++) {
				if (tempMap[i-1][j] == tempMap[i][j]) {
					tempMap[i][j] = 0;
				}
				else {
					tempMap[i][j] = 1;
				}
			}
			
//			for (int j=0; j<L; j++) {
//				System.out.print(tempMap[i][j] + " ");
//			}
//			System.out.println();
			
		}
		
		
		
		
	}

}
