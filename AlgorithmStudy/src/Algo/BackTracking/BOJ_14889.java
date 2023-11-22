package Algo.BackTracking;

import java.util.*;
import java.io.*;

public class BOJ_14889 {

    static int n, t;
    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }

    private static void dfs(int depth, int start) {
        if (depth == n/2) {

            int startTeam = 0;
            int linkTeam = 0;

            for(int i = 0 ; i < n-1 ; i++){
                for(int j = i+1 ; j < n ; j++){
                    if(visit[i] && visit[j]){
                        startTeam += arr[i][j] + arr[j][i];
                    }
                    else if(!visit[i] && !visit[j]){
                        linkTeam += arr[i][j] + arr[j][i];
                    }
                }
            }

            int val = Math.abs(startTeam - linkTeam);

            if(val == 0){
                System.out.println(0);
                System.exit(0);
            }

            min = Math.min(min, val);

            return;
        }

        for(int i = start ; i < n ; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
