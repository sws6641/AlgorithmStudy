package Algo.BFS;

import java.io.*;
import java.util.*;

public class BOJ_5014 {

    static int[] map;
    static boolean[] visit;
    static int f, s, g, u, d;
    static int[] dx = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
//        u = Integer.parseInt(st.nextToken());
//        d = Integer.parseInt(st.nextToken());
        dx[0] = Integer.parseInt(st.nextToken());
        dx[1] = -Integer.parseInt(st.nextToken());


        map = new int[f + 1];
        visit = new boolean[f + 1];

        bfs(s, g);

        if(!visit[g]) System.out.println("use the stairs");
        else System.out.println(map[g]);

    }

    private static void bfs(int s, int g) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(s);
        visit[s] = true;
        map[s] = 0;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i = 0; i < 2; i++) {
                int next = now + dx[i];

                if(next < 1 || next > f) {
                    continue;
                }
                if(!visit[next]) {
                    que.offer(next);
                    visit[next] = true;
                    map[next] = map[now] + 1;
                }
            }

        }

    }
}
