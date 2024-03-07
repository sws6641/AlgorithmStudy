package Algo.DP;

import java.util.*;
import java.io.*;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];
        int[][] bag = new int[n+1][2];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            bag[i][0] = w;
            bag[i][1] = v;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if(j < bag[i][0]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], bag[i][1] + dp[i-1][j - bag[i][0]]);
                }
            }
        }

        System.out.println(dp[n][k]);

    }
}
