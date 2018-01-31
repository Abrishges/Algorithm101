package com.algorithm101.graph;

class Node<T> {
  T data;
  boolean visited;
  int rank = 0;
  Node<T> parent;

  public Node(final T data, final boolean visited) {
    this.data = data;
    this.visited = visited;
  }

  public T getData() {
    return this.data;
  }

  public void setData(final T data) {
    this.data = data;
  }

  public boolean isVisited() {
    return this.visited;
  }

  public void setVisited(final boolean visited) {
    this.visited = visited;
  }

  public int getRank() {
    return this.rank;
  }

  public void setRank(final int rank) {
    this.rank = rank;
  }

  public Node<T> getParent() {
    return this.parent;
  }

  public void setParent(final Node<T> parent) {
    this.parent = parent;
  }

  @Override
  public String toString() {
    return "Node [data=" + this.data + ", visited=" + this.visited + ", rank=" + this.rank + ", parent=" + this.parent
        + "]";
  }
}
