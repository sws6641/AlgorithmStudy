package Algo.BFS;

import java.util.*;
import java.io.*;

public class BOJ_13549 {

    public static int n, k;
    public static int sec = 0;
    public static Queue<Node> que = new LinkedList<>();
    public static boolean arr[] = new boolean[100001];
    public static int cnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) System.out.println(0);
        else {
            bfs();
            System.out.println(cnt);
        }
    }

    private static void bfs() {
        que.offer(new Node(n, 0));
        arr[n] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();
            int n = node.x;
            int xCnt = node.xCnt;

            if (n == k) {
                cnt = Math.min(xCnt, cnt);
            }

            int next;

            next = n * 2;
            if (next < 100001 && !arr[next]) {
                que.offer(new Node(next, xCnt));
                arr[next] = true;
            }

            next = n - 1;
            if (next >= 0 && next < 100001 && !arr[next]) {
                que.offer(new Node(next, xCnt + 1));
                arr[next] = true;
            }

            next = n + 1;
            if (next < 100001 && !arr[next]) {
                que.offer(new Node(next, xCnt + 1));
                arr[next] = true;
            }

        }
    }

    static class Node {
        int x, xCnt;

        public Node(int x, int xCnt) {
            this.x = x;
            this.xCnt = xCnt;
        }
    }
}
