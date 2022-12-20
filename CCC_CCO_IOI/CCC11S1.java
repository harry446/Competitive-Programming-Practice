package second;

import java.util.Scanner;

public class CCC11S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		
		int Tcount = 0;
		int Scount=0;
		for (int i=0; i<N; i++){
			String S = SC.nextLine();
			
			for (int j=0; j<S.length(); j++){
				char c = S.charAt(j);
				if (c=='s' || c=='S'){
					Scount++;
				}
				else if (c=='t' || c=='T'){
					Tcount++;
				}
			}
		}
		if (Tcount>Scount){
			System.out.println("English");
		}
		else{
			System.out.println("French");
		}
		
		
		
		
		
	}

}
