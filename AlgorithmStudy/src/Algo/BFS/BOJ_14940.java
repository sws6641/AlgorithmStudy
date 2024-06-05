package Algo.BFS;

import java.io.*;
import java.util.*;

public class BOJ_14940 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] map;
    static int[][] result;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j] != 0) {
                    result[i][j] = -1;
                }
            }
        }

        for(int[] a : result) {
            for(int b : a) {
                sb.append(b).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, y));
        visit[x][y] = true;

        while (!que.isEmpty()) {
            Node now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || map[nx][ny] == 0) continue;
                que.offer(new Node(nx, ny));
                visit[nx][ny] = true;
                result[nx][ny] += result[now.x][now.y] + 1;
            }
        }
    }
}
