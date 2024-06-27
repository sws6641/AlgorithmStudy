package Algo.DP;

import java.util.*;

public class PGR_42895 {
    class Solution {
        public int solution(int N, int number) {
            int answer = -1;
            int num = 0;

            Set<Integer>[] set = new HashSet[9];

            for(int i = 1 ; i < 9 ; i++) {
                // 5, 55, 555...
                
                num = (num * 10) + N;
                set[i] = new HashSet<>();
                set[i].add(num);
            }

            for(int i = 1 ; i < 9 ; i++) {
                for(int j = 1 ; j < i ; j++) {
                    for(int a : set[j]) {
                        for(int b : set[i-j]) {
                            set[i].add(a + b);
                            set[i].add(a - b);
                            set[i].add(a * b);
                            if(a != 0) {
                                set[i].add(b / a);
                            }
                            if(b != 0) {
                                set[i].add(a / b);
                            }
                        }
                    }
                }
                if(set[i].contains(number)) {
                    answer = i;
                    return answer;
                }
            }


            return answer;
        }
    }
}
