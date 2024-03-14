package Algo.Implement;

public class PGR_67256 {
    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            StringBuilder sb = new StringBuilder();

            int left = 10;
            int right = 12;

            for(int i = 0 ; i < numbers.length ; i++) {
                int num = numbers[i];

                if(num == 1 || num == 4 || num == 7) {
                    sb.append("L");
                    left = num;

                } else if(num == 3 || num == 6 || num == 9) {
                    sb.append("R");
                    right = num;
                } else {
                    if(num == 0) num = 11;

                    int ldiff = (Math.abs(left - num) / 3) + (Math.abs(left - num) % 3);
                    int rdiff = (Math.abs(right - num) / 3) + (Math.abs(right - num) % 3);

                    if(ldiff < rdiff) {
                        sb.append("L");
                        left = num;
                    } else if(ldiff > rdiff) {
                        sb.append("R");
                        right = num;
                    } else {
                        if(hand.equals("left")) {
                            sb.append("L");
                            left = num;
                        }
                        else {
                            sb.append("R");
                            right = num;
                        }
                    }
                }
            }

            return sb.toString();
        }
    }
}
