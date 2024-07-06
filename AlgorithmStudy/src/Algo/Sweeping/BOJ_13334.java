package Algo.Sweeping;

import java.io.*;
import java.util.*;

public class BOJ_13334 {

    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 오른쪽 점 기준 오름차순 정렬
        public int compareTo(Node n) {
            return this.y - n.y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(Math.min(x, y), Math.max(x, y)));
        }

        Collections.sort(list);
        int d = Integer.parseInt(br.readLine());

        // 오른쪽 끝 점 기준으로 몇개 선분이 포함되는지
        for (int i = 0; i < list.size(); i++) {
            int nx = list.get(i).x;
            int ny = list.get(i).y;

            pq.offer(nx);

            while (!pq.isEmpty() && pq.peek() < ny - d) {
                pq.poll();
            }

            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);

    }
}

