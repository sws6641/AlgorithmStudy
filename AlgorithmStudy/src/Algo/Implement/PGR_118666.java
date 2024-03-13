package Algo.Implement;

import java.util.*;
public class PGR_118666 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";

            StringBuilder sb = new StringBuilder();

            Map<String, Integer> map = new HashMap<>();

            int[] arr = {0,3,2,1,0,1,2,3};

            for(int i = 0 ; i < survey.length ; i++) {
                String[] str = survey[i].split("");

                if(choices[i] < 4) {
                    map.put(str[0], map.getOrDefault(str[0], 0) + arr[choices[i]]);
                } else {
                    map.put(str[1], map.getOrDefault(str[1], 0) + arr[choices[i]]);
                }
            }

            int R = 0, T = 0, C = 0, F = 0, J = 0, M = 0, A = 0, N = 0;
            if(map.containsKey("R")) {
                R = map.get("R");
            }
            if(map.containsKey("T")) {
                T = map.get("T");
            }
            if(map.containsKey("C")) {
                C = map.get("C");
            }
            if(map.containsKey("F")) {
                F = map.get("F");
            }
            if(map.containsKey("J")) {
                J = map.get("J");
            }
            if(map.containsKey("M")) {
                M = map.get("M");
            }
            if(map.containsKey("A")) {
                A = map.get("A");
            }
            if(map.containsKey("N")) {
                N = map.get("N");
            }

            if(R >= T) sb.append("R");
            else sb.append("T");

            if(C >= F) sb.append("C");
            else sb.append("F");

            if(J >= M) sb.append("J");
            else sb.append("M");

            if(A >= N) sb.append("A");
            else sb.append("N");

            return sb.toString();
        }
    }
}
