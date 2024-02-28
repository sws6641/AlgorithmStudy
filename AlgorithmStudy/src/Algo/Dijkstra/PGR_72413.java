package Algo.Dijkstra;

import java.util.*;

public class PGR_72413 {
    class Solution {

        static class Node implements Comparable<Node> {
            int to;
            int cost;

            public Node (int to, int cost) {
                this.to = to;
                this.cost = cost;
            }

            public int compareTo (Node n) {
                return this.cost - n.cost;
            }
        }

        static ArrayList<Node>[] arr;


        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = Integer.MAX_VALUE;

            arr = new ArrayList[n+1];

            for(int i = 0 ; i < n+1 ; i++) {
                arr[i] = new ArrayList<>();
            }

            for(int[] fare : fares) {
                int start = fare[0];
                int end = fare[1];
                int cost = fare[2];

                arr[start].add(new Node(end, cost));
                arr[end].add(new Node(start, cost));
            }

            int[] dist1 = new int[n+1];
            Arrays.fill(dist1, Integer.MAX_VALUE);
            int[] dist2 = new int[n+1];
            Arrays.fill(dist2, Integer.MAX_VALUE);
            int[] dist3 = new int[n+1];
            Arrays.fill(dist3, Integer.MAX_VALUE);

            dist1 = dij(s, dist1);
            dist2 = dij(a, dist2);
            dist3 = dij(b, dist3);

            // System.out.println(Arrays.toString(dist1));
            // System.out.println(Arrays.toString(dist2));
            // System.out.println(Arrays.toString(dist3));

            for(int i = 1 ; i < n+1 ; i++) {
                answer = Math.min(answer, dist1[i] + dist2[i] + dist3[i]);
            }

            return answer;
        }

        public int[] dij (int start, int[] dist) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(start, 0));
            dist[start] = 0;

            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(now.cost > dist[now.to]) continue;

                for(Node next : arr[now.to]) {
                    if(dist[next.to] > next.cost + dist[now.to]) {
                        dist[next.to] = next.cost + dist[now.to];
                        pq.offer(new Node(next.to, dist[next.to]));
                    }
                }
            }
            return dist;
        }

    }
}
