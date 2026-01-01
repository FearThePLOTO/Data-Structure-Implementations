public class Queue<item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        item data;
        Node next;
    }

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(item data) {
        Node oldLast = last;
        last = new Node();
        last.data = data;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        item data = first.data;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return data;
    }

    public item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return first.data;
    }
}
