package Algo.DFS;

import java.util.*;

public class PGR_43164 {
    class Solution {

        static boolean[] visit;
        static ArrayList<String> list = new ArrayList<>();

        public String[] solution(String[][] tickets) {

            visit = new boolean[tickets.length];

            dfs(0, "ICN", "ICN", tickets);

            Collections.sort(list);

            String[] answer = list.get(0).split(" ");

            return answer;
        }

        public static void dfs(int depth, String from, String path, String[][] tickets) {
            if(depth == tickets.length) {
                list.add(path.toString());
                return;
            }

            for(int i = 0 ; i < tickets.length ; i++) {
                if(!visit[i] && tickets[i][0].equals(from)) {
                    visit[i] = true;
                    dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                    visit[i] = false;
                }
            }

        }

    }
}
