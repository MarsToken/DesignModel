package com.example.designmodel.leetcode.slidewindow;

/**
 //外层循环扩展右边界，内层循环扩展左边界
 for (int l = 0, r = 0 ; r < n ; r++) {
 //当前考虑的元素
 while (l <= r && check()) {//区间[left,right]不符合题意
 //扩展左边界
 }
 //区间[left,right]符合题意，统计相关信息
 }
 */
public class 滑动窗口万能模板 {
    private static final String TAG = "滑动窗口万能模板";

    public static void main(String[] args) {
        //外层循环扩展右边界，内层循环扩展左边界
        for (int l = 0, r = 0 ; r < args.length ; r++) {
            //当前考虑的元素
            while (l <= r && check()) { // 区间[left,right]不符合题意
                //扩展左边界
            }
            // 区间[left,right]符合题意，统计相关信息
        }
    }

    private static boolean check() {
        return false;
    }

}
