package com.example.designmodel.datastructure;

import java.util.Hashtable;

/**
 * 数组去重
 * .时间复杂度和空间复杂度的妥协问题
 * 案例一个数组 10万个元素，里面有个重复的元素，怎么挑出来。
 * 用set仅耗时13ms，用双重for循环最坏的复杂度n2是787，set是通过hashcode及equals判断是否为相同的元素，不是则放到hashcode对应的地址下，所以很快，不需要遍历；
 * 但是这是牺牲空间复杂度的基础上的；
 * 如果数字是1个亿，会oom，建议：将数组分开一段段去重！
 * 比如创建1000个set对象：
 * 实际效果,set：12849ms
 * 双重for循环：根据上面的参考应该是：
 * 10’2:787ms
 * 10‘2*1000’2:787*1000‘2ms=787000s=13116min=218h
 * Created by hp on 2020/4/1.
 */
public class SetTest {
    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                array[i] = i;
            } else {
                array[i] = array[array.length - 2];
            }
        }
        System.out.println("finished!");
        long start1 = System.currentTimeMillis();
        //multi set
        Hashtable<Integer, Integer> map = new Hashtable<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
                System.out.println("====" + array[i]);
            } else {
                map.put(array[i], 1);
            }
        }
        //one set oom
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < array.length; i++) {
//            boolean isAdd = set.add(array[i]);
//            if (!isAdd) {
//                System.out.println("=====" + array[i]);
//            }
//        }
        long end1 = System.currentTimeMillis();
        System.out.println("set's time=" + (end1 - start1));
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println("===========" + array[i]);
                }
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println("for's time=" + (end2 - start2));
    }

    private static int[] array = new int[100000];
}
