package second;

import java.util.LinkedList;
import java.util.Scanner;

public class DMOPC13Contest1P4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);

		int T = SC.nextInt();

		for (int i=0; i<T; i++){
			int l = SC.nextInt(); //col
			int w = SC.nextInt(); //row

			char [][] map = new char [w][l];

			for (int j=0; j<w; j++) {
				String S = SC.next();
				map[j] = S.toCharArray();
			}


			//BFS
			int [][] step = new int [w][l];

			for (int row=0; row<w; row++) {
				for (int col=0; col<l; col++) {
					step[row][col] = Integer.MAX_VALUE;
				}
			}

			LinkedList <Integer> rowQ = new LinkedList <Integer>();
			LinkedList <Integer> colQ = new LinkedList <Integer>();
			//start of BFS
			int BR = 0;
			int BC = 0;
			int ER = 0;
			int EC = 0;
			for (int row=0; row<w; row++){
				for (int col=0; col<l; col++){
					if (map[row][col] == 'C'){
						BR = row;
						BC = col;
					}
					else if (map[row][col] == 'W'){
						ER = row;
						EC = col;
					}
				}
			}
			rowQ.add(BR);
			colQ.add(BC);
			step [BR][BC] = 0;

			while(!rowQ.isEmpty() || !colQ.isEmpty()){
				int r = rowQ.pop();
				int c = colQ.pop();
				//up
				if (r-1>=0 && step[r-1][c] > step[r][c]+1 && map[r-1][c]!='X'){
					step[r-1][c] = step[r][c]+1;
					rowQ.add(r-1);
					colQ.add(c);
				}
				//right
				if (c+1<l && step[r][c+1] > step[r][c]+1 && map[r][c+1]!='X'){
					step[r][c+1] = step[r][c]+1;
					rowQ.add(r);
					colQ.add(c+1);
				}
				//down
				if (r+1<w && step[r+1][c] > step[r][c]+1 && map[r+1][c]!='X'){
					step[r+1][c] = step[r][c]+1;
					rowQ.add(r+1);
					colQ.add(c);
				}
				//left
				if (c-1>=0 && step[r][c-1] > step[r][c]+1 && map[r][c-1]!='X'){
					step[r][c-1] = step[r][c]+1;
					rowQ.add(r);
					colQ.add(c-1);
				}

			}
			if (step[ER][EC] < 60){
				System.out.println("#notworth");
			}
			if(step[ER][EC] <= 60){
				System.out.println(step[ER][EC]);
			}




		}

	}

}
