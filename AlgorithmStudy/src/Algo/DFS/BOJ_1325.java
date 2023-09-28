package Algo.DFS;

import java.util.*;
import java.io.*;

public class BOJ_1325 {

    public static ArrayList<Integer>[] map;
    public static int result[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        result = new int[n + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x].add(y);
        }

        for (int i = 1; i <= n; i++) {
            boolean visit[] = new boolean[n + 1];
            dfs(i, visit);
        }

        for (int i = 1; i <= n; i++){
            max = Math.max(max, result[i]);
        }

        for (int i = 1; i <= n; i++){
            if(result[i] == max){

                // + 연산자를 사용하기 때문에 문자열 결합이 발생하여 새로운 문자열을 생성
                // 따라서 반복시 매번 새로운 문자열이 생성되므로 메모리 사용량이 많아짐 -> 시간초과
                // sb.append(i + " ");

                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

    }

    public static void dfs(int start, boolean[] visit) {
        visit[start] = true;

        for (int a : map[start]) {
            if (!visit[a]) {
                result[a]++;
                dfs(a, visit);
            }
        }
    }
}
