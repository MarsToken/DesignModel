package com.example.designmodel.rank.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
//    public int[][] merge(int[][] intervals) {
//
//    }

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
}
