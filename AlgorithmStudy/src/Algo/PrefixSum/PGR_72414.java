package Algo.PrefixSum;

public class PGR_72414 {
    class Solution {
        public String solution(String play_time, String adv_time, String[] logs) {
            String answer = "";

            int min = convert2sec(play_time);

            int[] arr = new int[360000];

            for (int i = 0; i < logs.length; i++) {
                String[] logTime = logs[i].split("-");

                int startTime = convert2sec(logTime[0]);
                int endTime = convert2sec(logTime[1]);

                for (int j = startTime; j < endTime; j++) {
                    arr[j]++;
                }

            }

            int adv_time_sec = convert2sec(adv_time); // 광고시간

            long subset = 0;
            for (int i = 0; i < adv_time_sec; i++) {
                subset += arr[i];
            }

            long max = subset; // 누적 시청자 수
            long resultIdx = 0;

            for (int i = 1; i < min - adv_time_sec; i++) {

                subset = subset + arr[i + adv_time_sec] - arr[i];

                if (max < subset) {
                    max = subset;
                    resultIdx = i + 1;
                }
            }

            return convert2hour(resultIdx);
        }

        public static int convert2sec(String a) {
            String[] str = a.split(":");

            int h = Integer.parseInt(str[0]) * 60 * 60;
            int m = Integer.parseInt(str[1]) * 60;
            int s = Integer.parseInt(str[2]);

            return h + m + s;
        }

        public static String convert2hour(long sec) {
            long hour = sec / (60 * 60);
            long minute = sec / 60 - (hour * 60);
            long second = sec % 60;

            String a = Long.toString(hour);
            String b = Long.toString(minute);
            String c = Long.toString(second);
            if (hour < 10) {
                a = "0" + a;
            }
            if (minute < 10) {
                b = "0" + b;
            }
            if (second < 10) {
                c = "0" + c;
            }
            return a + ":" + b + ":" + c;
        }
    }
}
