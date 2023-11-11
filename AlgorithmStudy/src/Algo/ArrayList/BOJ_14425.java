package Algo.ArrayList;

import java.util.*;
import java.io.*;

public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        for (String a : list) {
            if (map.containsKey(a)) {
                cnt += map.get(a);
            }
        }

        System.out.println(cnt);

    }
}
