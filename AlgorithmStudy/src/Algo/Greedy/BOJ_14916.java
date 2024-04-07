package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        if(n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        cnt = n / 5;
        n = n % 5;

        cnt = n / 2;
        n = n % 2;

        if(n == 1) {
            cnt += 2;
        }

        System.out.println(cnt);


    }
}
