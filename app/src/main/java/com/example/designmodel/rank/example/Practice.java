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
        quickRank(array,0,length-1);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i] + " ");
        }

    }

    private static void quickRank(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int baseIndex=getBaseIndex(array,left,right);
        quickRank(array, 0, baseIndex - 1);
        quickRank(array,baseIndex+1,right);
    }

    private static int getBaseIndex(int[] array, int left, int right) {
        int i=left,j=right;
        while (i<j){
            while (i<j&&array[left]>=array[j]){
                j--;
            }
            while (i<j&&array[left]<=array[i]){
                i++;
            }
            swap(array,i,j);
        }
        swap(array,left,i);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;

    }


}
