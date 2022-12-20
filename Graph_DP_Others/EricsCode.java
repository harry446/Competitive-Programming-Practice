package second;

import java.util.*;
public class EricsCode {

	static Scanner SC = new Scanner(System.in);
	static String Code = "";
	static String words = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Code = SC.next();

		//		String S = Code;
		//		for (int i=0; i<S.length(); i++) {
		//			
		//			
		//			
		//			if (S.charAt(i) == '{') {
		//				System.out.println(S.charAt(i));
		//			
		//				String R = "";
		//				System.out.println(R + " R");
		//				int count = 1;
		//				while(true) {
		//					if (S.charAt(i+count) == '}') {
		//						break;
		//					}
		//					R += S.charAt(i+count);
		//					count++;
		//				}
		//				System.out.println(R+" R");
		//			break;
		//			}
		//		}
		System.out.print(Solve(Code));

	}


	public static String Solve(String S) {
		Code.replace("0", " ");
		S = Code;
		char[] number = new char [S.length()];
		boolean flag = false;
		while(flag == false) {
			for (int i=0; i<S.length(); i++) {
				//reverse
				if (number[i] == '{' || number[i] == '}') {
					int count = 1;

					while(true) {
						if (number[i+count] == '}' || number[i+count] == '{') {
							break;
						}
						count++;
					}

					//changing order
					char[] temp = new char [count];
					for (int j=0; j<count; j++) {
						temp[j] = number[count-1-j];
					}
					for (int j=0; j<count; j++) {
						number[j] = temp[j];
					}

				}
				//one word
				if (number[i] == '(' || number[i] == ')') {
					String U = "";
					
				}
			}

		}
		return S;

	}
	
	public static String Word() {
		
		for (int i=0; i<Code.length(); i++) {
			if (Code.charAt(i) == 0) {
				words += " ";
			}                                       //Use ascii table here
			
		}
		
		return words;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static String NoSpace(String S) {
		S = Code;
		char[] code = new char[S.length()]; 
		                                              //S.split
		return S;
		
	}
	
	
	
	
	public static String Reverse(String S) {
		S = Code;
		char[] code = new char [S.length()];
		for (int i=0; i<S.length(); i++) {
			code[i] = S.charAt(i);
		}                                        //char[] temp
		
		
		
		return S;
		
	}

}
