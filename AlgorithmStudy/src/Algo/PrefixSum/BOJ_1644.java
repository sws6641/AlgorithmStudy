package Algo.PrefixSum;

import java.util.*;
import java.io.*;

public class BOJ_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        boolean chk = true;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                list.add(i);
                System.out.println(i);
            }
            chk = true;
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        while (true) {
            if (sum >= n) { // 구간합이 입력 값보다 커지면 시작점을 뺀다.
                sum -= list.get(start++);
            } else if (end == list.size()) { // 마지막 인덱스까지 도달한 경우 루프 탈출
                break;
            } else { // 구간합이 입력 값보다 작은 경우
                sum += list.get(end++);
            }

            if(sum == n) cnt++;
        }

        System.out.println(cnt);

    }
}
