package second;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mock18C2J4S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		String [] SL = new String [3];
		String [] SW = new String [3];
		
		int [] L = new int [3];
		int [] W = new int [3];
		
		for (int i=0; i<3; i++){
			String S = SC.nextLine();
			StringTokenizer st = new StringTokenizer(S," ");
			SL[i] = st.nextToken(); 
			SW[i] = st.nextToken();
		}
		
		for (int i=0; i<3; i++){
			L[i] = Integer.parseInt(SL[i]);
			W[i] = Integer.parseInt(SW[i]);
		}
		

		Arrays.sort(L);
		if (L[0]+L[1] == L[2] && W[0] == W[1] || W[1] == W[2] || W[0] == W[2]){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}

}
