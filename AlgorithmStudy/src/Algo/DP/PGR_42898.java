package Algo.DP;

public class PGR_42898 {
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int mod = 1000000007;

            int[][] dp = new int[n+1][m+1];

            for(int[] row : puddles){
                dp[row[1]][row[0]] = -1;
            }

            dp[1][1] = 1;

            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j <= m ; j++){
                    if(i == 1 && j == 1) continue;
                    if(dp[i][j] == -1){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i-1][j] % mod + dp[i][j-1] % mod;
                    }
                }
            }

            answer = dp[n][m] % mod;

            return answer;
        }
    }
}
