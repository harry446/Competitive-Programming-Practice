package second;

import java.util.Scanner;

public class CCC15J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

//		String S = SC.nextLine();
//		S = S.replace("z","zuz");
//		S = S.replace("y","yuz");
//		System.out.println(S);
		
		
		String S = SC.nextLine();
		//A   E   I     O     U
		//ABCDEFGHIJKLMNOPQRSTUVWXYZ
		S = S.replace("z","zuz"); 
		S = S.replace("y","yuz"); 
		S = S.replace("x","xuy"); 
		S = S.replace("w","wux"); 
		S = S.replace("v","vuw"); 
		S = S.replace("t","tuv"); 
		S = S.replace("s","sut"); 
		S = S.replace("r","ros"); 
		S = S.replace("q","qor"); 
		S = S.replace("p","poq");
		S = S.replace("n","nop");
		S = S.replace("m","mon");
		S = S.replace("l","lim");
		S = S.replace("k","kil");
		S = S.replace("j","jik");
		S = S.replace("h","hij");
		S = S.replace("g","geh");
		S = S.replace("f","feg");
		S = S.replace("d","def");
		S = S.replace("c","cad");
		S = S.replace("b","bac");
		System.out.println(S);
		
	}

}
