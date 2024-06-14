package Algo.Geometry;

import java.io.*;
import java.util.*;

public class BOJ_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int c1 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                int length1 = (x1 - c1) * (x1 - c1) + (y1 - c2) * (y1 - c2);
                int length2 = (x2 - c1) * (x2 - c1) + (y2 - c2) * (y2 - c2);
                int length3 = r * r;

                // 한 원안에 두 점이 같이 있으면 진입/이탈은 없다
                if(length1 < length3 && length2 > length3) {
                    cnt++;
                }
                if(length2 < length3 && length1 > length3) {
                    cnt++;
                }
            }

            System.out.println(cnt);

        }

    }
}
