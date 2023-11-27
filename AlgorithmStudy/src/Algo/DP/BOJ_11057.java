package Algo.DP;

import java.util.*;
import java.io.*;

public class BOJ_11057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1);
        }

        int x = 1;
        for (int i = 9; i >= 0; i--) {
            dp[1][i] = x++;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 8; j >= 0; j--){
                dp[i][j] = (dp[i-1][j] + dp[i][j+1]) % 10007;
            }
        }

        System.out.println(dp[n][0]);

    }
}
