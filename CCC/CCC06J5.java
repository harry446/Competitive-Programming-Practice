package second;

import java.util.Scanner;

public class CCC06J5 {
	public static char[][] B;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);

		String config = SC.next();

		char[][] B = new char [8][8];
		//		char[][] b = new char [8][8];
		//		char[][] c = new char [8][8];

		for (int row=0; row<8; row++){
			for (int col=0; col<8; col++){
				B[row][col] = 'o';

			}
		}
		
		if (config.equals("a")){
			B[3][3] = 'W';
			B[3][4] = 'B';
			B[4][3] = 'B';
			B[4][4] = 'W';
		}
		else if (config.equals("b")){
			for (int row=0; row<8; row++){
				B[row][row] = 'B';
				B[row][7-row] = 'W';
			}
		}
		else if (config.equals("c")){
			for (int row=0; row<8; row++){
				for (int col=2; col<=3; col++){
					B[row][col] = 'B';
				}
			}
			for (int row=0; row<8; row++){
				for (int col=4; col<=5; col++){
					B[row][col] = 'W';
				}
			}
		}


		int N = SC.nextInt();
		for (int i=0; i<N; i++){
			int x = SC.nextInt();
			int y = SC.nextInt();
			if (i%2==0){
				B[x][y] = 'B';
			}
			else {
				B[x][y] = 'W';
			}

			goUpDown(x-1,y-1);
			goLeftRight(x-1,y-1);
			goDLeft(x-1,y-1);
			goDRight(x-1,y-1);
		}
		
		int Wcount = 0;
		int Bcount = 0;
		for (int row=0; row<8; row++){
			for (int col=0; col<8; col++){
				if (B[row][col]=='W'){
					Wcount++;
				}
				else if (B[row][col]=='B'){
					Bcount++;
				}
			}
		}
		
		System.out.print(Wcount);
		System.out.print(Bcount);
		
		
		
		
		
	}
	public static void goUpDown(int x,int y){
		//GO UP!!!(going up on the chart but the row number is --)
		int count = 0;
		for (int row=x-1; row>=0; row--){
			if (B[row][y] != B[x][y] && B[row][y] != 'o'){
				count++;
			}
			else if (B[row][y] == 'o'){
				break;
			}
			else if (B[row][y] == B[x][y]){
				if (count>0){
					for (int i=row+1; i<x; i++){
						B[i][y] = B[x][y];
					}
				}
				else {
					break;
				}
			}
		}
		//GO DOWN!!!(going down on the chart but the row number is ++)
		count = 0;
		for (int row=x+1; row<8; row++){
			if (B[row][y] != B[x][y] && B[row][y] != 'o'){
				count++;
			}
			else if (B[row][y] == 'o'){
				break;
			}
			else if (B[row][y] == B[x][y]){
				if (count>0){
					for (int i=row-1; i>x; i--){
						B[i][y] = B[x][y];
					}
				}
				else {
					break;
				}
			}
		}

	}
	public static void goLeftRight(int x,int y){
		//GO RIGHT!!!
		int count = 0;
		for (int col=y+1; col<8; col++){
			if (B[x][col] != B[x][y] && B[x][col] != 'o'){
				count++;
			}
			else if (B[x][col] == 'o'){
				break;
			}
			else if (B[x][col] == B[x][y]){
				if (count>0){
					for (int i=col-1; i>y; i--){
						B[x][i] = B[x][y];
					}
				}
				else {
					break;
				}
			}
		}
		//GO LEFT!!!
		count = 0;
		for (int col=y-1; col>=0; col--){
			if (B[x][col] != B[x][y] && B[x][col] != 'o'){
				count++;
			}
			else if (B[x][col] == 'o'){
				break;
			}
			else if (B[x][col] == B[x][y]){
				if (count>0){
					for (int i=col+1; i<y; i++){
						B[x][i] = B[x][y];
					}
				}
				else {
					break;
				}
			}
		}
	}

	public static void goDRight(int x, int y){
		//region 1
		int count = 0;
		for (int i=1; i<8; i++){
			if (x-1>=0 && y-i>=0){
				if (B[x-i][y-i]!=B[x][y] && B[x-i][y-i]!='o'){
					count++;
				}
				else if (B[x-i][y-i] == 'o'){
					break;
				}
				else if (B[x-i][y-i] == B[x][y]){
					if (count>0){
						for(int j=i-1; j>=1; j--){
							B[x-j][y-j] = B[x][y];
						}
					}
					else {
						break;
					}
				}
			}

		}
		//region 4
		count = 0;
		for (int i=1; i<8; i++){
			if (x+i<8 && y+i<8){
				if (B[x+i][y+i]!=B[x][y] && B[x+i][y+i]!='o'){
					count++;
				}
				else if (B[x+i][y+i] == 'o'){
					break;
				}
				else if (B[x+i][y+i] == B[x][y]){
					if (count>0){
						for(int j=i-1; j>=1; j--){
							B[x+j][y+j] = B[x][y];
						}
					}
					else {
						break;
					}
				}
			}
		}
		
		

	}

	public static void goDLeft(int x, int y){
		//region 2
		int count = 0;
		for (int i=1; i<8; i++){
			if (x-1>=0 && y+i<8){
				if (B[x-i][y+i]!=B[x][y] && B[x-i][y+i]!='o'){
					count++;
				}
				else if (B[x-i][y+i] == 'o'){
					break;
				}
				else if (B[x-i][y+i] == B[x][y]){
					if (count>0){
						for(int j=i-1; j>=1; j--){
							B[x-j][y+j] = B[x][y];
						}
					}
					else {
						break;
					}
				}
			}

		}
		//region 4
		count = 0;
		for (int i=1; i<8; i++){
			if (x+i<8 && y>=0){
				if (B[x+i][y-i]!=B[x][y] && B[x+i][y-i]!='o'){
					count++;
				}
				else if (B[x+i][y-i] == 'o'){
					break;
				}
				else if (B[x+i][y-i] == B[x][y]){
					if (count>0){
						for(int j=i-1; j>=1; j--){
							B[x+j][y-j] = B[x][y];
						}
					}
					else {
						break;
					}
				}
			}
		}
		

	}

	
	
	
	

}
