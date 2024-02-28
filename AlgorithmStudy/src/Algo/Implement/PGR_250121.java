package Algo.Implement;

import java.util.*;
public class PGR_250121 {
    class Solution {

        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            int[][] answer = {};

            int idx = 0;
            if(sort_by.equals("code")) {
                idx = 0;
            } else if(sort_by.equals("date")) {
                idx = 1;
            } else if(sort_by.equals("maximum")) {
                idx = 2;
            } else if(sort_by.equals("remain")) {
                idx = 3;
            }

            final int finalIdx = idx;

            Arrays.sort(data, (o1, o2) -> {
                return o1[finalIdx] - o2[finalIdx];
            });

            ArrayList<int[]> list = new ArrayList<>();

            for(int i = 0 ; i < data.length ; i++) {
                int idx2 = 0;
                if(ext.equals("code")) {
                    idx2 = 0;
                } else if(ext.equals("date")) {
                    idx2 = 1;
                } else if(ext.equals("maximum")) {
                    idx2 = 2;
                } else if(ext.equals("remain")) {
                    idx2 = 3;
                }

                if(data[i][idx2] < val_ext) {
                    list.add(data[i]);
                }

            }

            for(int[] x : list) {
                System.out.println(Arrays.toString(x));
            }

            int[][] data2 = new int[list.size()][4];

            for(int i = 0 ; i < data2.length ; i++) {
                data2[i] = list.get(i);
            }

            return data2;
        }
    }
}
