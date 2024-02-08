package Algo.Tree;

import java.util.*;

public class PGR_76503 {
    class Solution {
        // 위상정렬?
        public long solution(int[] a, int[][] edges) {
            long answer = 0;
            int root = 0;
            int n = a.length;
            int[] degree = new int[n]; // 트리 깊이
            long[] val = new long[n];

            for (int i = 0; i < a.length; i++) {
                answer += a[i];
                val[i] = a[i];
            }

            if (answer != 0)
                return -1;
            if (n == 2) // 가능한 경우 둘중 하나의 정점의 VAL값이 정답
                return Math.abs(val[0]);

            ArrayList<Integer>[] edge = new ArrayList[n];
            for (int i = 0; i < n; i++)
                edge[i] = new ArrayList<>();

            for (int i = 0; i < edges.length; i++) {
                int x = edges[i][0];
                int y = edges[i][1];
                edge[x].add(y);
                edge[y].add(x);
                degree[x]++;
                degree[y]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < n; i++) {
                if (edge[i].size() == 1) // q 크기가 1이면 연결 간선 1개
                    q.offer(i); // 왜 크기가 1인것만 추가하지? 위상정렬?
            }

            while (!q.isEmpty()) {
                int now = q.poll();
                answer += Math.abs(val[now]);
                degree[now]--;

                for (int next : edge[now]) {
                    if (degree[next] == 0) // 더 이상 가중치가 존재하지않을때
                        continue;

                    val[next] += val[now]; // 왜 더하기만 해주지?
                    degree[next]--;

                    if (degree[next] == 1) {
                        if (next == root)
                            continue;
                        q.offer(next);
                    }
                }

            }

            return answer;

        }
    }
}
