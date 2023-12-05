package Algo.BinaySearch;

import java.util.*;

public class PGR_43238 {
    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

            Arrays.sort(times);
            int arrLen = times.length;

            long left = 0;
            long right = (long)n * times[arrLen-1];

            while(left <= right){
                long mid = (left + right) / 2;
                long sum = 0;
                for(int i = 0 ; i < arrLen ; i++){ // mid 시간 동안 몇명을 검사할 수 있는지
                    sum += mid / times[i];
                }

                if(sum < n){
                    left = mid + 1;
                }
                else{
                    right = mid -1;
                    answer = mid;
                }
            }

            return answer;
        }
    }
}
