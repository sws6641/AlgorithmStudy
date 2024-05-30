package Algo.BFS;

import java.io.*;
import java.util.*;

public class BOJ_1743 {

    static int n, m, k;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int cnt = 0;
    static int max = 0;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    cnt = 0;
                    bfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.println(max);

    }

    private static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, y));
        visit[x][y] = true;
        cnt++;

        while(!que.isEmpty()){
            Node now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx <= 0 || nx > n || ny <= 0 || ny > m || visit[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == 1) {
                    que.offer(new Node(nx, ny));
                    visit[nx][ny] = true;
                    cnt++;
                }
            }
        }

    }
}
