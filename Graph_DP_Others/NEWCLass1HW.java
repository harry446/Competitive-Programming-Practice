package second;
import java.util.Scanner;
public class NEWCLass1HW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		//Q.1
		String S = SC.nextLine();
		for (int i=0; i<S.length(); i++){
			if (S.charAt(i) == S.charAt(S.length()-1-i)){
				System.out.println("YES");
				break;
			}
			else{
				System.out.println("NO");
				break;
			}
		}
		
		//Q.2
		//IDK
		
		//Q.3
		String S1 = SC.nextLine();
		if (S.charAt(0) == '8' && S.charAt(0) == '8' && S.charAt(0) == '8'){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
		
		//Q.4
		String S2 = SC.nextLine();
		boolean flag = true;
		for (int i=0; i<S.length(); i++){
			if (S.charAt(i)!='A' || S.charAt(i)!='E' || S.charAt(i)!='I' || S.charAt(i)!='O' || S.charAt(i)!='U'){
				flag = false;
			}
			else{
				flag = true;
			}
		}
		if (flag){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
