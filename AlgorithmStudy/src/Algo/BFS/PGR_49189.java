package Algo.BFS;

import java.util.*;

public class PGR_49189 {

    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int[] value;
    static ArrayList<Integer>[] map;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        map = new ArrayList[n + 1];
        value = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int[] arr = edge[i];
            int start = arr[0];
            int end = arr[1];
            map[start].add(end);
            map[end].add(start);
        }

        bfs(1);
        Arrays.sort(value);
        for (int a : value) {
            if (a == value[value.length - 1]) {
                answer++;
            }
        }
        // System.out.println(Arrays.toString(value));

        return answer;
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : map[now]) {
                if (!visit[next]) {
                    que.offer(next);
                    visit[next] = true;
                    value[next] = value[now] + 1;
                }
            }
        }
    }
}
