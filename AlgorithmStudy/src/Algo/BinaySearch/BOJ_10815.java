package Algo.BinaySearch;

import java.util.*;
import java.io.*;

public class BOJ_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(binarySearch(num, n, arr)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);

    }

    private static boolean binarySearch(int num, int n, int[] arr) {
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int midIdx = (start + end) / 2;
            int midval = arr[midIdx];

            if(num > midval) {
                start = midIdx + 1;
            }
            else if(num < midval) {
                end = midIdx - 1;
            }
            else return true;
        }
        return false;
    }
}
