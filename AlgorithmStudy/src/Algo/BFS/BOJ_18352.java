package Algo.BFS;

import java.io.*;
import java.util.*;

public class BOJ_18352 {

    static int n, m, k, x;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        bfs(dist);

        boolean chk = false;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
                chk = true;
            }
        }

        if (chk) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }


    }

    private static void bfs(int[] dist) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        dist[x] = 0;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : map[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    que.offer(next);
                }
            }
        }

    }
}
