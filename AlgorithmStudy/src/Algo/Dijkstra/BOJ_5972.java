package Algo.Dijkstra;

import java.util.*;
import java.io.*;

public class BOJ_5972 {

    static class Node implements Comparable<Node> {
        int to;
        int val;

        public Node(int to, int val) {
            this.to = to;
            this.val = val;
        }

        public int compareTo(Node n) {
            return this.val - n.val;
        }
    }

    static int n, m;
    static ArrayList<Node>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            arr[s].add(new Node(e, val));
            arr[e].add(new Node(s, val));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist = dij(1, dist);


//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[n]);


    }

    private static int[] dij(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        boolean[] visit = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(visit[now.to]) continue;

            visit[now.to] = true;

            for (Node next : arr[now.to]) {
                if(dist[next.to] > dist[now.to] + next.val) {
                    dist[next.to] = dist[now.to] + next.val;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
