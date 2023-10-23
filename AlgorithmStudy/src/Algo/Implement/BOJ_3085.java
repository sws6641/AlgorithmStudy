package Algo.Implement;

import java.util.*;
import java.io.*;

public class BOJ_3085 {

    static int n;
    static char arr[][];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                //가로
                swap1(i, j);
                check();
                swap1(i, j);

                //세로
                swap2(i, j);
                check();
                swap2(i, j);
            }
        }

        System.out.println(max);

    }

    private static void swap2(int i, int j) {
        if (arr[j - 1][i] != arr[j][i]) {
            char tmp = arr[j - 1][i];
            arr[j - 1][i] = arr[j][i];
            arr[j][i] = tmp;
        }
    }

    private static void swap1(int i, int j) {
        if (arr[i][j - 1] != arr[i][j]) {
            char tmp = arr[i][j - 1];
            arr[i][j - 1] = arr[i][j];
            arr[i][j] = tmp;
        }
    }

    private static void check() {
        for (int k = 0; k < n; k++) {
            int cnt1 = 1;
            int cnt2 = 1;
            for (int l = 1; l < n; l++) {
                if (arr[k][l - 1] == arr[k][l]) {
                    cnt1++;
                } else {
                    cnt1 = 1;
                }
                max = Math.max(max, cnt1);
            }

            for (int l = 1; l < n; l++) {
                if (arr[l - 1][k] == arr[l][k]) {
                    cnt2++;
                } else {
                    cnt2 = 1;
                }
                max = Math.max(max, cnt2);
            }

        }
    }
}
