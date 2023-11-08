package Algo.BruteForce;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class BOJ_2529 {

    static int k;
    static String bu[];
    static int num[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int ans[];
    static boolean visit[] = new boolean[10];
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        ans = new int[k + 1];
        bu = br.readLine().split(" ");

        chk(0);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }

    private static void chk(int dep) {
        if (dep == k + 1) {
            boolean check = true;
            for(int i = 0 ; i < bu.length ; i++){
                String a = bu[i];
                if(a.equals("<")){
                    if(ans[i] >= ans[i+1]){
                        check = false;
                        break;
                    }
                }
                else{
                    if(ans[i] <= ans[i+1]){
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                for(int a : ans){
                    sb.append(a);
                }
                list.add(String.valueOf(sb));
                sb.delete(0, sb.length());
            }
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ans[dep] = num[i];
                chk(dep+1);
                visit[i] = false;
            }
        }

    }
}
