package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GlobeXCupS2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] A = br.readLine().split(" ");
		
		int N = Integer.parseInt(A[0]);
		int M = Integer.parseInt(A[1]);
		int K = Integer.parseInt(A[2]);
		
		int[] mark = new int [N];
		int[] hours = new int [N];
		
		
		for (int i=0; i<N; i++) {
			String[] S = br.readLine().split(" ");
			mark[i] = Integer.parseInt(S[0]);
			hours[i] = Integer.parseInt(S[1]);
		}
		
		
		//sort the mark array and the hours array based on the hours array
		int MTemp = 0;
		int HTemp = 0;
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if (hours[i] > hours[j]) {
				HTemp = hours[i];
				hours[i] = hours[j];
				hours[j] = HTemp;
				
				MTemp = mark[i];
				mark[i] = mark[j];
				mark[j] = MTemp;
			}
			}
			
		}

		//get the total mark so far.
		int total = 0;
		for (int i=0; i<N; i++) {
			total += mark[i];
		}
		
		//Calculate the total study time
		int StudyTime = 0;
		for (int i=0; i<N; i++) {
			if (total/N >= K) {
				break;
			}
			
			for (int j=0; j<M-mark[i]; j++) {
				StudyTime += hours[i];
				total++;
				if (total/N >= K) {
					break;
				}
				
			}
		}
		
		
		System.out.println(StudyTime);
		
		
	}

}
