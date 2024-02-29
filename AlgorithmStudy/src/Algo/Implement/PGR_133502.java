package Algo.Implement;

import java.util.*;
public class PGR_133502 {
    class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;

            if(ingredient.length < 4) return 0;

            Stack<Integer> sta = new Stack<>();

            for(int i = 0 ; i < ingredient.length ; i++) {
                sta.push(ingredient[i]);

                if(sta.size() >= 4) {
                    int ham4 = sta.pop();
                    int ham3 = sta.pop();
                    int ham2 = sta.pop();
                    int ham1 = sta.pop();

                    if(ham1 == 1 && ham2 == 2 && ham3 == 3 && ham4 == 1) {
                        answer++;
                    }
                    else {
                        sta.push(ham1);
                        sta.push(ham2);
                        sta.push(ham3);
                        sta.push(ham4);
                    }
                }
            }

            return answer;
        }
    }
}
