package Algo.Implement;

import java.util.*;
public class PGR_155652 {
    class Solution {
        public String solution(String s, String skip, int index) {
            String answer = "";
            StringBuilder sb = new StringBuilder();

            int[] engIdx = new int[26];
            for(int i = 0 ; i < 26 ; i++) {
                engIdx[i] = i;
            }

            char[] eng = new char[26];
            for(int i = 0 ; i < 26 ; i++) {
                eng[i] = (char)(i + 97);
            }

            System.out.println(Arrays.toString(eng));


            for(int i = 0 ; i < s.length() ; i++) {
                char cha = s.charAt(i);

                for(int j = 0 ; j < index ; j++) {
                    cha += 1;
                    if(cha > 'z') {
                        cha -= 26;
                    }
                    if(skip.contains(String.valueOf(cha))) {
                        j--;
                    }
                }
                sb.append(cha);
            }

            return sb.toString();
        }
    }
}
