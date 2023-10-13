package Algo.BFS;

import java.util.*;
import java.io.*;

public class BOJ_16236 {

    static int n;
    static int arr[][];
    static boolean visit[][];
    static int r = 0;
    static int c = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int sharkSize = 2;
    static int sharkEatCnt = 0;

    static class Node {
        int x;
        int y;
        int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    r = i;
                    c = j;
                }
            }
        }

        while (true) {
            int now = bfs(r, c);
            if (now == 0) {
                break;
            }
            answer += now;
        }
        System.out.println(answer);

    }

    private static int bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        ArrayList<Node> fish = new ArrayList<>();
        visit = new boolean[n][n];
        que.offer(new Node(x, y, 0));
        arr[x][y] = 0;
        visit[x][y] = true;
        int time = 0;

        while (!que.isEmpty()) {
            Node now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visit[nx][ny]) continue;
                if (arr[nx][ny] < sharkSize && arr[nx][ny] != 0) { // 물고기 먹은 경우
                    visit[nx][ny] = true;
                    que.offer(new Node(nx, ny, now.dis + 1));
                    fish.add(new Node(nx, ny, now.dis + 1));
                } else if (arr[nx][ny] == sharkSize || arr[nx][ny] == 0) { // 지나가는 경우
                    visit[nx][ny] = true;
                    que.offer(new Node(nx, ny, now.dis + 1));
                }
            }
        }

        if (fish.size() == 0) {
            return time;
        }

        Node eatfish = fish.get(0);
        for (int i = 0; i < fish.size(); i++) {
            if (eatfish.dis > fish.get(i).dis) { // 가까운 거리의 먹이 먹음
                eatfish = fish.get(i);
            }
            if (eatfish.dis == fish.get(i).dis) { // 거리 같을 경우
                if (eatfish.x > fish.get(i).x) { // 위쪽 먹이
                    eatfish = fish.get(i);
                } else if (eatfish.x == fish.get(i).x) { // 위쪽이 여러마리라면 왼쪽 먹
                    if (eatfish.y > fish.get(i).y)
                        eatfish = fish.get(i);
                }
            }
        }

        time = eatfish.dis;
        sharkEatCnt++;
        if (sharkSize == sharkEatCnt) {
            sharkSize++;
            sharkEatCnt = 0;
        }

        r = eatfish.x;
        c = eatfish.y;

        return time;

    }
}
