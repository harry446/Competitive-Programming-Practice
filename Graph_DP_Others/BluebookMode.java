package second;
import java.util.Scanner;
public class BluebookMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int[] A = new int[101]; // last one is 100, not 101 (0----100). All values are 0.
		while(true){
			int number = SC.nextInt();
			if(number == -1){
				break;
			}
			A[number] = A[number] + 1;
		}
		
		int max = 0;  // assume the first one is the biggest number
		for (int i=0; i<A.length; i++){
			if (A[i] > A[max]){
				max = i;
			}
		}
		System.out.println(max);

















	}

}
