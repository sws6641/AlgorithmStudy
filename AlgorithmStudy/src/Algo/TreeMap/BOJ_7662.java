package Algo.TreeMap;

import java.io.*;
import java.util.*;

public class BOJ_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                String[] str = br.readLine().split(" ");
                int num = Integer.parseInt(str[1]);
                if(str[0].equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if(map.isEmpty()) continue;
                    if(num == 1) {
                        int max = map.lastKey();
                        if(map.get(max) == 1) {
                            map.remove(max);
                        } else {
                            map.put(max, map.get(max) -1 );
                        }
                    } else {
                        int min = map.firstKey();
                        if(map.get(min) == 1) {
                            map.remove(min);
                        } else {
                            map.put(min, map.get(min) -1 );
                        }
                    }
                }
            }

            if(map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            }
            else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }

        }

        System.out.println(sb);

    }
}
