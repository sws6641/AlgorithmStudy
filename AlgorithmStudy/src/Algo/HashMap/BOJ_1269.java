package Algo.HashMap;

import java.util.*;
import java.io.*;

public class BOJ_1269 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < a ; i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < b ; i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int q : map.keySet()){
            if(map.get(q) == 1){
                count++;
            }
        }

        System.out.println(count);

    }
}
