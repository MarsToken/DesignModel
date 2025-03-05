package com.example.designmodel.rank;

import com.example.designmodel.datastructure.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hp on 2020/2/10.
 */
public class TestRank {
    public static int[] array = new int[]{123, 4, 55, 3111, 334, 6, 2, 1};

    public static void main(String[] args) {
        //bubbleRank();
        //selectRank();
        //insertSort2();
        //shellSort2();
        //int[] array = mergeSort(TestRank.array);
        //quickSort(array, 0, array.length - 1);
        //heapSort();
        //radixRank();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    private static void radixRank() {
        int length = array.length;
        if (length < 1) {
            return;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxBit = 0;
        while (max != 0) {
            max /= 10;
            maxBit++;
        }
        ArrayList<ArrayList<Integer>> queue_out = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queue_out.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxBit; i++) {
            for (int j = 0; j < length; j++) {
                int x = (int) (array[j] % Math.pow(10, i + 1) / Math.pow(10, i));
                queue_out.get(x).add(array[j]);
            }
            int count = 0;
            for (int j = 0; j < 10; j++) {
                ArrayList<Integer> queue_inner = queue_out.get(j);
                while (queue_inner.size() > 0) {
                    array[count] = queue_inner.get(0);
                    queue_inner.remove(0);
                    count++;
                }
            }
        }

    }

    private static void heapSort() {


    }

    private static void quickSort(int[] array, int start, int end) {
        int length = array.length;
        if (start < 0 || end >= length || start > end || length == 0) return;
        int limitIndex = partition(array, start, end);//确定基准，limitIndex为比基准小的总数的索引+1（即基准的索引）
        if (start < limitIndex) {
            quickSort(array, start, limitIndex - 1);
        }
        if (limitIndex < end) {
            quickSort(array, limitIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = (int) ((end - start + 1) * Math.random() + start);
        swap(array, pivot, end);
        int limitIndex = start - 1;//因为把基准放到了最右侧
        for (int i = start; i <= end; i++) {
            if (array[end] >= array[i]) {
                limitIndex++;
                if (i > limitIndex) {
                    swap(array, limitIndex, i);//互换的是为了保证中间值左边都比他小，右边都比他大
                }
            }
        }
        return limitIndex;
    }

    private static void swap(int[] array, int pivot, int end) {
        if (pivot == end) return;
        array[pivot] += array[end];
        array[end] = array[pivot] - array[end];
        array[pivot] = array[pivot] - array[end];
    }

    /**
     * 时间复杂度 nlogn
     *
     * @param array
     * @return
     */
    private static int[] mergeSort(int[] array) {
        int length = array.length;
        if (length < 2) return array;
        int mid = length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, length);
        return merge(mergeSort(left), mergeSort(right));

    }

    private static int[] merge(int[] left, int[] right) {
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

    private static void test() {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    private static void shellSort2() {
        int length = array.length, gap = length;
        do {
            gap /= 2;
            for (int i = gap; i < length - 1; i++) {
                int current = array[i + 1];
                int index = i;
                while (index >= 0 && array[index] > current) {
                    array[index + 1] = array[index];
                    index--;
                }
                array[index + 1] = current;
            }
        } while (gap > 0);

    }

    private static void insertSort2() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int j = i;
            int current = array[i + 1];
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    private static void shellSort() {
        int length = array.length, mid = length;
        do {
            mid /= 2;
            System.out.println("mid=" + mid);
            for (int i = mid; i < length - 1; i++) {
                int temp = i + 1;
                for (int j = 0; j < temp; j++) {
                    if (array[temp] < array[j]) {//由于序列是排好的，所以理论上只会走一次
                        array[temp] += array[j];
                        array[j] = array[temp] - array[j];
                        array[temp] = array[temp] - array[j];
                    }
                }
            }
        } while (mid > 0);
    }

    private static void insertSort() {//非主流，实际上还是特殊的选择排序
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int temp = i + 1;
            for (int j = 0; j < temp; j++) {
                if (array[temp] < array[j]) { // 由于序列是排好的，所以理论上只会走一次
                    array[temp] += array[j];
                    array[j] = array[temp] - array[j];
                    array[temp] = array[temp] - array[j];
                }
            }
        }
    }

    private static void selectRank() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    flag = true;
                    array[i] += array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static void bubbleRank() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] += array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 分支思想，分而治之。
     * 满足：1.主问题可拆分为有穷个子问题 2.子问题相互独立 3.子问题可合并为主问题
     * 步骤：自上而下分发，自下而上求解
     * 案例：1.归并排序 2.二分查找 3.二叉树构建 4.汉诺塔
     * 应用题：
     */
    // ==================================================================================================
    private static int binarySearch(int[] array, int searchElement) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (searchElement < array[mid]) {
                right = mid + 1;
            } else if (searchElement > array[mid]) {
                left = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * root节点在pre数组的索引 子树在in数组的索引区间
     * 根            i,               (l,r)
     * 左子树        i+1,           (l,m(i)-1)
     * 右子树       i+1+(m(i)-l),      (m(i)+1,r)
     * 备注：m为通过pre的root节点i推算出来的in的root节点
     * 已知前序排序和中序排序数组，构建二叉树
     */
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return dfs(preOrder, map, 0, 0, inOrder.length - 1);
    }

    /**
     * 从0构建新的二叉树
     */
    private TreeNode dfs(int[] preOrder, HashMap<Integer, Integer> inOrderMap, int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preOrder[root]);
        int inOrderRotIndex = inOrderMap.get(preOrder[root]);
        treeNode.left = dfs(preOrder, inOrderMap, root + 1, left, inOrderRotIndex - 1);
        treeNode.right = dfs(preOrder, inOrderMap, root + 1 + inOrderRotIndex - left, inOrderRotIndex + 1, right);
        return treeNode;
    }

    /**
     * 1.f(n-1):left -> mid  right(buffer)
     * 2.f(1):left -> right
     * 3.f(n-1):mid->right  left(buffer)
     */
    private static void moveTowerDfs(int index, List<Integer> left, List<Integer> mid, List<Integer> right) {
        if (index == 0) {
            move(left, right);
            return;
        }
        moveTowerDfs(index - 1, left, right, mid);
        move(left, right);
        moveTowerDfs(index - 1, mid, left, right);
    }

    private static void move(List<Integer> src, List<Integer> target) {
        Integer pan = src.remove(src.size() - 1);
        target.add(pan);
    }


}
