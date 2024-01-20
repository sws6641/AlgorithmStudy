package Algo.MST;

import java.util.*;

public class PGR_42861 {
    class Solution {

        class Node implements Comparable<Node> {
            int to;
            int val;

            Node (int to, int val){
                this.to = to;
                this.val = val;
            }

            public int compareTo(Node n){
                return this.val - n.val;
            }
        }

        public int solution(int n, int[][] costs) {
            int answer = 0;

            ArrayList<Node>[] map = new ArrayList[n];

            for (int i = 0 ; i < n ; i++){
                map[i] = new ArrayList<>();
            }

            for (int i = 0 ; i < costs.length ; i++){
                int x = costs[i][0];
                int y = costs[i][1];
                int val = costs[i][2];

                map[x].add(new Node(y, val));
                map[y].add(new Node(x, val));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0,0));
            boolean[] visit = new boolean[n];

            while(!pq.isEmpty()){
                Node now = pq.poll();

                if(visit[now.to]) continue;
                visit[now.to] = true;
                answer += now.val;

                for(Node next : map[now.to]){
                    if(!visit[next.to]) {
                        pq.offer(new Node(next.to, next.val));
                    }
                }
            }

            return answer;
        }
    }
}
