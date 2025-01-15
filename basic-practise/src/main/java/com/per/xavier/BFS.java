package com.per.xavier;

import java.util.LinkedList;
import java.util.*;

/**
 * @author Xavier
 * @date 2025/1/17 15:03
 */
public class BFS {

    static class Node {
        Object val;
        private List<Node> children;

        public Node(Object val, List<Node> children) {
            this.val = val;
            this.children = children;
        }

        public Object getVal() {
            return val;
        }

        public void setVal(Object val) {
            this.val = val;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }

    public static List<Object> bfs(Node node) {

        List result = new ArrayList();
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                result.add(current.val);
                List<Node> children = current.getChildren();
                if (children == null) {
                    continue;
                }
                for (Node child : children) {
                    if (visited.contains(child)) {
                        continue;
                    }
                    queue.offer(child);
                    visited.add(child);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node n3 = new Node(3, null);
        List<Node> child3 = new ArrayList<>();
        child3.add(n3);

        Node n2 = new Node(2, null);
        Node n21 = new Node(21, null);
        Node n22 = new Node(22, null);
        List<Node> child2 = new ArrayList<>();
        child2.add(n2);
        child2.add(n21);
        child2.add(n22);

        Node n1 = new Node(1, null);
        List<Node> child1 = new ArrayList<>();
        child1.add(n1);

        n3.setChildren(child1);
        n2.setChildren(child3);
        n1.setChildren(child2);
        List<Object> res = bfs(n1);
        for (Object re : res) {
            System.out.println(re);
        }
    }
}
