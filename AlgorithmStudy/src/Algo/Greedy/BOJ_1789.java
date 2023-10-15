package Algo.Greedy;

import java.util.*;
import java.io.*;

public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long s = Long.parseLong(br.readLine());

        int i = 1;
        long sum = 0;
        while(sum <= s){
            sum += i;
            i++;
        }

        System.out.println(i-2);
    }
}
