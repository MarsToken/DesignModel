package com.example.designmodel.rank.example;

import java.util.Arrays;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/6
 */
public class Practice {
    private static final String TAG = "Practice";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }
    }



}
