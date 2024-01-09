package Algo.PriorityQueue;

import java.util.*;

public class PGR_12987 {
    class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            for(int i = 0 ; i < A.length ; i++){
                pq1.offer(A[i]);
                pq2.offer(B[i]);
            }

            for(int i = 0 ; i < A.length ; i++){
                if(pq1.peek() >= pq2.peek()){
                    pq2.poll();
                } else{
                    answer++;
                    pq1.poll();
                    pq2.poll();
                }
            }

            return answer;
        }
    }
}
