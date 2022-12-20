package second;

import java.util.Scanner;
import java.util.Stack;

public class CCC15S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		Stack<Integer> stack = new Stack<Integer>();

		int total = 0;
		int K = SC.nextInt();


		for (int i=0; i<K; i++){
			int N = SC.nextInt();
			if(N != 0){
				stack.push(N);
			}
			else {
				stack.pop();
			}
		}

		while (!stack.isEmpty()){
			total += stack.pop();
		}
		System.out.println(total);


	}

}
