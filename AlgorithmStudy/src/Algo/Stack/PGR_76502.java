package Algo.Stack;

import java.util.*;

public class PGR_76502 {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            for(int i = 0 ; i < s.length() ; i++){
                Stack<Character> sta = new Stack<>();

                boolean chk = true;

                for (int j = 0; j < s.length(); j++) {

                    if (sta.isEmpty()) {
                        sta.add(s.charAt(j));
                    } else if (s.charAt(j) == '[') {
                        sta.add('[');
                    } else if (s.charAt(j) == ']') {
                        if (sta.peek() != '[') chk = false;
                        else sta.pop();
                    } else if (s.charAt(j) == '{') {
                        sta.add('{');
                    } else if (s.charAt(j) == '}') {
                        if (sta.peek() != '{') chk = false;
                        else sta.pop();
                    } else if (s.charAt(j) == '(') {
                        sta.add('(');
                    } else if (s.charAt(j) == ')') {
                        if (sta.peek() != '(') chk = false;
                        else sta.pop();
                    } else chk = false;
                }

                if(sta.isEmpty()) chk = true;
                else chk = false;

                if(chk == true) answer++;
                s = s.substring(1,s.length())  + s.substring(0,1);

            }

            return answer;
        }
    }
}
