package com.example.designmodel.rank;

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
        insertSort();
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

    private static void insertSort() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int currentIndex = i + 1;
            for (int j = 0; j < currentIndex; j++) {
                if (array[currentIndex] < array[j]) {
                    array[currentIndex] = array[currentIndex] + array[j];
                    array[j] = array[currentIndex] - array[j];
                    array[currentIndex] = array[currentIndex] - array[j];
                }
            }
        }
    }

}
