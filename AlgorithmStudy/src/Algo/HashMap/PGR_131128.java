package Algo.HashMap;

import java.util.*;

public class PGR_131128 {
    class Solution {
        public String solution(String X, String Y) {
            String answer = "";

            Map<Character, Integer> map = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            List<Integer> list = new ArrayList<>();

            for(int i = 0 ; i < X.length() ; i++) {
                char cha = X.charAt(i);
                map.put(cha, map.getOrDefault(cha, 0) + 1);
            }

            for(int i = 0 ; i < Y.length() ; i++) {
                char cha = Y.charAt(i);
                map2.put(cha, map2.getOrDefault(cha, 0) + 1);
            }

            for(char a : map.keySet()) {
                if(!map2.containsKey(a)) continue;

                int min = Math.min(map.get(a), map2.get(a));
                for(int i = 0 ; i < min ; i++) {
                    list.add(Integer.parseInt(a + ""));
                }

            }

            Collections.sort(list, Collections.reverseOrder());

            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < list.size() ; i++) {
                sb.append(list.get(i));
            }

            answer = sb.toString();

            if(answer.isEmpty()) return "-1";
            if(answer.replaceAll("0", "").isEmpty()) return "0";
            return answer;

        }
    }
}
