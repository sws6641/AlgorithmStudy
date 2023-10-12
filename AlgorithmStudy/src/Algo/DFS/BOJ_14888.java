package Algo.DFS;

import java.util.*;
import java.io.*;

public class BOJ_14888 {

    static int n;
    static int arr[];
    static int operation[] = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int val, int idx) {
        if (n == idx) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;

                if (i == 0) {
                    dfs(val + arr[idx], idx + 1);
                }
                if (i == 1) {
                    dfs(val - arr[idx], idx + 1);
                }
                if (i == 2) {
                    dfs(val * arr[idx], idx + 1);
                }
                if (i == 3) {
                    dfs(val / arr[idx], idx + 1);
                }

                operation[i]++;
            }
        }

    }
}
