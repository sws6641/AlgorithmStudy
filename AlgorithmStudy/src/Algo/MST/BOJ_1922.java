package Algo.MST;

import java.util.*;
import java.io.*;

public class BOJ_1922 {

    static class Edge implements Comparable<Edge> {
        int to, val;

        public Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(Edge e) { // 오름차순
            return this.val - e.val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer = 0;

        ArrayList<Edge>[] map = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map[start].add(new Edge(end, val));
            map[end].add(new Edge(start, val));
        }

        boolean visit[] = new boolean[n+1];

        PriorityQueue<Edge> que = new PriorityQueue<>();
        que.offer(new Edge(1, 0));

        while(!que.isEmpty()){
            Edge now = que.poll();
            if(visit[now.to]) continue;
            visit[now.to] = true;
            answer += now.val;
            for(Edge next : map[now.to]){
                que.offer(next);
            }
        }
        System.out.println(answer);
    }
}
