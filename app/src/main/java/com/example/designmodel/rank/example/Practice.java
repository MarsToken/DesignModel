package com.example.designmodel.rank.example;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/6
 */
public class Practice {
    private static final String TAG = "Practice";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array || array.length == 0) {
            return;
        }
        int length = array.length;
        bucketRank(array);

        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    private static void bucketRank(int[] array) {

    }


}
