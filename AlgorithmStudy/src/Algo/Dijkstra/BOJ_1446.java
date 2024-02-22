package Algo.Dijkstra;

import java.util.*;
import java.io.*;

public class BOJ_1446 {

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int val;

        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        public int compareTo(Node n) {
            if (this.start == n.start) {
                return this.end - n.end;
            }
            return this.start - n.start; // 출발시간 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dist = new int[d + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sta = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if (end <= d) {
                if (end - sta > val) { // 지름길이 더 짧을때만
                    pq.offer(new Node(sta, end, val));
                }
            }

        }

        int move = 0;
        int idx = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int len = pq.size();

        while (move < d) {
            if (idx < len) {
                Node now = pq.peek();

                if (move == now.start) { // 지름길이면
                    dist[now.end] = Math.min(dist[move] + now.val, dist[now.end]);
                    idx++;
                    pq.poll();
                } else {
                    dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                    move++;
                }
            } else {
                dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                move++;
            }
        }

        System.out.println(dist[d]);


    }
}
