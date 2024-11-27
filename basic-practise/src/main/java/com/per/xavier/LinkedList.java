package com.per.xavier;

/**
 * @author Xavier
 * @date 2024/11/27 13:59
 */
public class LinkedList<T> {

    private LinkedNode head;

    private LinkedNode tail;


    /**
     * 节点
     */
    class LinkedNode {

        private T val;

        public LinkedNode prev;
        public LinkedNode next;

        public LinkedNode(T val) {
            this.val = val;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }
    }

    public void addToHead(T value) {
        LinkedNode toInsert = new LinkedNode(value);
        if (head == null) {
            head = toInsert;
            tail = toInsert;
            return;
        }
        toInsert.next = head;
        head.prev = toInsert;
        head = toInsert;
    }

    public void addToTail(T value) {
        LinkedNode toInsert = new LinkedNode(value);
        if (tail == null) {
            head = toInsert;
            tail = toInsert;
            return;
        }

        // 指向前尾节点
        toInsert.prev = tail;
        tail.next = toInsert;
        // toInsert.prev指向tail后，就好像toInsert.prev指向了地址代号为tail的实际地址998，而现在将tail重新赋值为999，不影响toInsert已经指向的前后节点
        tail = toInsert;
    }


    public void add(int index, T value) {
        if (head == null) {
            return;
        }
        LinkedNode p = head;
        for (int i = 1; i < index; i++) {
            p = p.next;
        }
        LinkedNode newNode = new LinkedNode(value);
        newNode.next = p.next;
        newNode.prev = p;
        p.next.prev = newNode;
        p.next = newNode;
    }


    public void delete(T value) {
        LinkedNode cur = head;
        LinkedNode toDelete = null;
        while (cur != null) {
            if (cur.val == value) {
                toDelete = cur;
                break;
            }
            cur = cur.next;
        }
        if (toDelete != null) {
            if (toDelete.prev == null) {
                head = toDelete.next;
                toDelete.next.prev = null;
            } else if (toDelete.next == null) {
                toDelete.prev.next = null;
            } else {
                toDelete.prev.next = toDelete.next;
                toDelete.next.prev = toDelete.prev;
            }
        }
    }


    @Override
    public String toString() {
        LinkedNode p = head;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            System.out.println("print:" + p.val);
            sb.append("|\t").append(p.prev != null ? p.prev.val + "<-" : "").append(p.val).append(p.next != null ? "->" + p.next.val : "");
            p = p.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addToTail(1);
        linkedList.addToTail(2);
        linkedList.addToTail(3);
        linkedList.addToTail(4);
        linkedList.addToTail(5);
        linkedList.addToHead(0);
        linkedList.add(2, 22);

        System.out.println(linkedList);
        linkedList.delete(22);
        System.out.println(linkedList);
    }

}
