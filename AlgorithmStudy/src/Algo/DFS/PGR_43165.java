package Algo.DFS;

public class PGR_43165 {
    class Solution {

        static int answer = 0;

        public int solution(int[] numbers, int target) {

            dfs(numbers, target, 0, 0);

            return answer;
        }

        public static void dfs(int[] numbers, int target, int total, int idx) {
            if (idx == numbers.length) {
                if (target == total) {
                    answer++;
                    return;
                }
            } else {
                dfs(numbers, target, total + numbers[idx], idx + 1);
                dfs(numbers, target, total - numbers[idx], idx + 1);
            }

        }

    }
}
