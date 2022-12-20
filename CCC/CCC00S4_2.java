package second;

import java.io.*;
import java.util.*;

public class CCC00S4_2 {
        private static int[] clubs;
    private static Map<Integer, Integer> memo = new HashMap<>();
    
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        
        int distance = sc.nextInt();
        
        int numClubs = sc.nextInt();
        clubs = new int[numClubs];
        
        for (int i = 0; i < numClubs; i++)
            clubs[i] = sc.nextInt();
        
        sc.close();
        Arrays.sort(clubs);
        
        int strokes = solve(distance, 0);
        
        //System.out.println(memo);
        if (strokes != Integer.MAX_VALUE)
            System.out.println("Roberta wins in " + strokes + " strokes.");
        else
            System.out.println("Roberta acknowledges defeat.");
        
    }
    
    // Returns the amount of clubs it will take to reach the hole with a set of clubs (answer is minimized)
    public static int solve(int distance, int depth)
    {
        
        // Check Memo to see if the calculation has already been performed
        if (memo.containsKey(distance))
            return memo.get(distance);
        
        // Base Cases
        if (distance == 0)
            return depth;
        
        if (distance < 0)
            return Integer.MAX_VALUE;
        
        // Recursive case
        int result = Integer.MAX_VALUE;

        // Go through each club and calculate it's result
        for (int i = clubs.length - 1; i >= 0; i--)
        {

            result = Math.min(result, solve(distance - clubs[i], depth + 1));

        }

        // Add the result to the memo
        memo.put(distance, result);

        return result;
        
    }
}
