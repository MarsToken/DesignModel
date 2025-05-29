package com.example.designmodel.leetcode.doublepointer;

/**
 *
 */
public class 双指针头尾法万能模板 {
    private static final String TAG = "双指针头尾法万能模板";

    public static void main(String[] args) {
        //外层循环扩展右边界，内层循环扩展左边界
        int left = 0, right = args.length;
        while (left < right) {
            //当前考虑的元素
            if (check()) { // 区间[left,right]符合题意
                // 直接返回
            } else { // 不符合提议 则滚动游标

            }
            // 区间[left,right]符合题意，统计相关信息，如果有必要！
        }
    }

    private static boolean check() {
        return false;
    }
}
