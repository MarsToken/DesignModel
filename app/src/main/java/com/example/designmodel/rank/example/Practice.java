package com.example.designmodel.rank.example;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

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
        bucketRank(array);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }

    }

    private static void bucketRank(int[] array) {
        int bucket_deep = 2;
        int bucket_count = array.length / bucket_deep;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucket_count; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int element : array) {
            int index = getIndex(array, element, bucket_count);
            buckets.get(index).add(element);
        }
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int element : bucket) {
                array[index++] = element;
            }
        }
    }

    private static int getIndex(int[] array, int element, int bucket_count) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max<array[i]){
                max=array[i];
            }
        }
        return element / max * (bucket_count - 1);
    }

}
