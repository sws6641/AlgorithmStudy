package Algo.DP;

import java.util.*;
import java.io.*;

public class BOJ_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            long dp[] = new long[m + 1];

            if (m == 1) {
                sb.append(1).append("\n");
                continue;
            } else if (m == 2) {
                sb.append(2).append("\n");
                continue;
            } else if (m == 3) {
                sb.append(4).append("\n");
                continue;
            }

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= m; j++) {
                dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
            }
            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);

    }
}
