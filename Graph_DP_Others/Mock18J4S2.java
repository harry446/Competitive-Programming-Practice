package second;

import java.util.Arrays;
import java.util.Scanner;

public class Mock18J4S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		
		char[][] A = new char[N][N];
		char[] row = new char[N];
		char[] col = new char[N];
		
		boolean latin = true;
		for (int r=0; r<N; r++){
			//convert every single Strings into rows
			String S = SC.next();
			A[r] = S.toCharArray();
			
			//put the current row into another array
			for (int c=0; c<N; c++){
				row[c] = A[r][c];
				if (!isLatin(row)){
					latin = false;
					break;
				}
			}
		}
		if (latin){
			for (int r=0; r<N; r++){
				for (int c=0; c<N; c++){
					col[c] = A[c][r];
					if (!isLatin(col)){
						latin = false;
						break;
					}
				}
			}
		}
		for (int r=0; r<N; r++){
			for (int c=0; c<N; c++){
				System.out.println();
			}
		}
		if (latin){
			System.out.println("Latin");
		}
		else {
			System.out.println("reduced");
		}
	}

	public static boolean isLatin(char[] row){
		Arrays.sort(row);
		boolean flag = true;
		for (int i=0; i<row.length-1; i++){
			if (row[i] == row[i+1]){
				flag = false;
				break;
			}
		}
		return flag;
		
	}
}
