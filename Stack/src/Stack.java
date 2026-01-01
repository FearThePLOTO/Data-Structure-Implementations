public class Stack<item> {
    private item[] arr;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        arr = (item[]) new Object[size];
        capacity = size;
        top = -1;
    }

    public void push(item element) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = element;
    }

    public item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }

    public item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }
}
