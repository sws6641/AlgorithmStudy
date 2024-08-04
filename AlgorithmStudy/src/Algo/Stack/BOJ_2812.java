package Algo.Stack;

import java.io.*;
import java.util.*;

public class BOJ_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        int cnt = 0;
        Stack<Integer> sta = new Stack<>();
        for (int i = 0; i < n; i++) {
            int a = num.charAt(i) - '0';

            while(cnt < k && !sta.isEmpty() && sta.peek() < a) {
                sta.pop();
                cnt++;
            }
            sta.push(a);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - k; i++) {
            sb.append(sta.get(i));
        }

        System.out.println(sb);


    }
}
