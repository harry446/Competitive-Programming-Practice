package second;

import java.io.*;
import java.util.*;

public class CCC04S4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x1 = readInt();
		int y1 = readInt();
		int z1 = readInt();
		
		int px = readInt();
		int py = readInt();
		int pz = readInt();
		
		double min = dist(px, py, pz, x1, y1, z1);
		while (true) {
			int move = readInt();
			String direction = read();
			
			int x2 = x1 + move;
			
			if ((px >= x2 && px <= x1) || (px >= x1 && px <= x2)) {	//passes the planet
				min = Math.min(min, dist(px, py, pz, px, y1, z1));
			}
			else {
				min = Math.min(min, dist(px, py, pz, x2, y1, z1));
			}
			
			
			if (direction.equals("E")) {
				break;
			}
			
			x1 = x2;
			if (direction.equals("L")) {
				int temp1 = x1;
				x1 = y1;
				y1 = -temp1;
				
				int temp2 = px;
				px = py;
				py = -temp2;
			}
			else if (direction.equals("R")) {
				int temp1 = x1;
				x1 = -y1;
				y1 = temp1;
				
				int temp2 = px;
				px = -py;
				py = temp2;
			}
			else if (direction.equals("U")) {
				int temp1 = x1;
				x1 = z1;
				z1 = -temp1;
				
				int temp2 = px;
				px = pz;
				pz = -temp2;
			}
			else {
				int temp1 = x1;
				x1 = -z1;
				z1 = temp1;
				
				int temp2 = px;
				px = -pz;
				pz = temp2;
			}
			
		}
		
		System.out.printf("%.2f", min);
		
	}

	public static double dist (int x1, int y1, int z1, int x2, int y2, int z2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) + Math.pow(z1-z2, 2)); 
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
 
	static String read() {
		while (st == null || !st.hasMoreTokens()) {
			try { st = new StringTokenizer(br.readLine()); 
			} catch (IOException e) {}
		}
		return st.nextToken();
	}
	static int readInt() {
		return Integer.parseInt(read());
	}
	static long readLong() {
		return Long.parseLong(read());
	}
	static double readDouble() {
		return Double.parseDouble(read());
	}
}
