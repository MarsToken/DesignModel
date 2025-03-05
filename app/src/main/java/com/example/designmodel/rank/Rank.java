package com.example.designmodel.rank;

/**
 * des
 *
 * @author WangMaoBo
 * @constructor 创建此类对象的主构造函数
 * @since 2024/12/16
 */
public class Rank {
    private static final String TAG = "Rank";

    public static void main(String[] args) {
        int array[] = {9, 10, 2, 3, -2, 8, 8};
//        bubbleRank(array);
//        selectRank(array);
        insertRank(array);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(",");
        }
        System.out.println(sb);
    }

    private static void insertRank(int[] array) {
        int length = array.length;
        int grap = length;
        do {
            grap /= 2;
            for (int i = grap; i < length - 1; i++) {
                int tempIndex = i;
                int current = array[i + 1];

                while (tempIndex >=0 && array[tempIndex]>current){
                    array[tempIndex+1]=array[tempIndex];
                    tempIndex--;
                }
                array[tempIndex+1]=current;
            }
        } while (grap > 0);
    }

    private static void selectRank(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int tempIndex = i;
            boolean flag = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[tempIndex] > array[j]) {
                    tempIndex = j;
                    flag = true;
                }
            }
            int temp = array[tempIndex];
            array[tempIndex] = array[i];
            array[i] = temp;
            if (!flag) {
                break;
            }
        }
    }

    private static void bubbleRank(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
