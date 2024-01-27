package Algo.Matrix;

import java.util.*;

public class PGR_60059 {
    class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = true;
            int padSize = lock.length - 1;

            for(int i = 0 ; i < 4 ; i++) {
                key = retate(key); // 90도씩 돌면서 key 배열 위치 바꿈
                int[][] paddedKey = pad(key, padSize); // 키 배열 리사이즈

                for(int j = 0 ; j < paddedKey.length - padSize ; j++) {
                    for(int k = 0 ; k < paddedKey.length - padSize ; k++) {
                        if(isValid(lock, paddedKey, j, k)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        public boolean isValid (int[][] lock, int[][]paddedKey, int j, int k) { // j, k는 시작점
            for(int l = 0 ; l < lock.length ; l++) {
                for(int m = 0 ; m < lock[0].length ; m++) {
                    // 열쇠 돌기와 자물쇠 돌기는 만나며 안됨! 무조건 포개져야함 (1이여야함!)
                    if(lock[l][m] + paddedKey[l+j][m+k] != 1){ // lock 값이 1이 아닌경우 (key와 맞춰지지 않은 경우)
                        return false;
                    }
                }
            }
            return true;
        }

        public int[][] pad (int[][] key, int padSize) {
            // key 길이 + 2*(lock-1) -> 좌측상단부터 한칸식 겹치는 부분을 탐색하기 위해서 길이 지정
            int[][] result = new int[key.length + padSize*2][key.length + padSize*2];

            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    result[padSize + i][padSize + j] = key[i][j]; // 배열사이즈 변경 후 key배열 값 삽입
                }
            }
            return result;
        }

        public int[][] retate (int[][] key) {
            int[][] result = new int[key.length][key.length];
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    result[i][j] = key[key.length - 1 - j][i];
                }
            }
            return result;
        }
    }
}
