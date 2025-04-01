package com.example.designmodel.rank.datastructure;

/**
 * des
 *
 * @author WangMaoBo
 * @since 2025/4/1
 */
public class Test {
    private static final String TAG = "Test";

    public static void main(String[] args) {

    }

    public static String getIp(String ips) {
        int length = ips.length();
        if (length < 4 || length > 12) {
            return "";
        }
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < length && j - i < 4; j++) {
                for (int k = j + 1; k < length && k - j < 4; k++) {
                    String first = ips.substring(0, i);
                    String second = ips.substring(i, j);
                    String third = ips.substring(j, k);
                    String four = ips.substring(k);
                    if (four.length() >= 4 || !check(four) || !check(third) || !check(second) || !check(first)) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(first).append(".").append(second).append(".").append(third).append(".").append(four);
                    return sb.toString();
                }
            }
        }
        return "";
    }

    private static boolean check(String ip) {
        return !((ip.length() >= 2 && ip.charAt(0) != 0) || ip.length() >= 4);
    }


    private Node mergeNode(Node left, Node right) {
        Node root = new Node(0);
        Node current = root;
        while (left != null && right != null) {
            if (left.value > right.value) {
                current.next = right;
                right = right.next;
            }
            if (right.value > left.value) {
                current.next = left;
                left = left.next;
            }
            current=current.next;
        }
        current.next = right == null ? left : right;
        return root.next;
    }


    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
