package Algo.Implement;

import java.util.*;

public class PGR_12946 {
    class Solution {

        static List<int[]> list = new ArrayList<>();

        public int[][] solution(int n) {

            hanoi(n, 1, 2, 3);

            int[][] answer = new int[list.size()][];
            for(int i=0; i < list.size(); i++){
                answer[i] = list.get(i);
            }

            return answer;
        }

        public static void hanoi(int n, int start, int mid, int end){
            if(n == 1){
                list.add(new int[]{start, end});
                return;
            }

            hanoi(n-1, start, end, mid);

            list.add(new int[]{start, end});

            hanoi(n-1, mid, start, end);
        }
    }
}
