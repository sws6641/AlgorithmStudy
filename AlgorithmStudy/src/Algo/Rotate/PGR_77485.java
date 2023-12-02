package Algo.Rotate;

public class PGR_77485 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];

            int[][] arr = new int[rows + 1][columns + 1];

            int val = 1;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= columns; j++) {
                    arr[i][j] = val++;
                }
            }

            for (int i = 0; i < queries.length; i++) {
                int x1 = queries[i][0];
                int y1 = queries[i][1];
                int x2 = queries[i][2];
                int y2 = queries[i][3];

                int min = Integer.MAX_VALUE;
                int tmp = arr[x1][y1];

                for (int j = x1; j < x2; j++) {
                    arr[j][y1] = arr[j + 1][y1];
                    min = Math.min(arr[j + 1][y1], min);
                }
                for (int j = y1; j < y2; j++) {
                    arr[x2][j] = arr[x2][j + 1];
                    min = Math.min(arr[x2][j + 1], min);
                }
                for (int j = x2; j > x1; j--) {
                    arr[j][y2] = arr[j - 1][y2];
                    min = Math.min(arr[j - 1][y2], min);
                }
                for (int j = y2; j > y1; j--) {
                    arr[x1][j] = arr[x1][j - 1];
                    min = Math.min(arr[x1][j - 1], min);
                }
                arr[x1][y1 + 1] = tmp;
                min = Math.min(min, tmp);

                answer[i] = min;
            }
            
            return answer;
        }
    }
}
