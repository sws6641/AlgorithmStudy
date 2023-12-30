package Algo.DP;

import java.util.*;

public class PGR_12907 {
    class Solution {
        public int solution(int n, int[] money) {
            int answer = 0;

            int[] dp = new int[n+1];

            for(int i = 0 ; i <= n ; i++){
                if(i % money[0] == 0){
                    dp[i] = 1;
                }
            }

            // 왜 dp[0]값을 1로 초기화 하는거지??
            System.out.println(Arrays.toString(dp));

            for(int i = 1 ; i < money.length ; i++){
                for(int j = money[i] ; j <= n ; j++){
                    dp[j] += dp[j - money[i]];
                }
                dp[i] %= 1000000007;
                System.out.println(Arrays.toString(dp));
            }

            return dp[n];
        }
    }
}
