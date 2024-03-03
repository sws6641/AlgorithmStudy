package Algo.HashMap;

import java.util.*;

public class PGR_160586 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];

            Map<Character, Integer> map = new HashMap<>();

            for(int i = 0 ; i < keymap.length ; i++) {
                for(int j = 0 ; j < keymap[i].length() ; j++) {
                    char key = keymap[i].charAt(j);
                    if(map.containsKey(key)) {
                        if(map.get(key) > j+1) {
                            map.put(key, j+1);
                        }
                    }
                    else {
                        map.put(key, j+1);
                    }
                }
            }

            for(int i = 0 ; i < targets.length ; i++) {
                int sum = 0;
                for(int j = 0 ; j < targets[i].length() ; j++) {
                    char key = targets[i].charAt(j);

                    if(map.containsKey(key)) {
                        sum += map.get(key);
                    } else {
                        sum = -1;
                        break;
                    }
                }
                answer[i] = sum;
            }

            return answer;
        }
    }
}
