package Algo.BackTracking;

import java.util.*;
import java.io.*;

public class BOJ_14225 {

    static int n;
    static int arr[];
    static boolean visit[] = new boolean [100_000*20 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        fun(0, 0);

        for (int i = 0; i < visit.length; i++){
            if(!visit[i]) {
                System.out.println(i);
                break;
            }
        }

    }

    private static void fun(int cnt, int sum) {
        if (cnt == arr.length) {
            if(!visit[sum]) visit[sum] = true;
            return;
        }

        fun(cnt + 1, sum);
        fun(cnt + 1, sum + arr[cnt]);

    }
}
