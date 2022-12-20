package second;

import java.util.Scanner;
import java.util.Stack;

public class CCC05J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		Stack<String> names = new Stack<String>();
		while (true){
			String S = SC.next();
			if (S.equals("SCHOOL")){
				break;
			}
			names.push(S);
		}


		while (true){
			String D = names.pop();
			String Direction = "";
			if (D.equals("R")){
					Direction = "RIGHT";
				}
				else if (D.equals("L")){
					Direction = "LEFT";
				}
			if (names.isEmpty()){
				System.out.println("Turn " + Direction +" into your HOME.");
				break;
			}
			else{
				String Street = names.pop();
				System.out.println("Turn " + Direction +" onto " + Street +" street.");
			}
		}
	
		
	}
	
}
