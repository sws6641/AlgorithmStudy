package Algo.String;

public class PGR_12904 {
    class Solution{
        public int solution(String s){
            int answer = 1;

            for(int i = 1 ; i < s.length() ; i++){
                int tmp = 1;
                for(int j = i-1, k = i+1 ; j >= 0 && k < s.length() ; j--, k++){
                    if(s.charAt(j) == s.charAt(k)){
                        tmp += 2;
                    }
                    else{
                        break;
                    }
                }
                answer = Math.max(tmp, answer);
            }

            for(int i = 0 ; i < s.length() ; i++){
                int tmp = 0;
                for(int j = i, k = i+1 ; j >= 0 && k < s.length() ; j--, k++){
                    if(s.charAt(j) == s.charAt(k)){
                        tmp += 2;
                    }
                    else{
                        break;
                    }
                }
                answer = Math.max(tmp, answer);
            }

            return answer;
        }
    }
}
