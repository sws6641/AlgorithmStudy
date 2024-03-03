package Algo.Implement;

import java.util.*;

public class PGR_150370 {
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer = {};
            List<Integer> list = new ArrayList<>();

            Map<String, Integer> map = new HashMap<>();

            int day = convertToDay(today);

            for(int i = 0 ; i < terms.length; i++) {
                String[] str = terms[i].split(" ");
                map.put(str[0], Integer.parseInt(str[1]));
            }

            for(int i = 0 ; i < privacies.length; i++) {
                String[] str = privacies[i].split(" ");
                int pri = convertToDay(str[0]);
                int month = map.get(str[1]);
                int pri2 = pri + month * 28;

                if(day >= pri2) {
                    list.add(i+1);
                }
            }

            answer = new int[list.size()];

            for(int i = 0 ; i < answer.length ; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }

        public int convertToDay(String today) {
            String[] str = today.split("\\.");

            int year = Integer.parseInt(str[0]) * 12 * 28;
            int mon = Integer.parseInt(str[1]) * 28;
            int day = Integer.parseInt(str[2]);

            return year + mon + day;
        }
    }
}
