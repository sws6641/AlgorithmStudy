package Algo.DP;

public class PGR_12971 {
    class Solution {
        public int solution(int sticker[]) {
            int answer = 0;

            int n = sticker.length;

            if (n == 1) return sticker[0];

            int[] dp1 = new int[n];
            int[] dp2 = new int[n];

            // 처음 스티커 사용
            dp1[0] = sticker[0];
            dp1[1] = sticker[0];
            for(int i = 2 ; i < n - 1 ; i++) {
                dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
            }

            // 두번째 스티커 사용
            dp2[0] = 0;
            dp2[1] = sticker[1];
            for(int i = 2 ; i < n ; i++) {
                dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
            }

            answer = Math.max(dp1[n-2], dp2[n-1]);


            return answer;
        }
    }
}
