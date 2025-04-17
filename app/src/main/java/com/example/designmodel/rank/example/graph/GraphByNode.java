package com.example.designmodel.rank.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于邻接表实现的无向图
 * <p>
 * Created by WangMaoBo.
 * Date: 2025/4/17
 */
public class GraphByNode {
    public static void main(String[] args) {
        //1<->3<->2<->5<->4
        int[][] edges = new int[4][2];
        edges[0][0] = 1;
        edges[0][1] = 3;
        edges[1][0] = 3;
        edges[1][1] = 2;
        edges[2][0] = 2;
        edges[2][1] = 5;
        edges[3][0] = 5;
        edges[3][1] = 4;
        GraphByNode graph = new GraphByNode(edges);
        graph.printGraph();
    }

    private static final String TAG = "GraphByNode";
    // 邻接表，key：顶点，value：该顶点的所有邻接顶点
    Map<Integer, List<Integer>> nodes;

    public GraphByNode(int[][] edges) {
        nodes = new HashMap<>();
        for (int[] edge : edges) {
            // 添加所有顶点和边
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    public void addEdge(int edge1, int edge2) {
        if (!nodes.containsKey(edge1) || !nodes.containsKey(edge2) || edge2 == edge1) {
            throw new IllegalArgumentException();
        }
        // 添加边 edge1 - edge2
        nodes.get(edge1).add(edge2);
        nodes.get(edge2).add(edge1);
    }

    public void removeEdge(int edge1, int edge2) {
        if (!nodes.containsKey(edge1) || !nodes.containsKey(edge2) || edge2 == edge1) {
            throw new IllegalArgumentException();
        }
        nodes.get(edge1).remove(edge2);
        nodes.get(edge2).remove(edge1);
    }

    public void addVertex(int key) {
        if (nodes.containsKey(key)) {
            return;
        }
        nodes.put(key, new ArrayList<>());
    }

    public void removeVertex(int key) {
        if (!nodes.containsKey(key))
            throw new IllegalArgumentException();
        // 在邻接表中删除顶点 vet 对应的链表
        nodes.remove(key);
        for (List<Integer> list : nodes.values()) {
            list.remove(key);
        }
    }

    public int size() {
        return nodes.size();
    }

    public void printGraph() {
        System.out.println("邻接表 =");
        for (Map.Entry<Integer, List<Integer>> pair : nodes.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer vertex : pair.getValue())
                tmp.add(vertex);
            System.out.println(pair.getKey() + ": " + tmp + ",");
        }
    }
}
