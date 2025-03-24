package com.example.designmodel.rank.example;

/**
 * Created by WangMaoBo.
 * Date: 2025/3/22
 */
public class RadixRank {
    private static final String TAG = "RadixRank";

    public static void main(String[] args) {
        int[] array = Constant.array;
        if (null == array) {
            return;
        }
        int length = array.length;
        if (length < 2) {
            return;
        }
        radixRank(array);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    private static void radixRank(int[] array) {
        // 1.获取最大值
        int max = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        // 2.根据最大值，以位数为维度个位->最大位数排序
        for (int bit = 1; bit <= max; bit *= 10) {
            countingSortDigit(array, bit);
        }
    }

    private static void countingSortDigit(int[] array, int bit) {
        // 统计0-9各数字的出现次数
        int[] buckets = new int[10];
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int num = digit(array[i], bit);
            buckets[num]++;
        }
        // 求前缀和
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }
        // 为保持稳定性，倒序遍历
        int[] res = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int num = digit(array[i], bit);
            int index = buckets[num] - 1;
            res[index] = array[i];
            buckets[num]--;
        }
        // 赋值
        for (int i = 0; i < length; i++) {
            array[i] = res[i];
        }
    }

    // 获取bit位的数字，比如 123，bit=10，即表示获取十位数的数字，为2
    private static int digit(int digit, int bit) {
        return (digit / bit) % 10;
    }
}
