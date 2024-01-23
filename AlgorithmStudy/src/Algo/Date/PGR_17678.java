package Algo.Date;

import java.util.*;

public class PGR_17678 {
    class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            int answer = 0;

            ArrayList<Integer>[] map = new ArrayList[n];
            PriorityQueue<Integer> que = new PriorityQueue<>();

            for(int i = 0 ; i < n ; i++) {
                map[i] = new ArrayList<>();
            }

            int idx = 0;
            int startShuttleTime = 540;

            for(String time : timetable) {
                que.offer(convertTime(time));
            }

            for(int i = 0 ; i < n ; i++) {
                while(!que.isEmpty()){
                    int now = que.poll();
                    if(now <= startShuttleTime && map[i].size() < m) {
                        map[i].add(now);
                        // answer = now - 1;
                    }
                    else{
                        que.add(now);
                        break;
                    }
                }
                startShuttleTime += t;
            }

            if(map[n-1].size() < m) { // 셔틀 남는 자리가 있을 경우 셔틀 도착시간 리턴
                answer = startShuttleTime - t;
            }
            else{
                answer = map[n-1].get(map[n-1].size() - 1) - 1; // 셔틀 승객중 가장 늦게타는 사람에서 -1 만큼
            }

            return convertTimeToString(answer);
        }

        private static int convertTime(String time) {
            String[] str = time.split(":");

            return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        }

        private static String convertTimeToString(int time) {
            String h = "0" + String.valueOf(time / 60);
            String m = "0" + String.valueOf(time % 60);

            return h.substring(h.length()-2) + ":" +  m.substring(m.length()-2);
        }
    }
}
