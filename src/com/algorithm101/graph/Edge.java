package com.algorithm101.graph;

public class Edge<T> implements Comparable<Edge<T>> {
  private Node<T> first;
  private Node<T> second;
  private int weight;

  public Edge(final Node<T> first, final Node<T> second) {
    this.first = first;
    this.second = second;
  }

  public Node<T> getFirst() {
    return this.first;
  }

  public void setFirst(final Node<T> first) {
    this.first = first;
  }

  public Node<T> getSecond() {
    return this.second;
  }

  public void setSecond(final Node<T> second) {
    this.second = second;
  }

  public int getWeight() {
    return this.weight;
  }

  public void setWeight(final int weight) {
    this.weight = weight;
  }

  @Override
  public int compareTo(final Edge<T> o) {
    if (this.weight < o.weight) {
      return -1;
    } else if (this.weight > o.weight) {
      return 1;
    } else {
      return 0;
    }
  }
}
