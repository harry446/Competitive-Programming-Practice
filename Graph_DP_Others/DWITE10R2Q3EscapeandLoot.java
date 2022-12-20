package second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DWITE10R2Q3EscapeandLoot {
	
	static String[][] map;
	static Map<String, Integer> Map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		map = new String[8][8];
		Map = new HashMap<>();
		for (int row=0; row<8; row++) {
			String temp = SC.nextLine();
			for (int col=0; col<8; col++) {
				map[row][col] = temp.charAt(col) + "";
			}
		}
		
		System.out.println(findMax(0, 7));
		
	}
	
	public static int findMax(int x, int y) {
		if (y < 0 || x > 7) {
			return 0;
		}
		if (map[x][y].equals("#")) {
			return 0;
		}
		
		String key = x+"#"+y;
		if (Map.containsKey(key)) {
			return Map.get(key);
		}
		
		int total = 0;
		
		if (!map[x][y].equals(".")) {
			total = Integer.parseInt(map[x][y]);
		}
		
		int num1 = findMax(x, y-1) + total;
		int num2 = findMax(x+1, y) + total;
		int ans = Math.max(num1, num2);
		Map.put(key, ans);
		
		return ans;
	}

}
