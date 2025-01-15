package com.per.leetcode.round.first.no707;

/**
 * https://leetcode.cn/problems/design-linked-list/
 *
 * @author Xavier
 * @date 2024/11/27 15:26
 */
public class MyLinkedList<T> {

    private final Node<T> head, tail;

    private int size;

    class Node<T> {
        private T val;
        private Node<T> prev;
        private Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public int get(int index) {
        return 0;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
