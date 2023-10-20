package Algo.DP;

import java.util.*;
import java.io.*;

public class BOJ_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int dp[][] = new int[201][201];

        for(int i = 1 ; i < 201 ; i++){
            dp[i][1] = 1;
            dp[1][i] = dp[1][i-1] +1;
        }

        for(int i = 2 ; i < 201 ; i++){
            for(int j = 2 ; j < 201 ; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_000;
            }
        }

        for(int i = 1 ; i < 201 ; i++){
            for(int j = 1 ; j < 201 ; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(dp[n][m]);
    }
}
