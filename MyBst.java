// **********************************************************************************
// Title: Major Project
// Author: Kelin Argueta
// Course Section: CMIS202-ONL1 (Seidel) Spring 2023
// **********************************************************************************

package dst;

public class MyBst<Tp extends Comparable<Tp>> {

    private Node root;

    private class Node {
        Tp data;
        Node left;
        Node right;
        public Node(Tp data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(Tp data) {
        root = insert(root, data);
    }

    private Node insert(Node current, Tp data) {
        if (current == null) {
            return new Node(data);
        }
        if (data.compareTo(current.data) < 0) {
            current.left = insert(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insert(current.right, data);
        }
        return current;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node node) {
        if (node != null) {
            traverse(node.left);
            System.out.println(node.data);
            traverse(node.right);
        }
    }
}