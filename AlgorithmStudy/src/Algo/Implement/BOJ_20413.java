package Algo.Implement;

import java.util.*;
import java.io.*;

public class BOJ_20413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int grade[] = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++){
            grade[i] = Integer.parseInt(st.nextToken());
        }

        String str = br.readLine();

        int sum = 0;
        int pre = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == 'B'){
                pre = grade[0] - 1 - pre;
                sum += pre;
            }
            else if(str.charAt(i) == 'S'){
                pre = grade[1] - 1 - pre;
                sum += pre;
            }
            else if(str.charAt(i) == 'G'){
                pre = grade[2] - 1 - pre;
                sum += pre;
            }
            else if(str.charAt(i) == 'P'){
                pre = grade[3] - 1 - pre;
                sum += pre;
            }
            else{
                sum += grade[3];
            }
        }

        System.out.println(sum);
    }
}
