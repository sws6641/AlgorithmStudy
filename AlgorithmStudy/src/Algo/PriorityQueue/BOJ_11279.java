package Algo.PriorityQueue;

import java.util.*;
import java.io.*;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(que.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(que.poll()).append("\n");
                }
            }
            else {
                que.offer(x);
            }
        }

        System.out.println(sb.toString());
    }
}
