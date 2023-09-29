package Algo.BFS;

import java.util.*;
import java.io.*;

public class BOJ_7569 {

    public static int m,n,h;
    public static int map[][][];
    public static boolean visit[][][];
    public static int[] dx = {0, 0, 0, 0, -1, 1 };
    public static int[] dy = {0, 0, 1, -1, 0, 0 };
    public static int[] dh = {-1, 1, 0, 0, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[n][m][h];
        visit = new boolean[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();

    }

    private static void bfs() {
        Queue<Node> que = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(map[j][k][i] == 1){
                        que.offer(new Node(j, k, i));
                        visit[j][k][i] = true;
                    }
                }
            }
        }

        int cnt = 0;
        while (!que.isEmpty()){
            Node node = que.poll();

            for(int i = 0 ; i < 6 ; i++){
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
                int nh = dh[i] + node.h;

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && nh >= 0 && nh < h){
                    if(map[nx][ny][nh] == 0 && !visit[nx][ny][nh]){
                        map[nx][ny][nh] = map[node.x][node.y][node.h] + 1;
                        cnt = Math.max(cnt, map[nx][ny][nh] - 1);
                        visit[nx][ny][nh] = true;
                        que.offer(new Node(nx, ny, nh));
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(map[j][k][i] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(cnt);

    }

    static class Node{
        int x,y,h;

        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
