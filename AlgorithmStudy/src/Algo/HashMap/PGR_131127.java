package Algo.HashMap;

import java.util.*;

public class PGR_131127 {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            Map<String, Integer> wantProduct = new HashMap<>();


            for(int i = 0 ; i <  want.length ; i++){
                wantProduct.put(want[i], number[i]);
            }

            for(int i = 0 ; i < discount.length - 10 + 1 ; i++){ // 시작 인덱스가 4까지 여야하니까
                Map<String, Integer> discount10 = new HashMap<>();

                for(int j = i ; j < i + 10 ; j++){
                    discount10.put(discount[j], discount10.getOrDefault(discount[j], 0) + 1);
                }

                boolean chk = true;
                for(String key : wantProduct.keySet()){
                    if(wantProduct.get(key) != discount10.get(key)){
                        chk = false;
                        break;
                    }
                }

                if(chk) answer++;

            }

            return answer;
        }
    }
}
