package second;

import java.util.LinkedList;
import java.util.Scanner;

public class codeforces242C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		int[][] step = new int[10^9][10^9];

		int number = 10^9;
		for (int row=0; row<number; row++){
			for (int col=0; col<number; col++){
				step[row][col] = 1000;
			}
		}

		int BR = SC.nextInt();
		int BC = SC.nextInt();
		int ER = SC.nextInt();
		int EC = SC.nextInt(); 

		LinkedList<Integer> rowQ= new LinkedList<Integer>();
		LinkedList<Integer> colQ= new LinkedList<Integer>();

		rowQ.add(BR);
		colQ.add(BC);
		step[BR][BC] = 0;

		

		while (!rowQ.isEmpty()){
			int R = rowQ.poll();
			int C = colQ.poll();

			if (R+1<number && step[R+1][C] > step[R][C]+1){ //1
				step[R+1][C] = step[R][C]+1;
				rowQ.add(R+1);
				colQ.add(C);
			}
			if (R+1<number && C+1<number && step[R+1][C+1] > step[R][C]+1){ //2
				step[R+1][C+1] = step[R][C]+1;
				rowQ.add(R+1);
				colQ.add(C+1);
			}
			if (C+1<number && step[R][C+1] > step[R][C]+1){ //3
				step[R][C+1] = step[R][C]+1;
				rowQ.add(R);
				colQ.add(C+1);
			}
			if (R-1>=1 && C+1<number && step[R-1][C+1] > step[R][C]+1){ //4
				step[R+2][C+1] = step[R][C]+1;
				rowQ.add(R-1);
				colQ.add(C+1);
			}
			if (R-1>=1 && step[R-1][C] > step[R][C]+1){ //5 
				step[R-1][C] = step[R][C]+1;
				rowQ.add(R-1);
				colQ.add(C);
			}
			if (R-1>=1 && C-1>=1 && step[R-1][C-1] > step[R][C]+1){ //6 
				step[R-1][C-1] = step[R][C]+1;
				rowQ.add(R-1);
				colQ.add(C-2);
			}
			if (C-1>=1 && step[R][C-1] > step[R][C]+1){ //7
				step[R][C-1] = step[R][C]+1;
				rowQ.add(R);
				colQ.add(C-1);
			}
			if (R+1<number && C-1>=1 && step[R+1][C-1] > step[R][C]+1){ //8
				step[R+1][C-1] = step[R][C]+1;
				rowQ.add(R+1);
				colQ.add(C-1);
			}
		}
		System.out.println(step[ER][EC]);
	}

}
