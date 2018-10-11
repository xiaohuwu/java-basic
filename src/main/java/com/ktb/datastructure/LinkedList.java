package com.ktb.datastructure;

/**
 * Created by dell on 2018-10-11.
 */
//链表
public class LinkedList {
    private Node head;
    private LinkedList() {

    }
    public void setHead(Node head) {
        this.head = head;
    }
    //遍历
    public void printLinkList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + "\t");
            current = current.getNext();
        }
        System.out.println();
    }

    public void addAtHead(Node node) {
        node.setNext(head);
        this.head = node;
    }

    public void insertAtEnd(Node node) {
        Node current = head;
        Node need = null;
        while (current != null) {
            need = current;
            current = current.getNext();
        }
        need.setNext(node);
    }

    private void addAfter(Node<String> newNode, Node<String> node1) {
        Node next = node1.getNext();
        node1.setNext(newNode);
        newNode.setNext(next);
    }
    private void deletNode(Node<String> node1) {
        Node current = head;
        Node beforeNode = null;
        while (current != null && current.getNext() != null) {
            if (current.getNext().equals(node1)) {
                beforeNode = current;
            }
            current = current.getNext();
        }
        Node next = node1.getNext();
        beforeNode.setNext(next);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        Node<String> node = new Node<>();
        node.setData("张三");

        Node<String> node1 = new Node<>();
        node1.setData("李四");

        Node<String> node2 = new Node<>();
        node2.setData("王五");
        linkedList.setHead(node2);

        linkedList.insertAtEnd(node1);
        linkedList.insertAtEnd(node);
        linkedList.printLinkList();
        linkedList.deletNode(node1);
        linkedList.printLinkList();
    }

}
