package Algo.BinaySearch;

import java.io.*;
import java.util.*;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 집 사이 간격
        int lo = 1;
        int hi = arr[n - 1];

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            int position = 0; // 공유기 설치 위치
            int cnt = 1; // 처음집에 설치
            for (int i = 0; i < n; i++) {
                if(arr[i] - arr[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }

            if(cnt < c) { // 간격을 줄여야함
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);

    }
}
