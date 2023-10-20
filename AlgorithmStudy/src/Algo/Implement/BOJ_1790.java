package Algo.Implement;

import java.util.*;
import java.io.*;

public class BOJ_1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long len = 1; // 찾고싶은 숫자의 자리수
        long num = 9; // 찾고싶은 숫자의 자리수별 개수(1자리 숫자: 9개, 2자리 숫가: 90개)
        long answer = 0;
        long tmp = k;

        while (tmp > num * len) {
            tmp -= num * len;
            answer += num;
            num *= 10;
            len++;
        }
        answer = (answer + 1) + ((tmp - 1) / len); // 현재 까지 지나쳐온 자리수 + 해당자릿수만큼 이동한 횟수
        if (answer > n) {
            System.out.println(-1);
        } else {
            long idx = (tmp - 1) % len;
            System.out.println(String.valueOf(answer).charAt((int) idx));
        }
    }
}
