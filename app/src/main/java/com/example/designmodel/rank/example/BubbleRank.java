package com.example.designmodel.rank.example;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/6
 */
public class BubbleRank {
    private static final String TAG = "BubbleRank";

    /**
     * 时间复杂度：n2、非自适应，引入flag后可变为自适应
     * 空间复杂度：1 原地排序
     * 稳定 ，相同元素不换位置
     *
     */
    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
