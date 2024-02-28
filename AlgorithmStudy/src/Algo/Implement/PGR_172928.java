package Algo.Implement;

public class PGR_172928 {
    class Solution {

        char[][] map;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];

            int w = park.length;
            int h = park[0].length();

            map = new char[w][h];

            int startx = 0;
            int starty = 0;
            for(int i = 0 ; i < park.length ; i++) {
                char[] cha = park[i].toCharArray();
                for(int j = 0 ; j < cha.length ; j++) {
                    map[i][j] = cha[j];
                    if(cha[j] == 'S') {
                        startx = i;
                        starty = j;
                    }
                }
            }

            for(int i = 0 ; i < routes.length ; i++) {
                String[] str = routes[i].split(" ");

                boolean chk = true;
                int moveIdx = 0;
                int move = Integer.parseInt(str[1]);

                int newStartx = startx;
                int newStarty = starty;

                if(str[0].equals("E")) {
                    moveIdx = 0;
                } else if(str[0].equals("S")) {
                    moveIdx = 1;
                } else if(str[0].equals("W")) {
                    moveIdx = 2;
                } else if(str[0].equals("N")) {
                    moveIdx = 3;
                }

                for(int j = 0 ; j < move ; j++) {
                    int nx = newStartx + dx[moveIdx];
                    int ny = newStarty + dy[moveIdx];

                    if(nx < 0 || nx >= w || ny < 0 || ny >= h || map[nx][ny] == 'X') {
                        chk = false;
                        break;
                    }
                    newStartx = nx;
                    newStarty = ny;
                }

                if(chk) {
                    startx = newStartx;
                    starty = newStarty;
                } else {
                    newStartx = startx;
                    newStarty = starty;
                }

            }

            answer[0] = startx;
            answer[1] = starty;

            return answer;
        }
    }
}
