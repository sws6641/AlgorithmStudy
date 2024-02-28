package Algo.Implement;

public class PGR_161990 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];


            int leftX = Integer.MAX_VALUE;;
            int leftY = Integer.MAX_VALUE;
            int rightX = 0;
            int rightY = 0;

            for(int i = 0 ; i < wallpaper.length ; i++) {
                char[] cha = wallpaper[i].toCharArray();
                for(int j = 0 ; j < wallpaper[0].length() ; j++) {
                    if(cha[j] == '#') {
                        leftX = Math.min(leftX, i);
                        leftY = Math.min(leftY, j);

                        rightX = Math.max(rightX, i+1);
                        rightY = Math.max(rightY, j+1);
                    }

                }
            }

            answer[0] = leftX;
            answer[1] = leftY;
            answer[2] = rightX;
            answer[3] = rightY;

            return answer;
        }
    }
}
