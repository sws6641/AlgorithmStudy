package Algo.DP;

import java.util.*;
import java.io.*;

public class BOJ_9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int lcs[][] = new int[str1.length()+1][str2.length()+1];

        for(int i = 1 ; i < lcs.length ; i++){
            for(int j = 1 ; j < lcs[i].length ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        System.out.println(lcs[str1.length()][str2.length()]);

    }
}
