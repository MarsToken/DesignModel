package com.example.designmodel.rank;

import java.util.Arrays;

/**
 * Created by hp on 2019/12/7.
 */
public class RankUtils {
    public static int[] array = new int[]{123, 4, 55, 3111, 334, 6, 2, 1};

    public static void main(String... args) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("\n before================================after");
        //bubbleSort();
        //selectSort();
        //insertSort();
        //shellSort();
        int[] array = mergeSort(RankUtils.array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }


    /**
     * 思路：
     * 1.先写两个完整for循环，
     * 2.再写相邻两个换值
     * 3.再定for的起始点
     * o(n)=o(n2);最好情况：一个也不用换
     */
    private static void bubbleSort() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {//并不影响: i<length or length-1
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    array[j] = array[j + 1] + array[j];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
    }

    /**
     * 思路：
     * 1.先写两个完整for循环，第二个for循环实际上是从i+1开始
     * 2.再写相邻两个换值
     * 3.再定for的起始点
     * o(n)=o(n2);最好情况：一个也不用换
     */
    private static void selectSort() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] < array[j]) {
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
            }
        }
    }

    /**
     * 插入排序，选中a，剩下的比a大放右边，比a小放左边 用到in-place排序（即只需用到O(1)的额外空间的排序）
     */
    private static void insertSort() {
        if (null == array) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int temp_index = i + 1;
            for (int j = 0; j < temp_index; j++) {
                if (array[temp_index] < array[j]) {
                    array[temp_index] += array[j];
                    array[j] = array[temp_index] - array[j];
                    array[temp_index] = array[temp_index] - array[j];
                }
            }
        }
        //误区 此时array[temp_index]并没有变，变得只是temp_value
//        int length = array.length;
//        for (int i = 0; i < length - 1; i++) {
//            int temp = i + 1;
//            int temp_value = array[temp];//如果这样的话 最后一行赋值的应该是array[temp]
//            for (int j = 0; j < temp; j++) {
//                if (temp_value < array[j]) {
//                    temp_value = temp_value + array[j];
//                    array[j] = temp_value - array[j];
//                    temp_value = temp_value - array[j];
//                }
//            }
//        }
    }

    /**
     * 插入排序的改进（又叫缩小增量排序）
     * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     */
    private static void shellSort() {
        if (null == array) {
            return;
        }
        int length = array.length, gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length - 1; i++) {
                int temp_index = i + 1;
                for (int j = 0; j < temp_index; j++) {
                    if (array[temp_index] < array[j]) {
                        array[temp_index] += array[j];
                        array[j] = array[temp_index] - array[j];
                        array[temp_index] = array[temp_index] - array[j];
                    }
                }
            }
            gap /= 2;
        }
    }

    /**
     * 归并排序
     * 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间
     */
    private static int[] mergeSort(int[] array) {
        if (null == array) {
            return array;
        }
        int length = array.length;
        if (length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        System.out.println("merge left.length=" + left.length + ",merge right.length=" + right.length);
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

}
