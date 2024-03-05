package Algo.Dijkstra;

import java.util.*;
import java.io.*;

public class BOJ_13549 {
    static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        dist = dij(n, dist);

        System.out.println(dist[k]);
    }

    private static int[] dij(int start, int[] dist) {
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(start);

        while(!pq.isEmpty()) {
            int now = pq.poll();

            if(now * 2 < 100001) {
                if(dist[now * 2] > dist[now]) {
                    dist[now * 2] = dist[now];
                    pq.offer(now * 2);
                }
            }
            if(now + 1 < 100001) {
                if(dist[now + 1] > dist[now] + 1) {
                    dist[now + 1] = dist[now] + 1;
                    pq.offer(now + 1);
                }
            }
            if(now - 1 >= 0) {
                if(dist[now - 1] > dist[now] + 1) {
                    dist[now - 1] = dist[now] + 1;
                    pq.offer(now - 1);
                }
            }
        }

        return dist;
    }
}
