package com.example.designmodel.rank.example;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/6
 */
public class InsertRank {
    private static final String TAG = "InsertRank";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (array == null) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int j = i; // [0,i] 为已排好序列
            int base = array[j + 1]; // base为下一个未排序的第一位
            // 内循环：将 base 插入到已排序区间 [0, i] 中的正确位置
            while (j >= 0 && array[j] > base) {
                array[j + 1] = array[j]; // 将 array[j] 向右移动一位
                j--;
            }
            array[j + 1] = base; // 将 base 赋值到正确位置
        }
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
