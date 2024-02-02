package Algo.PriorityQueue;

import java.util.*;

public class PGR_42627 {
    class Solution {

        class Node implements Comparable<Node> {
            int x;
            int y;

            Node (int x, int y){
                this.x = x;
                this.y = y;
            }

            public int compareTo(Node n){
                return this.y - n.y;
            }
        }

        public int solution(int[][] jobs) {
            int answer = 0;

            // 요청시간 기준으로 오름차순 정렬
            Arrays.sort(jobs, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            for(int[] a : jobs){
                System.out.println(Arrays.toString(a));

            }

            // 소요시간 기준으로 오름차순 정렬
            PriorityQueue<Node> pq = new PriorityQueue<>();

            int index = 0;
            int count = 0;
            int total = 0;
            int end = 0; // 각 디스크 종료 시점
            while(count < jobs.length) {

                // 현재 작업중인 job의 소요시간을 end로 잡고 end안에 요청이 들어오는 job들만 우선순위큐로 넣는다.
                while(index < jobs.length && jobs[index][0] <= end) {
                    pq.offer(new Node( jobs[index][0], jobs[index][1] ));
                    index++;
                }
                if(pq.isEmpty()) {
                    end = jobs[index][0];
                } else {
                    Node now = pq.poll();
                    total += now.y + end - now.x;
                    end += now.y;
                    count++;
                }
            }

            return total / jobs.length;
        }
    }
}
