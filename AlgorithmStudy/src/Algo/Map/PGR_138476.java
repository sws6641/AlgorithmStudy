package Algo.Map;

import java.util.*;

public class PGR_138476 {
    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> map = new HashMap<>();

            for(int now : tangerine){
                map.put(now, map.getOrDefault(now, 0) + 1);
            }

            List<Integer> keySet = new ArrayList<>(map.keySet());

            keySet.sort((o1, o2) ->
                    // map.get(o2).compareTo(map.get(o1))
                    map.get(o2) - map.get(o1)
            );

            int cnt = 0;

            for(int a : keySet) {
                if(cnt < k){
                    cnt += map.get(a);
                    answer++;
                } else break;
            }

            return answer;
        }
    }
}
