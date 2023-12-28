package Algo.PriorityQueue;

import java.util.*;

public class PGR_42628 {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];

            PriorityQueue<Integer> que = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();

            for(int i = 0 ; i < operations.length ; i++){
                String[] type = operations[i].split(" ");
                int num = Integer.parseInt(type[1]);

                if(type[0].equals("I")){
                    que.add(num);
                    max.add(num);
                    min.add(num);
                }
                else{
                    if (que.isEmpty()) continue;

                    que.poll();

                    if(num == -1){
                        min.poll();
                    }
                    else{
                        max.poll();
                    }

                    if (que.isEmpty()) { // 값이 모두 삭제 되었을 경우 max, min 값이 없기 때문에 초기화
                        max.clear();
                        min.clear();
                    }
                }
            }

            if(que.size() == 0){
                return answer;
            }
            else{
                answer[0] = max.poll();
                answer[1] = min.poll();
            }

            return answer;
        }
    }
}
