package Algo.Stack;

import java.util.*;

public class PGR_176962 {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;

        // 시간 기준 오름차순
        Arrays.sort(plans, (o1, o2) -> {
            return convertTime(o1[1]) - convertTime(o2[1]);
        });

        Stack<String[]> sta = new Stack<>();

        String type = "";
        int time = 0;
        int period = 0;
        int current=0;
        int next = 0;
        for(int i = 0 ; i < plans.length ; i++){

            type = plans[i][0];
            time = convertTime(plans[i][1]);
            period = Integer.parseInt(plans[i][2]);

            current = time + period; // 작업 완료 시간
            if(i != plans.length - 1){ // 마지막 행(데이터)이 아니면
                next = convertTime(plans[i+1][1]);
            }

            if(current > next){ // 작업이 남아있는데 다음 작업이 들어온다면
                sta.push(new String[]{type, current - next+""});
                continue;
            }

            answer[idx++] = type;

            while(!sta.isEmpty()){
                int remain = next - current; // 다음 작업까지 남은 시간?

                String[] work = sta.pop();

                int rep = Integer.parseInt(work[1]); // 이전에 남아있던 작업 시간

                // 남은 과제 완료!?
                if(remain >= rep){
                    answer[idx++] = work[0];
                    current += rep;
                }
                else{ // 과제 멈춰야할때
                    sta.push(new String[]{work[0], rep - remain+""});
                    break;
                }
            }

        }

        //모든 과제를 탐색했다. 이젠 남은 멈춘과제 마저하자
        while(!sta.isEmpty()){
            answer[idx++] = sta.pop()[0];
        }

        return answer;
    }



    public static int convertTime (String time) { //분으로 변환
        String[] hm = time.split(":");

        int minute = 0;

        minute += Integer.parseInt(hm[0]) * 60;
        minute += Integer.parseInt(hm[1]);

        return minute;
    }
}
