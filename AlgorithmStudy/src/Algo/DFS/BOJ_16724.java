package Algo.DFS;

import java.util.*;
import java.io.*;

public class BOJ_16724 {

    static int n, m;
    static char[][] map;
    static boolean[][] visit;
    static boolean[][] finish;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static int startX;
    static int startY;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visit = new boolean[n][m];
        finish = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);

    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        int nx = x;
        int ny = y;

        switch (map[x][y]) {
            case 'U':
                nx += dx[0];
                ny += dy[0];
                break;
            case 'D':
                nx += dx[1];
                ny += dy[1];
                break;
            case 'L':
                nx += dx[2];
                ny += dy[2];
                break;
            case 'R':
                nx += dx[3];
                ny += dy[3];
                break;
        }

        if(checkArray(nx, ny)){ // 범위 체크 - 근데 입력조건에 지도 밖 입력 안주어진다고 해서 visit값만 체크해도 될듯
            dfs (nx, ny);
        } else {
            if(!finish[nx][ny]) cnt++;
        }

        finish[x][y] = true;

    }

    private static boolean checkArray(int nx, int ny) {
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny]) {
            return true;
        }
        return false;
    }
}
