package second;
import java.util.Scanner;
public class CCC16J4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		String S = SC.next();
		int h = Integer.parseInt(S.substring(0,2));
		int m = Integer.parseInt(S.substring(3));
		for (int i=0; i<120; i++){
			if (h>=7 && h<10 || h>=15 && h<19){
			m = m +2;
		}
		else{
			m++;
		}
			
	    if (m>59){
	    	h++;
	    	m = m - 60;
	    }
	    if (h>23){
	    	h = h - 24;
	    }

		}
		System.out.printf("%02d:%02d",h,m);
				
	}

}
