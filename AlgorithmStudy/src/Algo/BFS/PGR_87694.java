package Algo.BFS;

import java.io.*;
import java.util.*;

public class PGR_87694 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visit;
    static int answer = 0;

    static class Node{
        int x;
        int y;
        int val;

        public Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] rectangle = {
                {2,1,7,5},
                {6,4,10,10}
        };

        int characterX = 3;
        int characterY = 1;
        int itemX = 7;
        int itemY = 10;

        // 범위 2배 해주는 이유 - 내 테두리가 아닌 옆의 테두리로 셀 수 도있기 때문에
        map = new int[102][102];
        visit = new boolean[102][102];

        for (int i = 0; i < rectangle.length; i++) {

            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < rectangle.length; i++) {

            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int j = x1 + 1; j < x2; j++) {
                for (int k = y1 + 1; k < y2; k++) {
                    map[j][k] = 0;
                }
            }
        }

        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        System.out.println(answer);

    }

    private static void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(characterX, characterY, 0));
        visit[characterX][characterY] = true;

        while(!que.isEmpty()){
            Node now = que.poll();

            if(now.x == itemX && now.y == itemY){
                answer = map[itemX][itemY] / 2;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= 102 || ny < 0 || ny >= 102){
                    continue;
                }
                if(map[nx][ny] != 0 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    que.add(new Node(nx, ny, now.val + 1));
                    map[nx][ny] = now.val + 1;
                }
            }
        }
    }
}
