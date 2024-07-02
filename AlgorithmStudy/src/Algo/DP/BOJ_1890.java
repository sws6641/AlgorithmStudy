package Algo.DP;

import java.io.*;
import java.util.*;

public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        long[][] dp = new long[n+1][n+1];
        dp[1][1] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int tmp = map[i][j];
                if(tmp == 0) break;
                if(j + tmp < n + 1) {
                    dp[i][j + tmp] += dp[i][j];
                }
                if(i + tmp < n + 1) {
                    dp[i + tmp][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n][n]);

    }
}
