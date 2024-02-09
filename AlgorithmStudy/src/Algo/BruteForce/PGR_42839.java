package Algo.BruteForce;

import java.util.*;

public class PGR_42839 {
    class Solution {

        static boolean[] visit = new boolean[7];
        static Set<Integer> set = new HashSet<>();

        public int solution(String numbers) {
            int answer = 0;
            int len = numbers.length();

            for(int i = 0 ; i < len ; i++) {
                dfs(numbers, "", i+1);
            }

            boolean chk;
            for(int a : set){
                // System.out.println(a);
                chk = true;

                if(a < 2) continue;
                for(int i = 2 ; i*i <= a ; i++) {  // 에라토스테네스 체
                    if(a % i == 0) {
                        chk = false;
                        break;
                    }
                }
                if(chk) answer++;
            }

            return answer;
        }

        public static void dfs(String str, String tmp, int m) {
            if(m == tmp.length()) {
                int num = Integer.parseInt(tmp);
                set.add(num);
            }

            for(int i = 0 ; i < str.length() ; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    tmp += str.charAt(i);
                    dfs(str, tmp, m);
                    visit[i] = false;
                    tmp = tmp.substring(0, tmp.length()-1);
                }
            }

        }

    }
}
