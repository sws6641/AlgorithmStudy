package Algo.BackTracking;

public class PGR_92342 {
    class Solution {

        static int[] ryan = new int[11];
        static int max = Integer.MIN_VALUE;
        static int[] answer = {-1};

        public int[] solution(int n, int[] info) {

            dfs(0, n, info);

            return answer;
        }

        public static void dfs(int depth, int n, int[] info) {
            if(depth == n) {
                int apeachPoint = 0;
                int ryanPoint = 0;
                for(int i = 0; i < info.length ; i++) {
                    if(info[i] == 0 && ryan[i] == 0) continue; // 이거 빼먹었음
                    if(info[i] < ryan[i]) {
                        ryanPoint += 10 - i;
                    } else {
                        apeachPoint += 10 -i;
                    }
                }

                if(ryanPoint > apeachPoint) {
                    if(max < ryanPoint - apeachPoint) { // 최대값이 1개인 경우
                        max = ryanPoint - apeachPoint;
                        answer = ryan.clone();
                    } else if(max == ryanPoint - apeachPoint) { // 같은 점수 차이일 경우
                        for(int i = info.length - 1 ; i >= 0 ; i--) {
                            if(answer[i] < ryan[i]) {
                                answer = ryan.clone();
                                break;
                            } else if(answer[i] > ryan[i]) {
                                break;
                            }
                        }
                    }
                }
                return;
            }

            for(int i = 0 ; i < info.length && ryan[i] <= info[i] ; i++) {
                ryan[i] += 1;
                dfs(depth+1, n, info);
                ryan[i] -= 1;
            }

        }

    }
}
