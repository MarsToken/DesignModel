package com.example.designmodel.rank.example.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于邻接矩阵的无向图
 * <p>
 * Created by WangMaoBo.
 * Date: 2025/4/17
 */
public class GraphByMatrix {
    public static void main(String[] args) {
        int[] vertices = new int[]{1, 3, 2, 5, 4};
        //1<->3<->2<->5<->4
        int[][] edges = new int[4][2];
        edges[0][0]=0;
        edges[0][1]=1;
        edges[1][0]=1;
        edges[1][1]=2;
        edges[2][0]=2;
        edges[2][1]=3;
        edges[3][0]=3;
        edges[3][1]=4;
        GraphByMatrix graph = new GraphByMatrix(vertices, edges);
        graph.printGraph();
    }

    private static final String TAG = "Graph";
    // 定点列表
    List<Integer> vertices;
    // 邻接矩阵，表示边
    List<List<Integer>> matrix;

    public GraphByMatrix(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.matrix = new ArrayList<>();
        // 添加定点，包括新增一行和一列
        for (int val : vertices) {
            addVertice(val);
        }
        // 添加边
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    /**
     * 添加边
     */
    public void addEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new IllegalArgumentException("非法参数:i=" + i + ",j=" + j);
        }
        // 这个是无向图，所以是对称的
        matrix.get(i).set(j, 1);
        matrix.get(j).set(i, 1);
    }

    /**
     * 删除边
     */
    public void removeEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new IllegalArgumentException("非法参数:i=" + i + ",j=" + j);
        }
        matrix.get(i).set(j, 0);
        matrix.get(j).set(i, 0);
    }

    /**
     * 获取顶点总数
     */
    public int size() {
        return this.vertices.size();
    }

    /**
     * 添加顶点
     * <p>
     * 1.顶点入队
     * 2.邻接矩阵添加一行
     * 3.邻接矩阵添加一列
     */
    public void addVertice(int val) {
        vertices.add(val);
        int n = size();
        System.out.println("n=" + n);
        List<Integer> newRow = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            newRow.add(0);
        }
        // 加一行
        matrix.add(newRow);
        for (List<Integer> row : matrix) {
            // 加一列，此判断是为了第一次添加列比行多1问题
            if (matrix.size() == row.size() + 1) {
                row.add(0);
            }

        }
    }

    /**
     * 删除顶点
     * <p>
     * 1.顶点出队
     * 2.删除index行
     * 3.删除index列
     */
    public void removeVertice(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("index 越界:" + index);
        }
        vertices.remove(index);
        matrix.remove(index);
        for (List<Integer> row : matrix) {
            row.remove(index);
        }
    }

    public void printGraph() {
        System.out.println("顶点：");
        System.out.println(vertices);
        System.out.println("邻接矩阵：");
        for (List<Integer> matrixElement : matrix) {
            System.out.println(matrixElement);
        }

    }

}
