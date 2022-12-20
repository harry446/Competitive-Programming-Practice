package second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CCC15S2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		//J means how many jerseys
//		int J = Integer.parseInt(in.readLine());
//		//A means how many requests
//		int A = Integer.parseInt(in.readLine());
//		//M 1
//		//S 2
//		//S 3
//		//L 4
//		String[] size = new String[J+1];
//		for (int i=0; i<J; i++){
//			size[i] = in.readLine();
//		}
//
//		//L 3 go to size[2]
//		//S 3 
//		//L 1
//
//		int count = 0;
//		for (int i=0; i<A; i++){
//			String S = in.readLine();
//			String[] cmd = S.split(" ");
//			String asize = cmd[0];
//			int number = Integer.parseInt(cmd[1]);	
//			
//			if (asize.equals("S")){
//				if (!size[number-1].equals("T")){ // already assigned to someone
//					size[number-1] = "T";
//					count++;
//				}
//			}
//			else if (asize.equals("M")){
//				if (size[number-1].equals("L") && size[number-1].equals("S")){
//					size[number-1] = "T";
//					count++;
//				}
//			}
//			else if (asize.equals("L")){
//				if (size[number-1].equals("L")){
//					size[number-1] = "T";
//					count++;
//				}
//			}
//		}
//		//S M L
//		System.out.println(count);
		
		Scanner SC = new Scanner (System.in);
		int J = SC.nextInt();
		int A = SC.nextInt();
		
		Map<Integer, Integer> j = new HashMap<>(); //<number, size>
		Map<Integer, Integer> a = new HashMap<>(); //<number, size>
		
		for (int i=0; i<J; i++) {
			String size = SC.next();
			if (size.equals("S")) {
				j.put(i+1, 1);
			}
			else if (size.equals("M")) {
				j.put(i+1, 2);
			}
			else {
				j.put(i+1, 3);
			}
		}
		
		for (int i=0; i<A; i++) {
			String size = SC.next();
			int num = SC.nextInt();
			if (!a.containsKey(num)) {
				if (size.equals("S")) {
					a.put(num, 1);
				}
				else if (size.equals("M")) {
					a.put(num, 2);
				}
				else {
					a.put(num, 3);
				}
				continue;
			}
			
			int temp = 0;
			if (size.equals("S")) {
				temp = 1;
			}
			else if (size.equals("M")) {
				temp = 2;
			}
			else {
				temp = 3;
			}
			
//			System.out.println(size);
//			System.out.println(a.get(num) + "num" + temp);
			if (a.get(num) > temp) {
//				System.out.println("YES");
				a.put(num, temp);
			}
		}
		
		int count = 0;
		for (int key : a.keySet()) {
//			System.out.println(key + "K");
//			System.out.println(a.get(key));
			if (a.get(key) <= j.get(key)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
