package Algo.Sweeping;

import java.io.*;
import java.util.*;

public class BOJ_2170 {
    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo (Node n) {
            if(this.x == n.x) {
                return this.y - n.y;
            }
            return this.x - n.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.offer(new Node(x, y));
        }

        long answer = 0;
        Node now = pq.poll();
        int beforeX = now.x;
        int beforeY = now.y;
        answer = beforeY - beforeX;

        for (int i = 1; i < n; i++) {
            now = pq.poll();

            int nowX = now.x;
            int nowY = now.y;

            if(beforeX <= nowX && beforeY >= nowY) {
                continue;
            } else if (beforeY < nowY && beforeY >= nowX) {
                answer += nowY - beforeY;
            } else if(beforeY < nowX) {
                answer += nowY - nowX;
            }

            beforeX = nowX;
            beforeY = nowY;
        }

        System.out.println(answer);

    }
}
