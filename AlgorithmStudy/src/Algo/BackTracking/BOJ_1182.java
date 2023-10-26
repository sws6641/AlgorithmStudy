package Algo.BackTracking;

import java.util.*;
import java.io.*;

public class BOJ_1182 {

    static int n, s;
    static int[] arr;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dfs(0, n, i + 1);
        }

        System.out.println(cnt);
    }

    private static void dfs(int start, int depth, int goal) {
        if (goal == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visit[i]) sum += arr[i];
            }
            if (sum == s) cnt++;

            return;
        }

        for (int i = start; i < n; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1, goal - 1);
            visit[i] = false;
        }
    }
}
