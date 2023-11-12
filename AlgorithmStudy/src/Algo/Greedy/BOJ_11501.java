package Algo.Greedy;

import java.util.*;
import java.io.*;

class BOJ_11501 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[n-1];
            for (int i = n - 2; i >= 0; i--) {

                if (max < arr[i]) {
                    max = arr[i];
                }

                else{
                    sum += max - arr[i];
                }
            }

            System.out.println(sum);

        }
    }
}
