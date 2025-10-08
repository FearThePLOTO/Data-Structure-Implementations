// package LinkedListImp.src;

public class LinkedList {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void delete(int key) {
        Node current = head, prev = null;

        if (current != null && current.data == key) {
            head = current.next; // Changed head
            size--;
            return;
        }

        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) return; // Key not found

        prev.next = current.next; // Unlink the node
        size--;
    }

    public boolean contains(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(int key) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == key) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Key not found
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, int data) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void clear() {
        head = null;
        size = 0;
    }
}