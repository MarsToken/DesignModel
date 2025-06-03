package com.example.designmodel.leetcode.zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class 合并区间56 {
    private static final String TAG = "合并区间56";

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left, right});
            } else {
                list.get(list.size() - 1)[1] = Math.max(right, list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
