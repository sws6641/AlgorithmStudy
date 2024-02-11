package Algo.PrefixSum;

public class PGR_155651 {
    class Solution {
        public int solution(String[][] book_time) {
            int answer = 0;

            int totalTime = 24*60 + 10;

            int[] arr = new int[totalTime];

            for(String[] time : book_time) {
                int start = convertToMin(time[0]);
                int end = convertToMin(time[1]);

                for(int i = start ; i < end + 10 ; i++) {
                    arr[i]++;
                }
            }

            int max = 0;
            for(int i = 0 ; i < arr.length ; i++) {
                if(max < arr[i]) {
                    max = arr[i];
                }
            }

            return max;
        }

        public static int convertToMin(String time) {
            String[] str = time.split(":");

            int hour = Integer.parseInt(str[0]) * 60;
            int min = Integer.parseInt(str[1]);

            return hour + min;
        }
    }
}
