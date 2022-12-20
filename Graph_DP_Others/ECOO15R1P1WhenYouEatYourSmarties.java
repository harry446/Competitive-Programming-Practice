package second;

import java.util.Scanner;

public class ECOO15R1P1WhenYouEatYourSmarties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);

		for (int j=0; j<10; j++) {
			int[] colours = new int[8];

			//0 = orange
			//1 = blue
			//2 = green
			//3 = yellow
			//4 = pink
			//5 = violet
			//6 = brown
			//7 = red

			while(true) {
				String S = SC.nextLine();

				if (S.equals("end of box")) {
					break;
				}



				if (S.equals("orange")) {
					colours[0]++;
				}
				else if (S.equals("blue")) {
					colours[1]++;
				}
				else if (S.equals("green")) {
					colours[2]++;
				}
				else if (S.equals("yellow")) {
					colours[3]++;
				}
				else if (S.equals("pink")) {
					colours[4]++;
				}
				else if (S.equals("violet")) {
					colours[5]++;
				}
				else if (S.equals("brown")) {
					colours[6]++;
				}
				else if (S.equals("red")) {
					colours[7]++;
				}


			}



			int totalTime = 0;

			for (int i=0; i<7; i++) {
				if (colours[i] == 0) {
					continue;
				}

				int hands = colours[i]/7;
				if (colours[i]%7 != 0) {
					hands++;
				}

				totalTime += hands*13;

			}

			totalTime += colours[7] * 16;

			System.out.println(totalTime);
		}

	}

}
