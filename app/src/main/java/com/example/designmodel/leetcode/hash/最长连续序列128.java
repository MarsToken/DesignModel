package com.example.designmodel.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 *题解说的比较复杂，不太容易懂，简单来说就是每个数都判断一次这个数是不是连续序列的开头那个数。
 *
 * 怎么判断呢，就是用哈希表查找这个数前面一个数是否存在，即num-1在序列中是否存在。存在那这个数肯定不是开头，直接跳过。
 * 因此只需要对每个开头的数进行循环，直到这个序列不再连续，因此复杂度是O(n)。
 * 以题解中的序列举例:
 * [100，4，200，1，3，4，2]
 * 去重后的哈希序列为：
 * [100，4，200，1，3，2]
 * 按照上面逻辑进行判断：
 * 元素100是开头,因为没有99，且以100开头的序列长度为1
 * 元素4不是开头，因为有3存在，过，
 * 元素200是开头，因为没有199，且以200开头的序列长度为1
 * 元素1是开头，因为没有0，且以1开头的序列长度为4，因为依次累加，2，3，4都存在。
 * 元素3不是开头，因为2存在，过，
 * 元素2不是开头，因为1存在，过。
 * 完
 */
public class 最长连续序列128 {
    private static final String TAG = "最长连续序列128";

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 找到最小的，不是最小的则忽略，充分利用set查找元素时间复杂度为1的特性。
        // 然后 开启循环，再依次找最小的+1的元素，存在则加1，不存在则结束循环。
        int result = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int currentNum = num;
            int maxLength = 1;
            while (set.contains(currentNum + 1)) {
                maxLength++;
                currentNum = currentNum + 1;
            }
            result = Math.max(result, maxLength);
        }
        return result;
    }
}
