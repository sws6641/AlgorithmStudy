package Algo.BFS;

import java.util.*;

public class PGR_86971 {
    class Solution {
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            int cnt = 1;

            ArrayList<Integer>[] map = new ArrayList[n + 1];

            for(int i = 0 ; i < wires.length ; i++){
                for(int j = 0 ; j <= n ; j++){
                    map[j] = new ArrayList<>();
                }

                for(int j = 0 ; j < wires.length ; j++){
                    if(i == j) continue; // 전력망 하나씩 끊기

                    int x = wires[j][0];
                    int y = wires[j][1];
                    map[x].add(y);
                    map[y].add(x);
                }

                Queue<Integer> que = new LinkedList<>();
                boolean[] visit = new boolean[n + 1];
                que.offer(1);
                cnt = 1;

                while(!que.isEmpty()){
                    int now = que.poll();

                    visit[now] = true;

                    for(int next : map[now]){
                        if(!visit[next]){
                            que.offer(next);
                            cnt++;
                        }
                    }
                }
                cnt = Math.abs(Math.abs(n - cnt) - cnt);
                answer = Math.min(answer, cnt);
            }

            return answer;
        }
    }
}
