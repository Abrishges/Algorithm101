package com.algorithm101.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestBFSDFS {

  public static void main(final String[] args) {
    final Node<String> nodeA = new Node<>("A", false);
    final Node<String> nodeB = new Node<>("B", false);
    final Node<String> nodeC = new Node<>("C", false);
    final Node<String> nodeD = new Node<>("D", false);
    final Node<String> nodeE = new Node<>("E", false);
    final Node<String> nodeF = new Node<>("F", false);

    // inserting edges , seven edges
    final Graph<String> graph = new Graph<>();
    graph.insertAdjList(nodeA, nodeB);
    graph.insertAdjList(nodeA, nodeD);
    graph.insertAdjList(nodeA, nodeF);
    graph.insertAdjList(nodeB, nodeC);
    graph.insertAdjList(nodeC, nodeD);
    graph.insertAdjList(nodeD, nodeE);
    graph.insertAdjList(nodeE, nodeF);

    // graph printing adjacency list
    final Map<Node<String>, List<Node<String>>> map = graph.getAlladjList();
    map.entrySet().forEach(
        (entry -> System.out.println("Key: " + entry.getKey().data + ", value: " + entry.getValue())));

    // DFS traversal
    System.out.println("******    DFS   *******");
    graph.dfs(nodeA);

    // clear Nodes
    graph.clearNode();

    // BFS Traversal
    System.out.println("*****    BFS    *******");
    graph.bfs(nodeA);

    // clear Nodes
    graph.clearNode();

    // check if it has cycle
    System.out.println("we found cycle: " + graph.hasCycle());

    // DisjointSet test
    final DisjointSet<String> disjointSet = new DisjointSet<>();
    final Set<Node<String>> nodes = map.keySet();
    for (final Node<String> node : nodes) {
      disjointSet.makeSet(node.data);
    }



  }
}
