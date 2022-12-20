package second;

import java.util.Scanner;

public class CCC07J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		while(true){
			String S = SC.nextLine();
			if (S.equals("TTYL")){
				System.out.println("talk to you later");
				break;
			}
			else if (S.equals("CU")){
				System.out.println("see you");
			}
	        else if (S.equals(":-)")){
				System.out.println("I'm happy");
			}
	        else if (S.equals(":-(")){
				System.out.println("I'm unhappy");
			}
	        else if (S.equals(";-)")){
				System.out.println("wink");
			}
	        else if (S.equals(":-P")){
				System.out.println("stick out my tougue");
			}
	        else if (S.equals("(~.~)")){
				System.out.println("sleepy");
			}
	        else if (S.equals("TA")){
				System.out.println("totally awesome");
			}
	        else if (S.equals("CCC")){
				System.out.println("Canadian Computing Competition");
			}
	        else if (S.equals("CUZ")){
				System.out.println("because");
			}
	        else if (S.equals("TY")){
				System.out.println("thank-you");
			}
	        else if (S.equals("YW")){
				System.out.println("you're welcome");
			}
	        else{
	        	System.out.println(S);
	        }
		}
	}

}
