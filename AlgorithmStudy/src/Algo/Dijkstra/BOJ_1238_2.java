package Algo.Dijkstra;

import test.test7;

import java.util.*;
import java.io.*;
public class BOJ_1238_2 {
    static class Node {
        int to;
        int val;

        public Node(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }
    static int n,m,x;
    static ArrayList<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        map = new ArrayList[n+1];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            map[s].add(new Node(d, val));
        }

        int[] dist1 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[x] = 0;
        dist1 = dij(x, dist1);

        int[] dist3 = new int[n + 1];
        Arrays.fill(dist3, Integer.MAX_VALUE);

        for (int i = 1; i < n+1; i++) {
            if(i == x) continue;

            int[] dist2 = new int[n + 1];
            Arrays.fill(dist2, Integer.MAX_VALUE);
            dist2[i] = 0;
            dist2 = dij(i, dist2);

            list.add(dist1[i] + dist2[x]);

        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-1));


    }

    private static int[] dij(int x, int[] dist) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();

            for (Node next : map[now.to]) {
                if(dist[next.to] > dist[now.to] + next.val){
                    dist[next.to] = dist[now.to] + next.val;
                    que.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
