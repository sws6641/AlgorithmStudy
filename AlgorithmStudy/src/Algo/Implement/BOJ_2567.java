package Algo.Implement;

import java.util.*;
import java.io.*;

public class BOJ_2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int arr[][] = new int[101][101];
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] == 1) {
                    for(int k = 0 ; k < 4 ; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 1 || nx > 100 || ny < 1 || ny > 100 || arr[nx][ny] == 0){
                            cnt++;
                        }
                    }
                }

            }
        }

        System.out.println(cnt);
    }
}
