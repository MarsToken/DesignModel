package com.example.designmodel.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hp on 2020/11/16.
 */
public class TestRankUtils {
    private static final int[] array = new int[]{19, 0, 11,31,21, 33, 34, 878, 5};

    public static void main(String[] args) {
        //radixSort();
        //quickRank(array, 0, array.length - 1);
        //float[] array = mergeRank(VideoPlayerActivity.array);
        shellRank2();
        //shellRank();
        //insertRank2();
        //insertRank();
        //selectRank();
        //bubbleRank();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    static int index_ex=0;
    /**
     * 限制小数and负数
     */
    private static void radixSort() {
        if (array == null || array.length < 1) {
            return;
        }
        int length = array.length;
        float max = array[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        //以位数的数值为索引，存放包含此数值的原始元素
        List<ArrayList<Integer>> queue_out = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queue_out.add(new ArrayList<Integer>());
        }
        //依次获取个十百千对应的数值
        for (int i = 0; i < maxDigit; i++) {//i=0表示个位
            for (int j = 0; j < length; j++) {//190,1,11,23
                //0,1,1,3
                int x = (int) (array[j] % Math.pow(10, i + 1) / Math.pow(10, i));//每个数组元素的个位数值
                //System.out.println("xxx=" + x);
                queue_out.get(x).add(array[j]);
                //queue_out.set(x, queue_inner);
            }
            int count = 0;
            for (int j = 0; j < 10; j++) {
                ArrayList<Integer> queue_inner = queue_out.get(j);
                while (queue_inner.size() > 0) {
                    array[count] = queue_inner.get(0);
                    System.out.println(String.format("array[%d]=%d", count, queue_inner.get(0)));
                    index_ex++;
                    System.out.println(String.format("count=%d", index_ex));
                    queue_inner.remove(0);
                    count++;
                }
            }
        }
    }

    private static void quickRank(float[] array, int start, int end) {
        int length = array.length;
        if (length <= 0 || start < 0 || end >= length || start > end) {
            return;
        }
        int partition = partition(array, start, end);
        if (start < partition) {
            quickRank(array, start, partition - 1);
        }
        if (partition < end) {
            quickRank(array, partition + 1, end);
        }
    }

    private static int partition(float[] array, int start, int end) {
        int random = (int) ((end - start + 1) * Math.random() + start);
        swap(array, random, end);
        int index = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                index++;
                if (index < i) {
                    swap(array, index, i);
                }
            }
        }
        return index;
    }

    private static void swap(float[] array, int pivot, int end) {
        if (pivot == end) return;
        array[pivot] += array[end];
        array[end] = array[pivot] - array[end];
        array[pivot] = array[pivot] - array[end];
    }

    private static float[] mergeRank(float[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }
        int mid = length / 2;
        float[] left = Arrays.copyOfRange(array, 0, mid);
        float[] right = Arrays.copyOfRange(array, mid, length);
        return merge(mergeRank(left), mergeRank(right));
    }

    private static float[] merge(float[] left, float[] right) {
        float[] result = new float[left.length + right.length];
        for (int i = 0, index_left = 0, index_right = 0; i < result.length; i++) {
            if (index_left >= left.length) {
                result[i] = right[index_right++];
            } else if (index_right >= right.length) {
                result[i] = left[index_left++];
            } else if (left[index_left] > right[index_right]) {
                result[i] = right[index_right++];
            } else {
                result[i] = left[index_left++];
            }
        }
        return result;
    }

    private static void test() {
        int length = array.length, mid = 0;
        do {
            mid = length / 2;
            for (int i = mid; i < length - 1; i++) {
                int current = array[i + 1];
                int j = i;
                while (j >= 0 && array[j] > current) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = current;
            }
        } while (mid == 0);
    }

    private static void shellRank2() {
        int length = array.length, mid = length;
        do {
            mid  /= 2;
            for (int i = mid; i < length - 1; i++) {
                int current = array[i + 1];
                int j = i;
                while (j >= 0 && array[j] > current) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = current;
            }
        } while (mid > 0);
    }

    private static void insertRank2() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int current = array[i + 1];
            int j = i;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    private static void insertRank() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int temp = i + 1;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[temp]) {
                    changedTwoValue(j, temp);
                }
            }
        }
    }

    private static void selectRank() {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[i]) {
                    changedTwoValue(j, i);
                }
            }
        }
    }

    private static void bubbleRank() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    changedTwoValue(j, j + 1);
                }
            }
        }
    }

    private static void changedTwoValue(int a_index, int b_index) {
        array[a_index] += array[b_index];
        array[b_index] = array[a_index] - array[b_index];
        array[a_index] = array[a_index] - array[b_index];
    }
}
