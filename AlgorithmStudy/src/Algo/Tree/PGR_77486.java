package Algo.Tree;

import java.util.*;

public class PGR_77486 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, Integer> map = new HashMap<>(); // result를 위한 enroll 이름별 idx값
        ArrayList<Integer>[] list = new ArrayList[enroll.length + 1]; // +1 해준 이유 : 상단의 판매원 없을 경우를 위해?

        for (int i = 0; i < enroll.length + 1; i++) {
            list[i] = new ArrayList<>();

        }
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }

        for (int i = 0; i < referral.length; i++) {
            if (map.containsKey(referral[i])) { // 판매원을 조직에 참여시킨 사람이 있으면
                int start = map.get(enroll[i]);
                int end = map.get(referral[i]);
                list[start].add(end); // ex) list[2].add(1) edward -> mary
            } else {
                int start = map.get(enroll[i]);
                list[start].add(enroll.length); // list[0].add(8) john -> -
            }
        }

        for (int i = 0; i < seller.length; i++) {
            int sales = amount[i] * 100;

            Queue<Integer> que = new LinkedList<>();
            int idx = map.get(seller[i]);
            que.offer(idx);
            answer[idx] += sales;

            while (!que.isEmpty()) {
                int now = que.poll();

                if (sales == 0) break;
                for (int next : list[now]) {
                    sales /= 10;
                    answer[now] -= sales;
                    if (next == enroll.length) continue;
                    que.offer(next);
                    answer[next] += sales;
                }

            }
        }


        return answer;
    }
}
