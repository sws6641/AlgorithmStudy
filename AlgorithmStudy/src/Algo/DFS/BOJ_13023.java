package Algo.DFS;

import java.util.*;
import java.io.*;
public class BOJ_13023 {

    public static ArrayList<Integer>[] map;
    public static boolean visit[];
    public static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for(int i = 0 ; i < n ; i++){
            dfs(i, 1);
        }
        System.out.println(answer);
    }

    private static void dfs(int i, int depth) {
        if(depth == 5){
            answer = 1;
            return;
        }

        visit[i] = true;
        for(int a : map[i]){
            if(!visit[a]){
                dfs(a, depth+1);
            }
        }
        visit[i] = false;
    }
}
