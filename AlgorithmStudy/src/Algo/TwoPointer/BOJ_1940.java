package Algo.TwoPointer;

import java.util.*;
import java.io.*;

public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (list[start] + list[end] == k) {
                start++;
                end--;
                cnt++;
            } else {
                if (list[start] + list[end] < k) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(cnt);
    }
}
