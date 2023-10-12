package Algo.DFS;

import java.util.*;
import java.io.*;

public class BOJ_2668 {

    static int n;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int arr[] = new int [n+1];
        visit = new boolean[n+1];

        for(int i = 1 ; i <= n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1 ; i <= n ; i++){
            visit[i] = true;
            dfs(i, i, arr);
            visit[i] = false;
        }
        sb.append(list.size()).append('\n');
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);

    }
    public static void dfs(int start, int goal, int[] arr){
        if(!visit[arr[start]]){
            visit[arr[start]] = true;
            dfs(arr[start], goal, arr);
            visit[arr[start]] = false;
        }
        if(arr[start] == goal){
            list.add(goal);
        }
    }
}
