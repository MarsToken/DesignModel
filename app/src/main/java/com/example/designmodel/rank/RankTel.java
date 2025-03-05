package com.example.designmodel.rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * des
 *
 * @author WangMaoBo
 * @constructor 创建此类对象的主构造函数
 * @since 2024/12/12
 */
public class RankTel {
    private static final String TAG = "RankTel";

    public static void main(String[] args) {
        System.out.println("main");
        int array[] = {9, 10, 2, 3, -2, 8, 8};
        // bubble(array);
        // selectRank(array);
        // insertRank(array);
        shellRank(array);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(",");
        }
        System.out.println(sb);
    }

    public static void shellRank(int[] array) {
        int length = array.length;
        int gap = length;
        do {
            gap /= 2;
            for (int i = gap; i < length - 1; i++) {
                int tempMax = i;
                int current = array[i + 1];
                while (tempMax >= 0 && array[tempMax] > current) {
                    array[tempMax + 1] = array[tempMax];
                    tempMax--;
                }
                array[tempMax + 1] = current;
            }
        } while (gap > 0);
    }

    public static void insertRank(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int tempMax = i; // current是已经排好序的最大（最小）右侧索引，左侧都是排好序的。
            int current = array[i + 1];
            while (tempMax >= 0 && array[tempMax] > current) {
                array[tempMax + 1] = array[tempMax];
                tempMax--;
            }
            array[tempMax + 1] = current;
        }
    }

    public static void selectRank(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            int tempMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[tempMin] > array[j]) {
                    flag = true;
                    tempMin = j;
                }
            }
            if (tempMin != i) {
                int temp = array[tempMin];
                array[tempMin] = array[i];
                array[i] = temp;
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static int[] mergeSort(int array[]) {
        int length = array.length;
        if (length < 2) {
            return array;
        }
        int mid = length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, left_index = 0, right_index = 0; i < result.length; i++) {
            if (left_index >= left.length) {
                result[i] = right[right_index++];
            } else if (right_index >= right.length) {
                result[i] = left[left_index++];
            } else if (left[left_index] > right[right_index]) {
                result[i] = right[right_index++];
            } else {
                result[i] = left[left_index++];
            }
        }
        return result;
    }

    /**
     * 分支思想：构建dfs！
     *
     * @param array
     * @param searchElement
     * @return
     */
    public static int binarySearch(int[] array, int searchElement) {
        if (array.length < 1) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > searchElement) {
                right = mid - 1;
            } else if (array[mid] < searchElement) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 前序排序：根左右
     * 中序排序：左根右
     * pre        in区间
     * root       i         (l,r)
     * left子树   i+1       (l,m-1)
     * right子树  i+1+(m-l) (m+1,r)
     */
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return dfs(preOrder, map, 0, 0, preOrder.length - 1);
    }

    private TreeNode dfs(int[] preOrder, HashMap<Integer, Integer> inOrderMap, int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preOrder[root]);
        int middle = inOrderMap.get(preOrder[root]);
        treeNode.left = dfs(preOrder, inOrderMap, root + 1, left, middle - 1);
        treeNode.right = dfs(preOrder, inOrderMap, root + 1 + middle - left, middle + 1, right);
        return treeNode;
    }

    class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 1.f(n-1):left -> mid  right(buffer)
     * 2.f(1):left -> right
     * 3.f(n-1):mid->right  left(buffer)
     */
    private static void moveTower(int index, List<Integer> left, List<Integer> mid, List<Integer> right) {
        if (index == 0) {
            move(left, right);
            return;
        }
        moveTower(index - 1, left, right, mid);
        move(left, right);
        moveTower(index - 1, mid, left, right);
    }

    private static void move(List<Integer> src, List<Integer> target) {
        Integer pan = src.remove(src.size() - 1);
        target.add(pan);
    }
}
