package Algo.Map;

import java.util.*;
public class PGR_178871 {
    class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = new String[players.length];

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0 ; i < players.length ; i++) {
                map.put(players[i], i);
            }

            for(int i = 0 ; i < callings.length ; i++) {
                int idx = map.get(callings[i]);
                String beforeName = players[idx-1];

                players[idx-1] = callings[i];
                players[idx] = beforeName;

                map.put(callings[i], idx-1);
                map.put(beforeName, idx);


            }

            return players;
        }
    }
}
