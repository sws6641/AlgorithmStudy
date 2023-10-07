package Algo.MST;

import java.util.*;
import java.io.*;

public class BOJ_1916 {

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

        ArrayList<Edge> map[] = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map[start].add(new Edge(end, val));
        }

        st = new StringTokenizer(br.readLine());
        int strNm = Integer.parseInt(st.nextToken());
        int endNm = Integer.parseInt(st.nextToken());

        int dist[] = new int[n+1]; //최소비용
        boolean visit[] = new boolean[n+1];
        PriorityQueue<Edge> que = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE); // 비용을 최대값으로 세팅
        que.offer(new Edge(strNm, 0));
        dist[strNm] = 0; // 시작 노드 셋팅

        while (!que.isEmpty()){
            Edge now = que.poll();
            if(visit[now.to]) continue;
            visit[now.to] = true;
            for(Edge next : map[now.to]){
                if(dist[next.to] > dist[now.to] + next.val){ // 노드 비용 최소일 경우에만
                    dist[next.to] = dist[now.to] + next.val;
                    que.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        System.out.println(dist[endNm]);

    }
}
