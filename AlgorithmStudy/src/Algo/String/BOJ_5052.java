package Algo.String;

import java.util.*;
import java.io.*;

public class BOJ_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < tc ; i++){
            int n = Integer.parseInt(br.readLine());
            String arr[] = new String[n];

            for(int j = 0 ; j < n ; j++){
                arr[j] = br.readLine();
            }
            Arrays.sort(arr);

            boolean chk = true;
            for(int j = 1 ; j < n ; j++){
                if(arr[j].startsWith(arr[j-1])){
                    chk = false;
                    break;
                }
            }

            if(chk){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

        }

    }
}
