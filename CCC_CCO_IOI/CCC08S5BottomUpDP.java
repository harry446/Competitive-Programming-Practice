package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCC08S5BottomUpDP {
    static boolean[] [] [] [] winningPosition;
    static int[] [] moves = {{2, 1, 0, 2}, {1, 1, 1, 1}, {0, 0, 2, 1}, {0, 3, 0, 0}, {1, 0, 0, 1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean losingPosition (int a, int b, int c, int d) {
        if (a < 0 || b < 0 || c < 0 || d < 0)
            return false;
        else
            return !winningPosition [a] [b] [c] [d];
    }


    public static void main (String[] args) throws Exception {
        int n, a, b, c, d;

        winningPosition = new boolean [31] [31] [31] [31];

//        for (int i = 0 ; i < 31 ; i++)
//            for (int j = 0 ; j < 31 ; j++)
//                for (int k = 0 ; k < 31 ; k++)
//                    for (int l = 0 ; l < 31 ; l++)
//                        winningPosition [i] [j] [k] [l] = false;

        for (int i = 0 ; i < 31 ; i++)
            for (int j = 0 ; j < 31 ; j++)
                for (int k = 0 ; k < 31 ; k++)
                    for (int l = 0 ; l < 31 ; l++)
                        for (int m = 0 ; m < 5 ; m++)
                            if (losingPosition (i - moves [m] [0], j - moves [m] [1], k - moves [m] [2], l - moves [m] [3]))
                                winningPosition [i] [j] [k] [l] = true;

        n = readInt();
        for (int i = 0 ; i < n ; i++)
        {
            a = readInt();
            b = readInt();
            c = readInt();
            d = readInt();
            if (winningPosition [a] [b] [c] [d])
                System.out.println ("Patrick");
            else
                System.out.println ("Roland");
        }
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
