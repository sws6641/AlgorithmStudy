package Algo.MST;

import java.util.*;
import java.io.*;

public class BOJ_1005 {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] time = new int[n + 1];
            int[] indegree = new int[n + 1];
            ArrayList<Node>[] list = new ArrayList[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                time[j] = Integer.parseInt(st.nextToken());
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(new Node(y, time[y]));
                indegree[y]++;
            }
            int end = Integer.parseInt(br.readLine());

            Queue<Integer> que = new LinkedList<>();
            for (int j = 1; j < indegree.length; j++) {
                if (indegree[j] == 0) {
                    que.offer(j);
                }
            }

            while (!que.isEmpty()) {
                int now = que.poll();
                for (Node next : list[now]) {
                    time[next.to] = Math.max(time[now] + next.val, time[next.to]);
                    indegree[next.to]--;
                    if (indegree[next.to] == 0) {
                        que.offer(next.to);
                    }
                }
            }

            System.out.println(time[end]);

        }


    }
}
