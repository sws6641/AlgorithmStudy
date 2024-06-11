package Algo.DP;

import java.util.*;
import java.io.*;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] max = new int[n][3];
        int[][] min = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                max[i][j] = num;
                min[i][j] = num;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    max[i][j] = Math.max(max[i - 1][j] + max[i][j], max[i - 1][j + 1] + max[i][j]);
                    min[i][j] = Math.min(min[i - 1][j] + min[i][j], min[i - 1][j + 1] + min[i][j]);
                } else if (j == 1) {
                    max[i][j] = Math.max(Math.max(max[i - 1][j - 1] + max[i][j], max[i - 1][j] + max[i][j]), max[i - 1][j + 1] + max[i][j]);
                    min[i][j] = Math.min(Math.min(min[i - 1][j - 1] + min[i][j], min[i - 1][j] + min[i][j]), min[i - 1][j + 1] + min[i][j]);
                } else {
                    max[i][j] = Math.max(max[i - 1][j - 1] + max[i][j], max[i - 1][j] + max[i][j]);
                    min[i][j] = Math.min(min[i - 1][j - 1] + min[i][j], min[i - 1][j] + min[i][j]);
                }
            }
        }

        int maxNum = Math.max(Math.max(max[n-1][0], max[n-1][1]), max[n-1][2]);
        int minNum = Math.min(Math.min(min[n-1][0], min[n-1][1]), min[n-1][2]);

        System.out.println(maxNum + " " + minNum);

    }
}
