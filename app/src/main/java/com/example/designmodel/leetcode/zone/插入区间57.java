package com.example.designmodel.leetcode.zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class 插入区间57 {
    private static final String TAG = "插入区间57";

    public static void main(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[]{0, 2};
        array[1] = new int[]{4, 5};
        array = insert(array, new int[]{8, 9});
        for (int[] element : array) {
            System.out.println("element:[" + element[0] + "," + element[1] + "]");
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            int originalLeft = intervals[i][0];
            int originalRight = intervals[i][1];
            if (originalLeft > right) { // 目标区间完全在区间左侧
                // 1.1.此时插入区间在最左侧
                if (!flag) {
                    list.add(new int[]{left, right});
                    flag = true;
                }
                list.add(new int[]{originalLeft, originalRight});
            } else if (originalRight < left) { // 目标区间完全在区间右侧
                list.add(new int[]{originalLeft, originalRight});
            } else {
                left = Math.min(originalLeft, left);
                right = Math.max(originalRight, right);
            }
        }
        // 1.2.此时插入区间在中间
        if (!flag) {
            list.add(new int[]{left, right});
        }
        return list.toArray(new int[list.size()][]);
    }

}
