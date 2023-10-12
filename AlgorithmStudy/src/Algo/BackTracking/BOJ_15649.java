package Algo.BackTracking;

import java.util.*;
import java.io.*;

public class BOJ_15649 {

    static int n, m;
    static boolean visit[];
    static int arr[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        arr = new int[m];

        backTracking(0);

        System.out.println(sb);
    }

    private static void backTracking(int dep) {
        if (m == dep) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[dep] = i + 1;
                backTracking(dep + 1);
                visit[i] = false;
            }
        }
    }
}
