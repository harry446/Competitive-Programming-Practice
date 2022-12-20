package second;
import java.util.Scanner;
public class BluebookDirection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		int times = SC.nextInt();
		
		for (int i=0; i<times; i++){
			
			int N = SC.nextInt();
			
			if (N>=0 && N<=44){
				System.out.println("N");
			}
			else if (N>=45 && N<=134){
				System.out.println("E");
			}
			else if (N>=135 && N<=224){
				System.out.println("S");
			}
			else if (N>=225 && N<=314){
				System.out.println("W");
			}
			else if(N>= 315 && N<=359){
				System.out.println("N");
			}
			else {
				System.out.println("NO");
			}
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
