package com.algorithm101.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 * Graph implementation, using adjacency lists
 * - DFS
 * - BFS
 * - clearNodes
 * - addEdges
 */
public class Graph<T> {
  Map<Node<T>, List<Node<T>>> map = new HashMap<>();
  Map<Node<T>, List<Edge<T>>> mapEdges = new HashMap<>();
  List<Edge<T>> listOfEdges = new ArrayList<>();

  // constructing adjacency list using HashMap
  public void insertAdjList(final Node<T> node1, final Node<T> node2) {
    List<Node<T>> adjList;
    if (this.map.containsKey(node1)) {
      adjList = this.map.get(node1);
      adjList.add(node2);
    } else {
      adjList = new ArrayList<>();
      adjList.add(node2);
    }
    this.map.put(node1, adjList);

    List<Node<T>> adjList2;
    if (this.map.containsKey(node2)) {
      adjList2 = this.map.get(node2);
      adjList2.add(node1);
    } else {
      adjList2 = new ArrayList<>();
      adjList2.add(node1);
    }
    this.map.put(node2, adjList2);

    // store edges in a map
    this.addEdges(node1, node2);
  }

  // Add Edges to map (optional method )
  public void addEdges(final Node<T> node1, final Node<T> node2) {
    final List<Edge<T>> adjList;
    if (this.mapEdges.containsKey(node1)) {
      adjList = this.mapEdges.get(node1);
      adjList.add(new Edge<>(node1, node2));
    } else {
      adjList = new ArrayList<>();
      adjList.add(new Edge<>(node1, node2));
    }
    this.mapEdges.put(node1, adjList);

    final List<Edge<T>> adjList2;
    if (this.mapEdges.containsKey(node2)) {
      adjList2 = this.mapEdges.get(node2);
      adjList2.add(new Edge<>(node2, node1));
    } else {
      adjList2 = new ArrayList<>();
      adjList2.add(new Edge<>(node2, node1));
    }
    this.mapEdges.put(node2, adjList2);

    // store list of edges
    this.listOfEdges.add(new Edge<>(node1, node2));
  }

  // DFS implementation
  public void dfs(final Node<T> root) {
    final Stack<Node<T>> stack = new Stack<>();
    stack.push(root);
    root.visited = true;
    System.out.println(root.data);

    while (!stack.isEmpty()) {
      final Node<T> currentNode = stack.peek();
      final Node<T> child = this.unvisitedChildNode(currentNode);

      if (child != null) {
        System.out.println(child.data);
        child.visited = true;
        stack.push(child);
      } else {
        stack.pop();
      }
    }
  }

  // Get unvisited child node from adjList
  public Node<T> unvisitedChildNode(final Node<T> node) {
    final Node<T> unvisitedNode = this.map.get(node).stream().filter(child -> !child.visited).findFirst().orElse(null);
    return unvisitedNode;
  }

  // BFS implementation
  public void bfs(final Node<T> root) {
    final Queue<Node<T>> queue = new LinkedList<>();
    queue.add(root);
    root.visited = true;
    System.out.println(root.data);

    while (!queue.isEmpty()) {
      final Node<T> currentNode = queue.poll();
      this.map.get(currentNode).stream().filter(node -> !node.visited).forEach(element -> {
        System.out.println(element.data);
        queue.add(element);
        element.visited = true;
      });
    }
  }

  // clear all visited nodes
  public void clearNode() {
    this.map.keySet().forEach(node -> node.visited = false);
  }

  public Map<Node<T>, List<Node<T>>> getAlladjList() {
    return this.map;
  }

  // DFS cycle detection
  public boolean hasCycle() {
    final Set<Node<T>> nodes = this.map.keySet();
    for (final Node<T> node : nodes) {
      if (node.visited) {
        continue;
      }
      if (this.hasCycleUtil(node, null)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasCycleUtil(final Node<T> root, final Node<T> parent) {
    final List<Node<T>> adjList = this.map.get(root);
    root.visited = true;
    for (final Node<T> node : adjList) {

      if (node.equals(parent)) {
        continue;
      }

      if (node != parent && node.visited) {
        return true;
      }
      final boolean visited = this.hasCycleUtil(node, root);
      if (visited) {
        return true;
      }
    }
    return false;
  }
}
