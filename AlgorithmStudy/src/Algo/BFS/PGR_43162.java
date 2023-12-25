package Algo.BFS;

import java.util.*;

public class PGR_43162 {
    class Solution {

        public int solution(int n, int[][] computers) {
            int answer = 0;

            Queue<Integer> que = new LinkedList<>();
            boolean[] visit = new boolean[n];

            ArrayList<Integer>[] list = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[0].length; j++) {
                    if (i == j) continue;
                    if (computers[i][j] == 1) {
                        list[i].add(j);
                        list[j].add(i);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (visit[i]) continue;

                que.offer(i);
                while (!que.isEmpty()) {
                    int now = que.poll();

                    for (int x : list[now]) {
                        if (!visit[x]) {
                            visit[x] = true;
                            que.offer(x);
                        }

                    }
                }
                answer++;
            }

            return answer;
        }

    }
}
