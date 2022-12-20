package second;

import java.util.Scanner;

public class CCC18S3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int M = SC.nextInt();
		
		char [][] map = new char[N][M];
		
		for (int row=0; row<N; row++){
			for (int col=0; col<M; col++){
				String S = SC.next();
				map[row] = S.toCharArray();
			}
		}
		
		int [][] step = new int[N][M];
		//Wall step value is -1
		//camera step value is -1
		//position caught by camera is -1
		//the rest is Integer.MAX_VALUE
		
		for (int row=0; row<N; row++){
			for (int col=0; col<M; col++){
				step[row][col] = Integer.MAX_VALUE;
				
				if (map[row][col] == 'W'){
					step[row][col] = -1;
				}
				else if( map[row][col] == 'C'){
					step[row][col] = -1;
					//up
					for (int i=row-1; i>=0; i--){
						if (map[i][col] == 'W'){
							break;
						}
						else if (map[i][col] == '.' || map[i][col] == 'S'){
							step[i][col] = -1;
						}
					}
					//down
					for (int i=row+1; i<N; i++){
						if (map[i][col]=='W'){
							break;
						}
						else if (map[i][col] == '.' || map[i][col] == 'S'){
							step[i][col] = -1;
						}
					}
					//left
					for (int i=col-1; i>=0; i--){
						if (map[row][i]=='W'){
							break;
						}
						else if (map[row][i] == '.' || map[row][i] == 'S'){
							step[row][i] = -1;
						}
					}
					//right
					for (int i=col+1; i<N; i++){
						if (map[row][i]=='W'){
							break;
						}
						else if (map[row][i] == '.' || map[row][i] == 'S'){
							step[row][i] = -1;
						}
					}
				}
//				if (step[row][col]!=-1){
//					step[row][col] = Integer.MAX_VALUE;
//				}
				//---------
				if (map[row][col] == 'U' || map[row][col] == 'D' || map[row][col] == 'L' || map[row][col] == 'R'){
					step[row][col] = -2;
				}
				
			}
		}
		
		
		
		
	}

}
