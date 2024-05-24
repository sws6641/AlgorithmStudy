package Algo.TwoPointer;

public class PGR_178870 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            int min = Integer.MAX_VALUE;

            int start = 0;
            int end = 1;
            int sum = sequence[start];

            while(start <= end) {
                // if(end >= sequence.length) break;

                if(sum < k) {
                    if(end >= sequence.length) break;

                    sum += sequence[end];
                    end++;
                } else if(sum > k) {
                    sum -= sequence[start];
                    start++;
                } else {
                    if(end - start < min) {
                        answer[0] = start;
                        answer[1] = end - 1;
                        min = end - start;
                    }
                    sum -= sequence[start];
                    start++;
                }

            }

            return answer;
        }
    }
}
