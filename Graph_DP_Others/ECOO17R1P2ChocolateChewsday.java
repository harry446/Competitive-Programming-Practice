package second;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ECOO17R1P2ChocolateChewsday {

	static String S = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		for (int i=0; i<10; i++) {
			int N = SC.nextInt();
			String[] name = new String[N];
			int[] totalScore = new int[N];
			int[] GScore = new int[N];
			int[] FScore = new int[N];
			int[] PScore = new int[N];
			
			
			for (int j=0; j<N; j++) {
				if (j == 0) {
					name[j] = SC.next();  //name of first chocolate
				}
				else {
					name[j] = S;
				}
//				System.out.print(name[j] + " ");
				
				while(true) {
					S = SC.next();   //holds J or name of the chocolate 
					if (!S.equals("J")) {
						break;
					}
					
					int P = SC.nextInt();
					int F = SC.nextInt();
					int G = SC.nextInt();
					if (P > 1) {
						P = 1;
					}
					if (F > 2) {
						F = 2;
					}
					if (G > 3) {
						G = 3;
					}
					totalScore[j] = totalScore[j] + P + F + G;
					PScore[j] += P;
					FScore[j] += F;
					GScore[j] += G;	
				}
				
				
				
//				System.out.print(PScore[j] + " ");
//				System.out.print(FScore[j] + " ");
//				System.out.print(GScore[j] + " ");
//				System.out.println();
				
				if (S.equals("*")) {
					break;
				}
				
				
			}
			
			
			
			//Compares Total
			int maxTotal = 0;
			Set<Integer> Tindex = new HashSet<>();
			for (int j=0; j<N; j++) {
				if (totalScore[j] > maxTotal) {
					Tindex.clear();
					Tindex.add(j);
					maxTotal = totalScore[j];
				}
				else if (totalScore[j] == maxTotal) {
					Tindex.add(j);
				}
			}
			
			if (Tindex.size() == 1) {
				for (int key : Tindex) {
					System.out.println(name[key]);
				}
			}
			else {   //if more than one, compares G
				int maxG = 0;
				Set<Integer> Gindex = new HashSet<>();
				for (int key : Tindex) {     //gets elements only from Tindex
					if (GScore[key] > maxG) {
						Gindex.clear();
						Gindex.add(key);
						maxG = GScore[key];
					}
					else if (GScore[key] == maxG) {
						Gindex.add(key);
					}
				}
				
				if (Gindex.size() == 1) {
					for (int key : Gindex) {
						System.out.println(name[key]);
					}
				}
				else {   //if still more than one, compares F
					int maxF = 0;
					Set<Integer> Findex = new HashSet<>();
					for (int key : Gindex) {     //gets elements only from Gindex
						if (FScore[key] > maxF) {
							Findex.clear();
							Findex.add(key);
							maxF = FScore[key];
						}
						else if (FScore[key] == maxF) {
							Findex.add(key);
						}
					}
					
					if (Findex.size() == 1) {
						for (int key : Findex) {
							System.out.println(name[key]);
						}
					}
					else {   //if still more than one, compares P
						int maxP = 0;
						Set<Integer> Pindex = new HashSet<>();
						for (int key : Findex) {     //gets elements only from Findex
							if (PScore[key] > maxP) {
								Pindex.clear();
								Pindex.add(key);
								maxP = PScore[key];
							}
							else if (PScore[key] == maxP) {
								Pindex.add(key);
							}
						}
						
						if (Pindex.size() == 1) {
							for (int key : Pindex) {
								System.out.println(name[key]);
							}
						}
						else {
							int count = 0;
							for (int key : Pindex) {
								count++;
								if (count >= Pindex.size()) {     //Do not out put comma for the last one, and moves the cursor to the next line
									System.out.println(name[key]);
									break;
								}
								System.out.print(name[key] + ",");
							}
						}
						
					}
					
					
				}
			}
		}
		

	}

}
