package Algo.TopologySort;

import java.io.*;
import java.util.*;

public class BOJ_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n + 1];
        int[] degree = new int[n + 1];
        ArrayList<Integer>[] map = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            time[i] = x;

            for (int j = 1; j < str.length - 1; j++) {
                int y = Integer.parseInt(str[j]);
                map[y].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        int[] dist = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                que.offer(i);
            }
        }

        while(!que.isEmpty()) {
            int now = que.poll();

            for(int next : map[now]) {
                degree[next]--;
                if(dist[next] < dist[now] + time[now]) {
                    dist[next] = dist[now] + time[now];
                }
                if(degree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            System.out.println(dist[i] + time[i]);
        }

    }
}
