package com.example.designmodel.rank;

/**
 * des
 *
 * @author WangMaoBo
 * @constructor 创建此类对象的主构造函数
 * @since 2025/3/4
 */
public class TestLeetCode {
    private static final String TAG = "TestLeetCode";

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int i = 0; i < 6; i++) {
            System.out.println(nums1[i]);
        }
        System.out.println("=============================");
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node result = revertNode(node1);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    /**
     * 列表学会！！中间变量！！
     *
     * @param root
     * @return
     */
    private static Node revertNode(Node root) {
        if (root == null) {
            return root;
        }
        Node pre = null;
        Node current = root;
        while (current != null) {
            Node temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }



    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int[] mergeArray = new int[length];
        int nums1_index = 0;
        int nums2_index = 0;
        int index = 0;
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (nums1_index >= nums1.length) {
                if (nums2[nums2_index] != 0) {
                    mergeArray[index++] = nums2[nums2_index];
                }
                nums2_index++;
            } else if (nums2_index >= nums2.length) {
                if (nums1[nums1_index] != 0) {
                    mergeArray[index++] = nums1[nums1_index];
                }
                nums1_index++;
            } else if (nums1[nums1_index] > nums2[nums2_index]) {
                if (nums2[nums2_index] != 0) {
                    mergeArray[index++] = nums2[nums2_index];
                }
                nums2_index++;
            } else {
                if (nums1[nums1_index] != 0) {
                    mergeArray[index++] = nums1[nums1_index];
                }
                nums1_index++;
            }
        }
        for (int i = 0; i < mergeArray.length; i++) {
            nums1[i] = mergeArray[i];
        }
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
