package com.example.designmodel.leetcode;

/**
 * 算法：
 * 最后考虑边界情况！
 * <p>
 * 1.总结
 * set:除重
 * map:计数,两数和目标值
 * 计数排序：整型，时间复杂度o(n)
 * list:有序
 * <p>
 * 技巧：
 * 双指针：
 * 1.头尾法
 * 2.滑动窗体：快慢指针
 * <p>
 * LinkedList实现了双端队列Deque接口，也实实现了Queue接口（队列） 既不是纯粹的栈也不是纯粹的队列‌，而是一种‌双向链表数据结构‌
 * 栈：推荐用Stack，无api干扰
 * push,pop,peek(查看顶部),isEmpty,search,
 *
 * 队列：
 * add(null则抛异常),offer;poll,remove(null则抛异常);element(null则抛异常),peek(查看顶部) opp
 * 相同的api：peek（查看顶部）
 * 注意1：Deque对poll进行了拓展，比如pollLast表示移除并返回deque的最后一个元素，最后一个元素指的是index为last的那个
 *  仅适用于队列
 *
 */
public class Introduce {
    private static final String TAG = "Introduce";

    // 典型预留上个值缓存套路
    int preModel = -1;
    private void test(int val) {
        if (preModel != -1) { // 第二次以后才执行
            // current - preModel
        }
        preModel = val;
    }

}
