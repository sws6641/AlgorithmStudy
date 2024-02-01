package Algo.Implement;

import java.util.*;

public class PGR_131704 {
    class Solution {
        public int solution(int[] order) {
            int answer = 0;

            Queue<Integer> que = new LinkedList<>();
            Stack<Integer> sta = new Stack<>();

            for(int i = 1 ; i <= order.length ; i++) {
                que.offer(i);
            }

            int index = 0;
            for(int i = 1 ; i <= order.length ; i++) {
                if(order[index] != i) {
                    sta.push(i);
                }
                else{
                    index++;
                    answer++;
                }
                while(!sta.isEmpty() && sta.peek() == order[index]){
                    sta.pop();
                    index++;
                    answer++;
                }
            }

            return answer;
        }
    }
}
