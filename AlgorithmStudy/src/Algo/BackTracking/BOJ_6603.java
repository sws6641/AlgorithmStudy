package Algo.BackTracking;

import java.util.*;
import java.io.*;

public class BOJ_6603 {

    static int k;
    static int arr[];
    static int answer[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            arr = new int[k];
            answer = new int[6];
            visit = new boolean[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }

    }

    public static void dfs(int start, int idx) {
        if (idx == 6) {
            for(int a : answer){
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            sb.delete(0, sb.length());
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[idx] = arr[i];
                dfs(i, idx + 1);
                visit[i] = false;
            }
        }
    }
}
