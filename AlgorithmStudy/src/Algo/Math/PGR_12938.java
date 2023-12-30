package Algo.Math;

import java.util.*;

public class PGR_12938 {
    class Solution {
        public int[] solution(int n, int s) {
            int[] answer = {};

            if (s / n == 0) {
                answer = new int[1];
                answer[0] = -1;
                return answer;
            }

            int tmp = s / n;
            answer = new int[n];

            for (int i = 0; i < n; i++) {
                answer[i] = tmp;
            }

            int mod = s % n;
            int idx = 0;
            for (int i = 0; i < mod; i++) {
                answer[idx]++;
                idx++;
            }

            Arrays.sort(answer);

            return answer;
        }
    }
}
