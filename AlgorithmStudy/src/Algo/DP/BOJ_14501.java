package Algo.DP;

import java.util.*;
import java.io.*;

public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int t[] = new int[n + 2];
        int p[] = new int[n + 2];
        int dp[] = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i > 0; i--) {
            int next = i + t[i]; // i번째 날짜에서 상담 후 날짜
            if (next > n + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[next] + p[i], dp[i + 1]);
            }
        }
        System.out.println(dp[1]);
    }
}
