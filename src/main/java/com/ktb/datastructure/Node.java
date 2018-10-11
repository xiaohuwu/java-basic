package com.ktb.datastructure;

/**
 * Created by dell on 2018-10-11.
 */
//链表
public class Node<T> {
    private T data;
    private Node node;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return node;
    }


    public void setNext(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", node=" + node +
                '}';
    }
}
