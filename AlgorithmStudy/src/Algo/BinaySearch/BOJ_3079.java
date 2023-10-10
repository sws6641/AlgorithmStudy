package Algo.BinaySearch;

import java.util.*;
import java.io.*;

public class BOJ_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Long t = Long.parseLong(br.readLine());
            list.add(t);
        }

        Collections.sort(list);
        long start = 1;
        long end = list.get(0) * m; //

        while (start <= end) {
            long cnt = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                cnt += mid / list.get(i); // 검사대 평균 시간 합
            }

            if (cnt >= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);

    }
}
