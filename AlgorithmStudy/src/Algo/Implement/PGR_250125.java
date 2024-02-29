package Algo.Implement;

public class PGR_250125 {
    class Solution {
        public int solution(String[][] board, int h, int w) {
            int answer = 0;

            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};

            for(int i = 0 ; i < 4 ; i++) {
                int nx = h + dx[i];
                int ny = w + dy[i];

                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                    continue;
                }

                if(board[h][w].equals(board[nx][ny])) {
                    answer++;
                }
            }


            return answer;
        }
    }
}
