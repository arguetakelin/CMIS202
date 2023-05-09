package dst;

import java.util.ArrayList;
import java.util.List;

public class
MyLinkedList<Tp> {
    private Node head;

    public int indexOf(Tp exercise) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(exercise)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void set(int index, Tp exercise) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = head;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        if (current != null) {
            current.data = exercise;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<Tp> getList() {
        List<Tp> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    private class Node {
        Tp data;
        Node next;

        public Node(Tp data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(Tp data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void remove(Tp data) {
        if (head == null) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void clear() {
        head = null;
    }

}
