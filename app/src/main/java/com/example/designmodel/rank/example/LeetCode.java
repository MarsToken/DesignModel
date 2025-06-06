package com.example.designmodel.rank.example;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.designmodel.datastructure.LinkedNodeTest;
import com.example.designmodel.datastructure.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by WangMaoBo.
 * Date: 2025/4/2
 */
public class LeetCode {
    private static final String TAG = "LeetCode";

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 == null ? list2 : list1;
        return root.next;
    }

    // 21.合并两个有序链表
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 300. 最长递增子序列
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        boolean isContain = contains(ans, list);
                        if (isContain) {
                            continue;
                        }
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

    private boolean contains(List<List<Integer>> ans, List<Integer> list) {
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> element = ans.get(i);
            Collections.sort(element);
            Collections.sort(list);
            if (element.get(0) == list.get(0)
                && element.get(1) == list.get(1)
                && element.get(2) == list.get(2)) {
                return true;
            }
        }
        return false;
    }

    // 48. 旋转图像
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] new_matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                new_matrix[j][length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = new_matrix[i][j];
            }
        }
    }

    // 560. 和为 K 的子数组
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // 704. 二分查找
    public int search(int[] nums, int target) {
        int index = -1;
        if (nums == null || nums.length == 0) {
            return index;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return index;
    }

    // 509. 斐波那契数
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // 56. 合并区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (-1 == index || result[index][1] < cur[0]) {
                result[++index] = cur;
            } else {
                result[index][1] = Math.max(cur[1], result[index][1]);
            }
        }
        return Arrays.copyOf(result, index + 1);

    }

    // 92. 反转链表 II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode resultLeft = new ListNode(0);
        ListNode resultRight = new ListNode(0);
        ListNode newHead = new ListNode(0);
        while (null != head && head.val != left) {
            resultLeft.next = head;
            head = head.next;
        }
        while (null != head && head.val != right) {
            newHead.next = head;
            head = head.next;
        }
        while (head != null) {
            resultRight.next = head;
            head = head.next;
        }
        ListNode pre = null;
        ListNode current = newHead.next;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        ListNode result = resultLeft.next;
        if (null != pre) {
            pre.next = resultRight.next;
            result.next = pre;
        } else {
            result.next = resultRight.next;
        }
        return result;
    }

    private ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    // 215. 数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
        if (nums.length <= 0) {
            return -1;
        }
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        int offset = 0;
        if (min < 0) {
            offset = -min;
        }
        int[] buckets = new int[max + 1 + offset];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + offset]++;
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                nums[index++] = i - offset;
            }
        }
        return nums[nums.length - k];
    }

    // LCR 078. 合并 K 个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode current = null;
        for (int i = 0; i < lists.length; i++) {
            current = mergeTwoLists(current, lists[i]);
        }
        return current;
    }

    // 42. 接雨水
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, lMax = 0, rMax = 0, sum = 0;
        while (left < right) {
            lMax = Math.max(height[left], lMax);
            rMax = Math.max(height[right], rMax);
            if (height[left] < height[right]) {
                sum += (lMax - height[left++]);
            } else {
                sum += (rMax - height[right--]);
            }
        }
        return sum;
    }

    // 9.回文数
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xString = Integer.toString(x);
        int left = 0, right = xString.length() - 1;
        while (left < right) {
            if (xString.charAt(left) != xString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 深搜/回溯模板
     * <p>
     * void backtrack() {
     * if (终止条件) {
     * 收获结果
     * return;
     * }
     * for (当前层) {
     * 做一些操作
     * 递归搜索下一层 backtrack()
     * 回溯
     * }
     * }
     */

    //-----------------------------------经典100--------------------------------------

    /**
     * 624.数组列表中的最大距离
     * <p>
     * 选择排序思路
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDis = 0;
        for (int i = 0; i < arrays.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arrays.size(); j++) {
                maxDis = Math.max(maxDis, compareTo2(arrays.get(index), arrays.get(j)));
            }
        }
        return maxDis;
    }

    private int compareTo2(List<Integer> src1, List<Integer> src2) {
        int maxDis = 0;
        maxDis = Math.max(maxDis, Math.abs(src1.get(0) - src2.get(src2.size() - 1)));
        maxDis = Math.max(maxDis, Math.abs(src2.get(0) - src1.get(src1.size() - 1)));
        return maxDis;
    }

    private int compareTo(List<Integer> src1, List<Integer> src2) {
        int maxDis = 0;
        for (int i = 0; i < src1.size(); i++) {
            for (int j = 0; j < src2.size(); j++) {
                maxDis = Math.max(maxDis, Math.abs(src1.get(i) - src2.get(j)));
            }
        }
        return maxDis;
    }

    /**
     * 159.至多包含两个不同字符的最长子串
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        int length = s.length();
        while (right < length) {
            if (map.size() < 3) {
                map.put(s.charAt(right), right);
                right++;
            }
            if (map.size() == 3) {
                int deleteIndex = Collections.min(map.values());
                map.remove(s.charAt(deleteIndex));
                left = deleteIndex + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    /**
     * 266.回文排列
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (int c : map.values()) {
            count += c % 2;
        }
        return count <= 1;
    }


    public String decodeIp(String ips) {
        if (null == ips || ips.isEmpty()) {
            return "";
        }
        int length = ips.length();
        if (ips.length() > 12 || ips.length() < 4) {
            return "";
        }
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j - i < 4; j++) {
                for (int k = j + 1; k < length && k - j < 4; k++) {
                    String first = ips.substring(0, i);
                    String second = ips.substring(i, j);
                    String third = ips.substring(j, k);
                    String four = ips.substring(k);
                    if (four.length() >= 4 || !check(four) || !check(third) || !check(second) || !check(first)) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(first);
                    sb.append(second);
                    sb.append(third);
                    sb.append(four);
                    return sb.toString();
                }
            }
        }
        return "";
    }

    private boolean check(String value) {
        return !(value.length() > 1 && value.charAt(0) == '0') || Integer.parseInt(value) > 255;
    }

}
