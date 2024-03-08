package Algo.BinaySearch;

import java.util.*;
import java.io.*;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (search(val, arr1)) {
                sb.append("1").append("\n");
            } else{
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);

    }

    private static boolean search(int val, int[] arr1) {
        int start = 0;
        int end = arr1.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr1[mid] > val) {
                end = mid - 1;
            } else if (arr1[mid] < val) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
