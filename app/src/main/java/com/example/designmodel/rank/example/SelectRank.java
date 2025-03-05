package com.example.designmodel.rank.example;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/5
 */
public class SelectRank {
    private static final String TAG = "SelectRank";

    /**
     * 时间复杂度：n2、非自适应，引入flag后可变为自适应
     * 空间复杂度：1 原地排序
     * 非稳定 ，相同元素可能会换位置
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
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex] > array[j]) {
                    flag = true;
                    minIndex = j;
                }
            }
            array[i] += array[minIndex];
            array[minIndex] = array[i] - array[minIndex];
            array[i] = array[i] - array[minIndex];
            if (!flag) {
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 数据交换另外一种写法
     *int temp = array[minIndex];
     *array[minIndex] = array[i];
     *array[i] = temp;
     */
}
