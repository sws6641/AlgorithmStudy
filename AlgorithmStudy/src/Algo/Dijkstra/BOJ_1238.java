package Algo.Dijkstra;

import java.util.*;
import java.io.*;
public class BOJ_1238 {
    static class Town implements Comparable<Town> {
        int to;
        int cost;

        public Town(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Town o) {
            return this.cost - o.cost;
        }
    }

    static int n, m, x;
    static ArrayList<Town>[] map;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[from].add(new Town(to, cost));
        }

        PriorityQueue<Town> que = new PriorityQueue<>();

        int dist1[] = new int[n + 1];
        int dist2[] = new int[n + 1];
        boolean visit[] = new boolean[n + 1];
        Arrays.fill(dist1, INF);
        que.offer(new Town(x, 0));
        dist1[x] = 0;
        int answer = 0;

        while (!que.isEmpty()) {
            Town now = que.poll();

            if (visit[now.to]) continue;

            visit[now.to] = true;
            for (Town next : map[now.to]) {
                if (visit[next.to]) continue;
                if (dist1[next.to] > now.cost + next.cost) {
                    dist1[next.to] = now.cost + next.cost;
                    que.offer(new Town(next.to, dist1[next.to]));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            que.offer(new Town(i, 0));
            Arrays.fill(dist2, INF);
            dist2[i] = 0;
            visit = new boolean[n + 1];

            while (!que.isEmpty()){
                Town now = que.poll();
                if(visit[now.to]) continue;

                visit[now.to] = true;
                for(Town next : map[now.to]){
                    if (visit[next.to])
                        continue;
                    if (dist2[next.to] > now.cost + next.cost) {
                        dist2[next.to] = now.cost + next.cost;
                        que.offer(new Town(next.to, dist2[next.to]));
                    }
                }
            }
            dist1[i] += dist2[x];
        }

        for (int i = 1; i <= n; i++) {
            if (dist1[i] != INF) {
                answer = Math.max(answer, dist1[i]);
            }
        }
        System.out.println(answer);

    }
}
