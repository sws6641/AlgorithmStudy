package Algo.Math;

public class PGR_12923 {
    class Solution {
        public int[] solution(long begin, long end) {
            int[] answer = {};
            int len = (int)end - (int)begin;
            answer = new int[len + 1];

            for(int i = (int)begin ; i <= (int)end ; i++){
                boolean chk = false;
                for (int j = 2; j * j <= i; j++) {
                    // 에라토테네스의 채
                    if(i % j == 0 && i / j <= 10_000_000){ // 소수가 아니고 약수가 10_000_000 이하라면
                        chk = true;
                        answer[i - (int) begin] = i / j; // 가장 큰 약수 삽입
                        break;
                    }
                }
                if (i == 1)
                    chk = true;
                if (!chk) {
                    answer[i - (int) begin] = 1;
                }
            }

            return answer;
        }
    }
}
