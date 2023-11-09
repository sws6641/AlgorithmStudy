package Algo.Implement;

import java.util.*;
import java.io.*;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int chk[] = new int[10];
        int cnt = 1;

        for (int i = 0; i < n.length(); i++) {
            int a = n.charAt(i) - '0';

            if (a == 6 || a == 9) {
                a = 6;
                chk[a]++;
            } else {
                chk[a]++;
            }
        }

        chk[6] = chk[6] / 2 + chk[6] % 2;

        Arrays.sort(chk);

        System.out.println(chk[9]);

    }
}
