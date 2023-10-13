package Algo.MST;

import javax.net.ssl.SNIHostName;
import java.util.*;
import java.io.*;

public class BOJ_1753 {

    static int v, e;
    static ArrayList<Node>[] list;
    static boolean visit[];

    static class Node implements Comparable<Node> {
        int end;
        int val;

        public Node(int end, int val) {
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Node n){
            return this.val - n.val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> que = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        visit = new boolean[v + 1];
        int dist[] = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y, val));
        }

        que.offer(new Node(start, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (visit[now.end]) continue;
            visit[now.end] = true;

            for (Node next : list[now.end]) {
                if(dist[next.end] > dist[now.end] + next.val){
                    dist[next.end] = dist[now.end] + next.val;
                    que.offer(new Node(next.end, dist[next.end]));
                }
            }
        }

        for(int i = 1 ; i <= v ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }
            else{
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);

    }
}
