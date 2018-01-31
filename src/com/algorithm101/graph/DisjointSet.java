package com.algorithm101.graph;

import java.util.HashMap;
import java.util.Map;

/*
 * DisjoinSet implementation
 */
public class DisjointSet<T> {
  Map<T, Node<T>> map = new HashMap<>();

  public void makeSet(final T data) {

    final Node<T> node = new Node<>(data, false);
    node.rank = 0;
    node.parent = node;
    this.map.put(data, node);
  }

  public Node<T> findSet(final Node<T> node) {
    final Node<T> parent = node.parent;
    if (node == parent) {
      return node;
    }
    return this.findSet(parent);
  }

  public boolean unionFind(final T data1, final T data2) {
    final Node<T> node1 = this.map.get(data1);
    final Node<T> node2 = this.map.get(data2);

    Node<T> parent1 = this.findSet(node1);
    Node<T> parent2 = this.findSet(node2);

    if (parent1 == parent2) {
      return false;
    }

    if (parent1.rank > parent2.rank) {
      parent2 = parent1;
    } else {
      if (parent1.rank == parent2.rank) {
        parent2.rank = parent2.rank + 1;
      }
      parent1 = parent2;
    }
    return true;
  }
}
